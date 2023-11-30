package kafka.producer.location.reference.service;


import kafka.producer.location.reference.domain.city.AlternateCode;
import kafka.producer.location.reference.domain.city.Country;
import kafka.producer.location.reference.domain.city.ResponseCity;
import kafka.producer.location.schema.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {

    private static final String LOCATION_REFRENCE_TOPIC = "location_refrence";

//  private static  final String LOCATION_REFRENCE_TOPIC=" teamA.locationref.topic.internal.any.v1";

    @Autowired
    KafkaTemplate<String, RequestCity> kafkaTemplate;

    public Mono<ResponseCity> process(kafka.producer.location.reference.domain.city.RequestCity cityData, HttpHeaders httpHeaders) {

        List<AlternateCodeAvro> alternateCodes = cityData.getAlternateCodes().stream()
                .map(referenceAlternateCode -> {
                    AlternateCodeAvro schemaAlternateCode = new AlternateCodeAvro();
                    schemaAlternateCode.setCode(referenceAlternateCode.getCode());
                    schemaAlternateCode.setCodeType(referenceAlternateCode.getCodeType());
                    return schemaAlternateCode;
                })
                .collect(Collectors.toList());

        List<BdaAvro> bdasList = Optional.ofNullable(cityData.getBdas())
                .map(bdas -> bdas.stream()
                        .map(referenceBda -> {
                            BdaAvro bdasAvro = new BdaAvro();
                            bdasAvro.setBdaType(referenceBda.getBdaType());
                            bdasAvro.setName(referenceBda.getName());
                            bdasAvro.setType(referenceBda.getType());
                            // Assuming alternateCodes is a List in your context
                            bdasAvro.setAlternateCodes(alternateCodes);
                            return bdasAvro;
                        })
                        .collect(Collectors.toList())
                )
                .orElse(Collections.emptyList());

        if (cityData.getCountry() == null) {
            cityData.setCountry(Country.builder()
                    .name("Brazil")
                    .alternateCodes(List.of(AlternateCode.builder()
                            .code("33YYZ8LYAH9XA")
                            .codeType("locationId")
                            .build()))
                    .build());
        }
        List<AlternateCodeAvro> alternateCodesCountry = Optional.ofNullable(cityData.getCountry())
                .map(country -> country.getAlternateCodes().stream()
                        .map(refrenceAlternateCode -> {
                            AlternateCodeAvro alternateCode = new AlternateCodeAvro();
                            alternateCode.setCode(refrenceAlternateCode.getCode());
                            alternateCode.setCodeType(refrenceAlternateCode.getCodeType());
                            return alternateCode;
                        })
                        .collect(Collectors.toList())
                )
                .orElseGet(() -> {



                    return null;
                });


        CountryAvro countryAvro = new CountryAvro();
        countryAvro.setAlternateCodes(alternateCodesCountry);
        countryAvro.setName(cityData.getName());



        List<ParentAvro> alternateCodeAvrosParent = Optional.ofNullable(cityData.getParents())
                .orElse(Collections.emptyList())
                .stream()
                .map(refrenceParent -> {
                    List<AlternateCodeAvro> alternateCodeAvroParentList = Optional.ofNullable(refrenceParent.getAlternateCodes())
                            .orElse(Collections.emptyList())
                            .stream()
                            .map(refrenceParentAlternateCode -> {
                                AlternateCodeAvro alternateCodeAvroParent = new AlternateCodeAvro();
                                alternateCodeAvroParent.setCode(refrenceParentAlternateCode.getCode());
                                alternateCodeAvroParent.setCodeType(refrenceParentAlternateCode.getCodeType());
                                log.info("Alternate Code {}: ", alternateCodeAvroParent);
                                return alternateCodeAvroParent;
                            })
                            .collect(Collectors.toList());

                    ParentAvro parentAvro = new ParentAvro();
                    parentAvro.setName(refrenceParent.getName());
                    parentAvro.setBdaType("BDA");
                    parentAvro.setType(refrenceParent.getType());
                    parentAvro.setAlternateCodes(alternateCodeAvroParentList);

                    return parentAvro;
                })
                .collect(Collectors.toList());

        log.info("Parentes: {}", alternateCodeAvrosParent.toString());




        RequestCity requestCityAvro= RequestCity.builder()
                .locationId(cityData.getLocationId())
                .status(cityData.getStatus())
                .bdaType(cityData.getBdaType())
                .country(countryAvro)
                .geoType(cityData.getGeoType())
                .parents(alternateCodeAvrosParent)
                .name(cityData.getName())
                .validTo(cityData.getValidTo())
                .hsudName(cityData.getHsudName()).latitude(cityData.getLatitude())
                .portFlag(cityData.isPortFlag())
                .timeZone(cityData.getTimeZone())
                .longitude(cityData.getLongitude())
                .validFrom(cityData.getValidFrom())
                .restricted(cityData.getRestricted())
                .description(cityData.getDescription())
                .dialingCode(cityData.getDialingCode())
               // .bdaLocations(cityData.getBdaLocations())
                .isMaerskCity(cityData.isMaerskCity())
                .olsonTimezone(cityData.getOlsonTimezone())
                .bdas(bdasList)
                .alternateCodes(alternateCodes)
//                .alternateNames(List.of("Harshit"))
                .subCityParents(cityData.getSubCityParents())
                .utcOffsetMinutes(cityData.getUtcOffsetMinutes())
                .workaroundReason(cityData.getWorkaroundReason())
                .daylightSavingEnd(cityData.getDaylightSavingEnd())
                .daylightSavingTime(cityData.getDaylightSavingTime())
                .daylightSavingStart(cityData.getDaylightSavingStart())
                .postalCodeMandatory(cityData.getPostalCodeMandatory())
                .dialingCodeDescription(cityData.getDialingCodeDescription())
                .stateProvinceMandatory(cityData.getStateProvinceMandatory())
                .daylightSavingShiftMinutes(cityData.getDaylightSavingShiftMinutes())
                .build();

        return Mono.fromSupplier(() -> {

                    String fileName = httpHeaders.getFirst("blobitem");
                    log.info("Sending the file {}", fileName);

                    try {
                       kafkaTemplate.send(LOCATION_REFRENCE_TOPIC,requestCityAvro);
                        log.info("Message sent to Kafka location_reference topic");
                    } catch (SerializationException e) {
                        log.error("Error serializing data for Kafka", e);
                        throw e;
                    }


                    return ResponseCity
                            .builder()
                            .requestCity(cityData)
                            .createdBy("TEST-SYSTEM")
                            .createdAt(LocalDateTime.now())
                            .result("SUCCESS")
                            .build();
                })
                .flatMap(responseCity -> {
                    return Mono.just(responseCity);
                });

    }

//    public Mono<ResponseCity> sendMessageToKafka(List<String> cityData, ServerHttpRequest serverRequest) {
//        for (String message : cityData) {
//            log.info("Json data {}", message);
//            ProducerRecord<String, String> record = new ProducerRecord<>(LOCATION_REFRENCE_TOPIC, message);
//            kafkaTemplate.send(record);
//        }
//        return Mono.just(ResponseCity.builder().build());
//    }





}





// return Mono.fromSupplier(() -> {
//        log.info(cityData.getBdaLocations());
//
//        kafkaTemplate.send(LOCATION_REFRENCE_TOPIC, String.valueOf(cityData));
//
//
//        log.info("Message sent to Kafka!");
//        return ResponseCity
//                .builder()
//                .requestCity(cityData)
//                .createdBy("TEST-SYSTEM")
//                .createdAt(LocalDateTime.now())
//                .result("SUCCESS")
//                .build();
//    })
//            .flatMap(responseCity -> {
//        return Mono.just(responseCity);
//    });
//
//}

