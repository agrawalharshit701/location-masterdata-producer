package kafka.producer.location.reference.controller;

import kafka.producer.location.reference.domain.city.RequestCity;
import kafka.producer.location.reference.domain.city.ResponseCity;
import kafka.producer.location.reference.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/kafka/api/v1/")
@Slf4j
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaProducerService producerService;
    @PostMapping("/transferSingleFile")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseCity> sendMessageToKafka(@RequestBody RequestCity cityData, ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        headers.forEach((key, value) -> log.info("Header Key: {} {}" , key + ", Value: " , value));
        return producerService.process(cityData ,headers);
    }

//    @PostMapping("/sentMultipleFileInBatches")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<String> sendMessageToKafka(@RequestBody List<String> cityData, ServerHttpRequest request) {
//       producerService.sendMessageToKafka(cityData,request);
//       return Mono.just("SUCCESS");
//    }

}
