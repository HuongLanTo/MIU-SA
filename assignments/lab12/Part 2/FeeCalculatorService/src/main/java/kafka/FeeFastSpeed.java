package kafka;

public class FeeFastSpeed {
    private String licensePlate;
    private OwnerInfo ownerInfo;
    private double speed;
    private int amount;

    public FeeFastSpeed(String licensePlate, OwnerInfo ownerInfo, double speed, int amount) {
        this.licensePlate = licensePlate;
        this.ownerInfo = ownerInfo;
        this.speed = speed;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FeeFastSpeed{" +
                "licensePlate='" + licensePlate + '\'' +
                ", ownerInfo=" + ownerInfo +
                ", speed=" + speed +
                ", amount=" + amount + "$ "+
                '}';
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public OwnerInfo getOwnerInfo() {
        return ownerInfo;
    }

    public void setOwnerInfo(OwnerInfo ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
