import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;  // 导入所有静态断言方法

public class GameTest {
    Game game=new Game();
    ArrayList<String> str1;
    ArrayList<String> str2;
    ArrayList<String> str3;

    Adventure adv1;
    Adventure adv2;
    Adventure adv3;
    Adventure adv4;
    Adventure adv5;

    @BeforeEach
    public void setUp(){
        game.AddAdventure("shoukaku");
        game.AddAdventure("amagi");
        game.AddAdventure("mike");
        game.AddAdventure("shaun");
        game.AddAdventure("jack");  //五个冒险者

        adv1 = game.FindAdventure("shoukaku");
        adv2 = game.FindAdventure("amagi");
        adv3 = game.FindAdventure("mike");
        adv4 = game.FindAdventure("shaun");
        adv5 = game.FindAdventure("jack");

        game.AddBottle(adv1,"b1","HpBottle",110);
        game.AddBottle(adv2,"b2","HpBottle",120);
        game.AddBottle(adv3,"b3","HpBottle",130);
        game.AddBottle(adv4,"b4","HpBottle",140);
        game.AddBottle(adv5,"b5","DefBottle",150);
        game.AddBottle(adv1,"b6","ManaBottle",160);
        game.AddBottle(adv2,"b7","HpBottle",170);
        game.AddBottle(adv1,"b8","AtkBottle",180);

        game.AddEquipment(adv1,"e1");
        game.AddEquipment(adv2,"e2");
        game.AddEquipment(adv3,"e3");
        game.AddEquipment(adv4,"e4");
        game.AddEquipment(adv5,"e5");
        game.AddEquipment(adv5,"e6");
        game.AddEquipment(adv5,"e7");
        game.AddEquipment(adv3,"e8");

        game.TakeItem(adv1,"b1");
        game.TakeItem(adv2,"b2");
        game.TakeItem(adv3,"b3");
        game.TakeItem(adv4,"b4");
        game.TakeItem(adv5,"b5");
        game.TakeItem(adv1,"b6");
        game.TakeItem(adv2,"b7");
        game.TakeItem(adv1,"b8");

        game.LearnSpell(adv1,"Fire","AttackSpell",5,100);
        game.LearnSpell(adv1,"Freeze","AttackSpell",8,120);
        game.LearnSpell(adv2,"Heal","HealSpell",4,200);
    }

    @Test
    public void testUse() {
        adv1.UseItem(adv1,"b1");
        assertEquals(610,adv1.getAttribute("hp"));
        adv1.UseItem(adv2,"b8");
        assertEquals(181,adv2.getAttribute("atk"));
        assertEquals(1,adv1.getBottles().size());
        adv5.UseItem(adv1,"b5");
        assertEquals(150,adv1.getAttribute("def"));

        adv1.UseItem(adv3,"Freeze");
        assertEquals(380,adv3.getAttribute("hp"));
        assertEquals(2,adv1.getAttribute("mana"));
        adv2.UseItem(adv5,"Heal");
        assertEquals(700,adv5.getAttribute("hp"));
        assertEquals(6,adv2.getAttribute("mana"));
    }

    @Test
    public void testRemoveItem(){
        adv1.RemoveItem("b1");
        assertEquals(2,adv1.getBottles().size());
    }

}