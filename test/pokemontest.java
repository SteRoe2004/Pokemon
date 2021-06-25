import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sample.fight.Attack;
import sample.fight.FightController;
import sample.fight.Type;
import sample.start.StartController;
import sample.stats.AttackLib;


public class pokemontest {

    private static AttackLib lib;

    @BeforeClass
    public static void initTestFight() {
        lib = new AttackLib();
    }

    @Test
    public void amountofattacks() {
        Assert.assertEquals(3, lib.getAttacks(Type.FIRE, 3).size());
    }

    @Test
    public void amountofattacks1(){
        Assert.assertEquals(5, lib.getAttacks(Type.GRASS,5).size());
    }

    @Test
    public void type(){
        Assert.assertEquals(Type.GRASS, lib.getAttacks(Type.GRASS, 3).get(2).getType());
    }

    @Test
    public void amountofattacks3(){
        Assert.assertEquals(0, lib.getAttacks(Type.GRASS,0).size());
    }

}





