package main.info;

public class Item {

    private String name;
    private int hungerPlus;
    private int healthPlus;

    public Item(String name, int hungerPlus, int healthPlus) {
        this.name = name;
        this.hungerPlus = hungerPlus;
        this.healthPlus = healthPlus;

    }

    public String getName() {
        return name;
    }

    public int getHungerPlus() {
        return hungerPlus;
    }

    public int getHealthPlus() {
        return healthPlus;
    }
}
