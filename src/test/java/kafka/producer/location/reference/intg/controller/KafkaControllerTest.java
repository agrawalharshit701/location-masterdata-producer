//package kafka.producer.location.reference.intg.controller;
//
//import kafka.producer.location.reference.domain.city.RequestCity;
//import kafka.producer.location.reference.domain.city.ResponseCity;
//import kafka.producer.location.reference.exceptionHandler.model.ErrorClass;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//import java.util.Objects;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
//@AutoConfigureWebTestClient
//@Slf4j
//class KafkaControllerTest {
//
//    @Autowired
//    private WebTestClient webTestClient;
//    static String LOCATION_REFERENCE_KAFKA_POST = "/kafka/send";
//
//    @Test
//    void produceDataToKafkaTopic() {
//        webTestClient
//             .post()
//             .uri(LOCATION_REFERENCE_KAFKA_POST)
//             .contentType(MediaType.APPLICATION_JSON)
//             .bodyValue(RequestCity.builder().geoType("City").build())
//             .exchange()
//             .expectStatus()
//             .is2xxSuccessful()
//             .expectBody(ErrorClass.class)
//             .consumeWith(errorEntityExchangeResult -> {
//              var errorClass = Objects.requireNonNull(errorEntityExchangeResult.getResponseBody());
//                 log.info("Key {}" ,errorClass.getKey());
//                 log.info("Value {}" ,errorClass.getValue());
//             });
//    }
//    @Test
//    void produceDataToKafkaTopic_geoTypeValidation() {
//
//        webTestClient
//                .post()
//                .uri(LOCATION_REFERENCE_KAFKA_POST)
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(RequestCity.builder().geoType("").build())
//                .exchange()
//                .expectStatus()
//                .is4xxClientError()
//                .expectBody(ResponseCity.class)
//                .consumeWith(stringEntityExchangeResult -> {
//                    var cityInfo = Objects.requireNonNull(stringEntityExchangeResult.getResponseBody());
//                    log.info("CITYINFO : {}",cityInfo);
//                });
//    }
//
//}