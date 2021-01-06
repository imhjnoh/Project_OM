package main.info;

public class ISS {

    private int oxygen;
    private int gravity;
    private int electricity;

    public ISS() {
        oxygen = 100;
        gravity = 100;
        electricity = 100;
    }

    public ISS(int oxygen, int gravity, int electricity) {
        this.oxygen = oxygen;
        this.gravity = gravity;
        this.electricity = electricity;
    }

    public int getOxygen() {
        return oxygen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }
}
