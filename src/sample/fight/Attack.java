package sample.fight;

public class Attack {

    private String name;
    private int damage;
    private Type type;

    public Attack(String name, int damage, Type type){
        setName(name);
        setDamage(damage);
        setType(type);
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    public Type getType(){
        return type;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public void setType(Type type){
        this.type = type;
    }

}
