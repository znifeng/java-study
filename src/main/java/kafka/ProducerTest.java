package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerTest {
    public static void main(String[] args){
        String broker = "10.120.196.15:9092";
        String topic = "test";
        String msg;
        Properties props = new Properties();
        props.put("bootstrap.servers", broker);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i=0; i<10; i++){
            msg = "hello znifeng for times: " + i;
            producer.send(new ProducerRecord<String, String>(topic, msg));
        }

        //flush(): Invoking this method makes all buffered records immediately available to send
        // (even if linger.ms is greater than 0) and blocks on the completion of the requests associated with these records.
//        producer.flush();
        producer.close();
    }

}
