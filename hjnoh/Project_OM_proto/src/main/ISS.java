package main;

public class ISS {
    private String name;
    private int oxygen;
    private int gravity;
    private int electricity;

    public void setName(String name) {
        this.name = name;
    }
    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }
    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public String getName() {
        return name;
    }
    public int getOxygen() {
        return oxygen;
    }
    public int getGravity() {
        return gravity;
    }
    public int getElectricity() {
        return electricity;
    }

    public ISS(String name, int oxygen, int gravity, int electricity){
        this.name = name;
        this.oxygen = oxygen;
        this.gravity = gravity;
        this.electricity = electricity;
    }
}
