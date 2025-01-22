package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class VoteConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "results-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("votes"));

        System.out.println("Listening for votes...");
        Map<String, Integer> voteCounts = new HashMap<>();

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                voteCounts.put(record.value(), voteCounts.getOrDefault(record.value(), 0) + 1);
                System.out.println("Current Results: " + voteCounts);
            }
        }
    }
}

