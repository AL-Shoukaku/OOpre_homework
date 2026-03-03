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

        game.AddBottle(adv1,"b1",110);
        game.AddBottle(adv2,"b2",120);
        game.AddBottle(adv3,"b3",130);
        game.AddBottle(adv4,"b4",140);
        game.AddBottle(adv5,"b5",150);
        game.AddBottle(adv1,"b6",160);
        game.AddBottle(adv2,"b7",170);
        game.AddBottle(adv1,"b8",180);

        game.AddEquipment(adv1,"e1");
        game.AddEquipment(adv2,"e2");
        game.AddEquipment(adv3,"e3");
        game.AddEquipment(adv4,"e4");
        game.AddEquipment(adv5,"e5");
        game.AddEquipment(adv5,"e6");
        game.AddEquipment(adv5,"e7");
        game.AddEquipment(adv3,"e8");
    }

    @Test
    public void testRemove() {
        game.RemoveEquipment(adv3,"e8");
        game.RemoveEquipment(adv5,"e5");
        game.RemoveEquipment(adv1,"e1");
        assertEquals(1,adv3.getEquipments().size());
        assertEquals(0,adv1.getEquipments().size());
        assertEquals(2,adv5.getEquipments().size());

        game.RemoveBottle(adv1,"b8");
        game.RemoveBottle(adv2,"b2");
        game.RemoveBottle(adv4,"b4");
        assertEquals(2,adv1.getBottles().size());
        assertEquals(1,adv2.getBottles().size());
        assertEquals(0,adv4.getBottles().size());
    }
}