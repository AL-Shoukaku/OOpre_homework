import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;  // 导入所有静态断言方法

class AdventureTest {
    Adventure adv1;
    Adventure adv2;
    Adventure adv3;
    Bottle b1;
    Bottle b2;
    Bottle b3;
    Bottle b4;
    Equipment e1;
    Equipment e2;
    Equipment e3;
    @BeforeEach
    public void setUp() {
        adv1 = new Adventure("shoukaku");
        adv2 = new Adventure("amagi");
        adv3 = new Adventure("mike");
        b1 = new Bottle("b1",100);
        b2 = new Bottle("b2",200);
        b3 = new Bottle("b3",150);
        b4 = new Bottle("b4",300);
        e1 = new Equipment("e1");
        e2 = new Equipment("e2");
        e3 = new Equipment("e3");
    }

    @Test
    public void testGetId() {
        assertEquals("shoukaku",adv1.getId());
        assertEquals("amagi",adv2.getId());
        assertEquals(0,adv3.getBottles().size());
    }
}