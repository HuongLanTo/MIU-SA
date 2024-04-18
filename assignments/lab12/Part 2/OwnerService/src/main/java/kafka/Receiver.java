package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Receiver {

    @Autowired
    Sender sender;

    @KafkaListener(topics = {"tofasttopic"})
    public void receive(@Payload SpeedRecord speedRecord,
                        @Headers MessageHeaders headers) {
        System.out.println("Receiver1 received message= " + speedRecord);
        String name = "nameSample" + speedRecord.getSpeed();
        OwnerInfo ownerInfo = new OwnerInfo(name, speedRecord);
        sender.send("ownertopic", ownerInfo);
    }

}