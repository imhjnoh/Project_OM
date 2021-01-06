package main.info;

import java.util.ArrayList;

public class Player {
    private int sleep;
    private int hungry;
    private int health;
    private int temperature;
    private int injury;

    private int sceneNum;
    private ArrayList<Item> inventory;  // max size: 5

    public Player() {
        sleep = 100;
        hungry = 100;
        health = 100;
        temperature = 50;
        injury = 0;

        sceneNum = 0;
        inventory = new ArrayList<>();
    }

    //for Opening saved Data
    public Player(int sleep, int hungry, int health, int temperature, int injury, int sceneNum, ArrayList<Item> inventory) {
        this.sleep = sleep;
        this.hungry = hungry;
        this.health = health;
        this.temperature = temperature;
        this.injury = injury;

        this.sceneNum = sceneNum;
        for (Item i: inventory) {
            this.inventory.add(i);
        }
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getInjury() {
        return injury;
    }

    public void setInjury(int injury) {
        this.injury = injury;
    }

    public int getSceneNum() {
        return sceneNum;
    }

    public void setSceneNum(int sceneNum) {
        this.sceneNum = sceneNum;
    }
}
