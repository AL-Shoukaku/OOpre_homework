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
                    this.AddEquipment(adv,op.get(2));
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
        Bottle bottle;
        switch (type) {
            case "HpBottle":
                bottle = new HpBottle(bottleId,effect);
                break;
            case "AtkBottle":
                bottle = new AtkBottle(bottleId,effect);
                break;
            case "DefBottle":
                bottle = new DefBottle(bottleId,effect);
                break;
            default:
                bottle = new ManaBottle(bottleId,effect);
        }
        adv.AddBottle(bottle);
    }

    public void AddEquipment(Adventure adv,String equipmentId) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        Equipment equip = new Equipment(equipmentId);
        adv.AddEquipment(equip);
    }

    public void LearnSpell(Adventure adv,String spellId,String type,int cost,int power) {
        if (adv.getAttribute("hp") <= 0) {
            System.out.println(adv.getId() + " is dead!");
            return;
        }
        Spell spell;
        if (type.equals("AttackSpell")) {
            spell = new AttackSpell(spellId,cost,power);
        } else {
            spell = new HealSpell(spellId,cost,power);
        }
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

    public Adventure FindAdventure(String id) {
        for (Adventure adv : this.adventures) {
            if (adv.getId().equals(id)) {
                return adv;
            }
        }
        return null;
    }

}
