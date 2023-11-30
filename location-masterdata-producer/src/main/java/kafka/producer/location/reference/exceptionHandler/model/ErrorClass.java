package kafka.producer.location.reference.exceptionHandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorClass {

    @JsonProperty("key")
    String key;
    @JsonProperty("value")
    String value;
}
