package kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaUtils {
    private static final String TOPIC = "votes";

    public static void publishVote(String candidate) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>(TOPIC, candidate));
        producer.close();
    }
}

