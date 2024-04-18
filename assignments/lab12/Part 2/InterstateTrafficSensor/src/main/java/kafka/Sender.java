package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, SensorRecord> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, SpeedRecord> kafkaTemplateSpeed;

    public void send(String topic, SensorRecord sensorRecord){
        kafkaTemplate.send(topic, sensorRecord);
    }

    public void send(String topic, SpeedRecord speedRecord) {
        kafkaTemplateSpeed.send(topic, speedRecord);
    }
}
