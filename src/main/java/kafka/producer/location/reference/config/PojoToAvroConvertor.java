package kafka.producer.location.reference.config;


import kafka.producer.location.reference.domain.city.RequestCity;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;


@Service
@Slf4j
public class PojoToAvroConvertor implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Schema schema= ReflectData.get().getSchema(RequestCity.class);
        log.info("Schema Data {}",schema );
        try {

            String filePath = "src/main/resources/avro/RequestCityAvro.avsc";


            File file = new File(filePath);


            FileOutputStream outputStream = new FileOutputStream(file);
            schema.toString(true);
            outputStream.write(schema.toString(true).getBytes());

            // Close the output stream
            outputStream.close();
        }
        catch (Exception e)
        {
            log.info("Exception during creating avro schema is :" ,e);
        }
    }

}
