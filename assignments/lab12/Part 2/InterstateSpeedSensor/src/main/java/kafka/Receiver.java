package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Receiver {

    @Autowired
    Sender sender;

    Map<String, SensorRecord> cam1 = new HashMap<>();
    Map<String, SensorRecord> cam2 = new HashMap<>();

    @KafkaListener(topics = {"cameratopic1" , "cameratopic2"})
    public void receive(@Payload SensorRecord sensorRecord,
                        @Headers MessageHeaders headers) {
        System.out.println("Receiver received message= " + sensorRecord + " with header: " + headers);
        if(sensorRecord.getCameraId() == 1 && !cam1.containsKey(sensorRecord.getLicencePlate())){
            cam1.put(sensorRecord.getLicencePlate(), sensorRecord);
        } else if(cam1.containsKey(sensorRecord.getLicencePlate())){
            //record from cam2
            SensorRecord cam1Record = cam1.get(sensorRecord.getLicencePlate());
            int sec = sensorRecord.getSecond() - cam1Record.getSecond();
            int min = sensorRecord.getMinute() - cam1Record.getMinute();
            sec += min * 60; //total seconds
            double mph = (0.5 / sec) * 3600;
            if(mph >= 72){
                SpeedRecord speedRecord = new SpeedRecord(mph);
                speedRecord.setRecord(sensorRecord);
                System.out.println("This plate is too fast: " + sensorRecord.licencePlate);
                sender.send("tofasttopic", speedRecord);
            }
        } else {
            //cam 1 not found
            System.out.println("This plate is not in cam 1: " + sensorRecord.licencePlate);
            cam2.put(sensorRecord.getLicencePlate(), sensorRecord);
        }

    }
}