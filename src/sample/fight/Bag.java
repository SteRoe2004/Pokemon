package sample.fight;

public class Bag {

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;

    public Bag(Item item1, Item item2, Item item3, Item item4){
    setItem1(item1);
    setItem2(item2);
    setItem3(item3);
    setItem4(item4);
    }

    public Item getItem1() {
        return item1;
    }

    public Item getItem2() {
        return item2;
    }

    public Item getItem3() {
        return item3;
    }

    public Item getItem4() {
        return item4;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public void setItem3(Item item3) {
        this.item3 = item3;
    }

    public void setItem4(Item item4) {
        this.item4 = item4;
    }
}
