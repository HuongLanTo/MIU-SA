package kafka;

public class OwnerInfo {
    private String name;

    private SpeedRecord record;

    public OwnerInfo(String name, SpeedRecord sensorRecord) {
        this.name = name;
        this.record = sensorRecord;
    }

    public SpeedRecord getRecord() {
        return record;
    }

    public void setRecord(SpeedRecord record) {
        this.record = record;
    }
}
