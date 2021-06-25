package sample.fight;

import java.awt.*;
import java.util.List;

public class Pokemon {

    private String name;
    private int speed;
    private int currentHP;
    private int maxHP;

    private Type type;

    private Attack attack1;
    private Attack attack2;
    private Attack attack3;
    private Attack attack4;

    public Pokemon(String name, int speed, int currentHP, int maxHP, Type type, List<Attack> list){
        setAttack1(list.get(0));
        setAttack2(list.get(1));
        setAttack3(list.get(2));
        setAttack4(list.get(3));
        setCurrentHP(currentHP);
        setMaxHP(maxHP);
        setType(type);
        setSpeed(speed);
        setName(name);
    }
        // Constructor Î

    public Attack getAttack1() {
        return attack1;
    }

    public Attack getAttack2() {
        return attack2;
    }

    public Attack getAttack3() {
        return attack3;
    }

    public Attack getAttack4() {
        return attack4;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setAttack1(Attack attack1) {
        this.attack1 = attack1;
    }

    public void setAttack2(Attack attack2) {
        this.attack2 = attack2;
    }

    public void setAttack3(Attack attack3) {
        this.attack3 = attack3;
    }

    public void setAttack4(Attack attack4) {
        this.attack4 = attack4;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
