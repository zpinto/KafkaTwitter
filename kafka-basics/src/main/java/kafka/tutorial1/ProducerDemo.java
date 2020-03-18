package kafka.tutorial1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {

        String bootstrapServers = "127.0.0.1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // type of the key that we are passing to Kafka
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // type of the value that we are passing to Kafka
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        // create the producer

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // create a producer record
        final ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "hello_world");

        // send the data - asynchronous
        producer.send(record);

        // will wait for producer to write
        producer.flush();
        producer.close();

        System.out.println("Hello World");
    }
}
