package src.Playable;

import java.util.ArrayList;
import java.util.List;
import src.Joker.Joker;

public abstract class Playable {
    private int healthPoint ;
    private String name;
    private List<Joker> inventory;

    public Playable(String name){
        this.inventory = new ArrayList<>();
        this.name = name;
        this.healthPoint = 5;

        //init inventory
        this.inventory = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int setHealthPoint(int value){
        this.healthPoint =  value;
        return healthPoint;
    }

    public int getHealthPoint(){
        return this.healthPoint;
    }

    public boolean isAlive(){
        if(healthPoint <= 0){
            return false;
        }else{
            return true;
        }
    }

    public int addHealthPoint(int value) {
        this.healthPoint += value;
        return this.healthPoint ;
    }

    public void reload(){
        int size = this.inventory.size();
        for (int i = size; i<2 ; i++){
            this.inventory.add(new Joker());
        }
    }
    
}
