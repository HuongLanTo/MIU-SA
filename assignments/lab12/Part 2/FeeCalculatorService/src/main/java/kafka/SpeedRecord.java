package kafka;

public class SpeedRecord {
    private double speed;
    private SensorRecord record;


    public SpeedRecord() {
    }

    public SpeedRecord(double speed, SensorRecord record) {
        this.speed = speed;
        this.record = record;
    }

    public SensorRecord getRecord() {
        return record;
    }

    public void setRecord(SensorRecord record) {
        this.record = record;
    }

    public SpeedRecord(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "SpeedRecord{" +
                "speed=" + speed +
                ", record=" + record +
                '}';
    }
}
