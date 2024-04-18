package kafka;

public class SpeedRecord {
    private double speed;

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
                '}';
    }
}
