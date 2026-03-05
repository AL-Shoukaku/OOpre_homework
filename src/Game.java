import java.util.ArrayList;

public class Game {
    private ArrayList<Adventure> adventures = new ArrayList<>();

    public Game() {
    }

    public void StartGame(int n,ArrayList<ArrayList<String>> operate) {
        for (int i = 0;i < n;i++) {
            ArrayList<String> op = operate.get(i);
            Adventure adv = this.FindAdventure(op.get(1));
            switch (op.get(0)) {
                case "aa":
                    this.AddAdventure(op.get(1));
                    break;
                case "ab":
                    this.AddBottle(adv,op.get(2),op.get(3),Integer.parseInt(op.get(4)));
                    break;
                case "ae":
                    this.AddEquipment(adv,op.get(2),op.get(3),Integer.parseInt(op.get(4)));
                    break;
                case "ls":
                    int power = Integer.parseInt(op.get(4));
                    this.LearnSpell(adv,op.get(2),op.get(3),power,Integer.parseInt(op.get(5)));
                    break;
                case "ti":
                    this.TakeItem(adv,op.get(2));
                    break;
                case "ri":
                    this.RemoveItem(adv,op.get(2));
                    break;
                case "use":
                    this.Use(adv,op.get(2),op.get(3));
                    break;
                case "bi":
                    this.BuyItem(adv,op.get(2),op.get(3));
                    break;
                case "fight":
                    this.Fight(adv,Integer.parseInt(op.get(2)),op);
                    break;
                default:
            }
        }
    }

    public void AddAdventure(String id) {
        Adventure adv = new Adventure(id);
        this.adventures.add(adv);
    }

    public void AddBottle(Adventure adv,String bottleId,String type,int effect) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        Bottle bottle = Factory.createBottle(bottleId,type,effect);
        adv.AddBottle(bottle);
    }

    public void AddEquipment(Adventure adv,String equipmentId,String type,int ce) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        Equipment equip = Factory.createEquipment(equipmentId,type,ce);
        adv.AddEquipment(equip);
    }

    public void LearnSpell(Adventure adv,String spellId,String type,int cost,int power) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        Spell spell =  Factory.createSpell(spellId,type,cost,power);
        adv.LearnSpell(spell);
    }

    public void TakeItem(Adventure adv,String itemId) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        String type = adv.TakeItem(itemId);
        System.out.println(type);
    }

    public void RemoveItem(Adventure adv,String itemId) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        String type = adv.RemoveItem(itemId);
        System.out.println(type);
    }

    public void Use(Adventure adv,String usableId,String targetId) {
        Adventure target = FindAdventure(targetId);
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        } else if (target.getAttribute("hp") <= 0) {
            System.out.println(target.getId() + " is dead!");
            return;
        }
        adv.UseItem(target,usableId);
    }

    public void BuyItem(Adventure adv,String itemId,String type) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        System.out.println(adv.BuyItem(itemId,type));
    }

    public void Fight(Adventure adv,int n,ArrayList<String> targetId) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        ArrayList<Adventure> targets = new ArrayList<>();
        int maxDef = 0;
        for (int i = 0; i < n; i++) {
            Adventure target = FindAdventure(targetId.get(i + 3));
            if (adv.getAttribute("hp") <= 0) {
                System.out.println(adv.getId() + " is dead!");
                return;
            }
            if (target.getDef() > maxDef) {
                maxDef = target.getDef();//计算整体防御
            }
            targets.add(target);
        }
        if (adv.fight(maxDef,targets)) {
            for (Adventure target : targets) {
                System.out.print(target.getAttribute("hp") + " ");
            }
            System.out.print("\n");
        } else {
            System.out.println("Adventurer " + adv.getId() + " defeated");
        }
    }

    public Adventure FindAdventure(String id) {
        for (Adventure adv : this.adventures) {
            if (adv.getId().equals(id)) {
                return adv;
            }
        }
        return null;
    }

}
