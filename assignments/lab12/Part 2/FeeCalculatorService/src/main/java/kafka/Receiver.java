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

    @KafkaListener(topics = {"ownertopic"})
    public void receive(@Payload OwnerInfo ownerInfo,
                        @Headers MessageHeaders headers) {
        System.out.println("OwnerInfo received message= " + ownerInfo);
        int amount = 25;
        double speed = ownerInfo.getRecord().getSpeed();
        if(speed > 90){
            amount = 125;
        } else if (speed > 82){
            amount = 80;
        } else if (speed > 77) {
            amount = 45;
        }
        FeeFastSpeed fee = new FeeFastSpeed(ownerInfo.getRecord().getRecord().licencePlate, ownerInfo,
                speed, amount);
        System.out.println("Fee fast: " + fee);
    }

}