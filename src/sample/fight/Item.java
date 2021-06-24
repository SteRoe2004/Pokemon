package sample.fight;

public class Item {

    private String name;
    private int heal;

    public Item(String name, int heal){
        setName (name);
        setHeal (heal);
    }

    public int getHeal() {
        return heal;
    }

    public String getName() {
        return name;
        }


    public void setName(String name){
        this.name = name;
        }

    public void setHeal(int heal){
        this.heal = heal;
    }
}
