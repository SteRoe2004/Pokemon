package sample.stats;

import sample.fight.Attack;
import sample.fight.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttackLib {
    public static Map<Type,List> attackLib;

    public AttackLib() {
        initAttacks();
    }

    public static Map<Type,List> getInstance(){
        return  attackLib;
    }

    public static List<Attack> getAttacks(Type type, int numberOfAttacks) {
        List<Attack> attacksByType = AttackLib.getInstance().get(type);
        List ret = new ArrayList();

        //get a attack from 0 to end of list
        //do this numberOfAttacks amount of times
        for (int i=0; i < numberOfAttacks; i++) {
            ret.add(attacksByType.get((int) (Math.random() * attacksByType.size())));
        }
        return ret;
    }

    public static void initAttacks(){
        attackLib = new HashMap<>();
        List<Attack> grasslist = new ArrayList();
        List<Attack> firelist = new ArrayList();
        List<Attack> waterlist = new ArrayList();

        grasslist.add(new Attack("Vine Whip", 45, Type.GRASS));
        grasslist.add(new Attack("Petal Dance", 120, Type.GRASS));;
        grasslist.add(new Attack("Razor Leaf", 70, Type.GRASS));
        grasslist.add(new Attack("Solar Beam", 120, Type.GRASS));
        grasslist.add(new Attack("Leaf Tornado", 55, Type.GRASS));
        grasslist.add(new Attack("Giga Drain", 75, Type.GRASS));
        grasslist.add(new Attack("Leaf Blade", 90, Type.GRASS));
        grasslist.add(new Attack("Leaf Storm", 135, Type.GRASS));

        firelist.add(new Attack("Fire Blast", 125, Type.FIRE));
        firelist.add(new Attack("Heat Crash", 110, Type.FIRE));
        firelist.add(new Attack("Flame Charge", 60, Type.FIRE));
        firelist.add(new Attack("Flamethrower", 100, Type.FIRE));
        firelist.add(new Attack("Ember", 40, Type.FIRE));
        firelist.add(new Attack("Flare Blitz", 120, Type.FIRE));
        firelist.add(new Attack("Heatwave", 95, Type.FIRE));
        firelist.add(new Attack("Inferno", 100, Type.FIRE));

        waterlist.add(new Attack("Water Pulse", 45, Type.WATER));
        waterlist.add(new Attack("Razor Shell", 90, Type.WATER));
        waterlist.add(new Attack("Aquajet", 65, Type.WATER));
        waterlist.add(new Attack("Aquatail", 100, Type.WATER));
        waterlist.add(new Attack("Dive", 80, Type.WATER));
        waterlist.add(new Attack("Water Gun", 40, Type.WATER));
        waterlist.add(new Attack("Hydro Pump", 110, Type.WATER));
        waterlist.add(new Attack("Surf", 90, Type.WATER));

        attackLib.put(Type.GRASS,grasslist);
        attackLib.put(Type.GRASS,grasslist);
        attackLib.put(Type.GRASS,grasslist);
        attackLib.put(Type.GRASS,grasslist);
        attackLib.put(Type.GRASS,grasslist);
        attackLib.put(Type.GRASS,grasslist);
        attackLib.put(Type.GRASS,grasslist);
        attackLib.put(Type.GRASS,grasslist);
        attackLib.put(Type.FIRE,firelist);
        attackLib.put(Type.FIRE,firelist);
        attackLib.put(Type.FIRE,firelist);
        attackLib.put(Type.FIRE,firelist);
        attackLib.put(Type.WATER,waterlist);
        attackLib.put(Type.WATER,waterlist);
        attackLib.put(Type.WATER,waterlist);
        attackLib.put(Type.WATER,waterlist);
        attackLib.put(Type.WATER,waterlist);
        attackLib.put(Type.WATER,waterlist);
        attackLib.put(Type.WATER,waterlist);
        attackLib.put(Type.WATER,waterlist);
        attackLib.put(Type.FIRE,firelist);
        attackLib.put(Type.FIRE,firelist);
        attackLib.put(Type.FIRE,firelist);
        attackLib.put(Type.FIRE,firelist);
    }
}

