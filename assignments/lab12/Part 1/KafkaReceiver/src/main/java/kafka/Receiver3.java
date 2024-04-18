package kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver3 {
    @KafkaListener(topics = {"topicB"})
    public void receive(@Payload String message) {
        System.out.println("Receiver received B message= " + message);
    }
}
