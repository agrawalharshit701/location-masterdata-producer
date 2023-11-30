package kafka.producer.location.reference.exceptionHandler;

import kafka.producer.location.reference.exceptionHandler.model.ErrorClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.KafkaException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ErrorClass> handleRequestBodyError(WebExchangeBindException ex){
        log.error("Exception caught in handleRequestBodyError :  {} " ,ex.getMessage(),  ex);
        String error = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .sorted()
                .collect(Collectors.joining(","));
        log.error("errorList : {}", error);
       ErrorClass errorClass= ErrorClass.builder().key("Bad Request").value(error).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorClass);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        log.error("Exception caught in handleKafkaException :  {} " ,ex.getMessage(),  ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
    @ExceptionHandler(KafkaException.class)
    public ResponseEntity<String> handleKafkaException(KafkaException ex) {
        log.error("Exception caught in handleKafkaException :  {} " ,ex.getMessage(),  ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
