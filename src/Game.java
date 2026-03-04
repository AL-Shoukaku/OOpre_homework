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
                    this.AddBottle(adv,op.get(2), Integer.parseInt(op.get(3)));
                    break;
                case "ae":
                    this.AddEquipment(adv,op.get(2));
                    break;
                case "rb":
                    this.RemoveBottle(adv,op.get(2));
                    break;
                case "re":
                    this.RemoveEquipment(adv,op.get(2));
                    break;
                default:
            }
        }
    }

    public void AddAdventure(String id) {
        Adventure adv = new Adventure(id);
        this.adventures.add(adv);
    }

    public void AddBottle(Adventure adv,String bottleId,int effect) {
        Bottle bottle = new Bottle(bottleId,effect);
        adv.AddBottle(bottle);
    }

    public void AddEquipment(Adventure adv,String equipmentId) {
        Equipment equip = new Equipment(equipmentId);
        adv.AddEquipment(equip);
    }

    public void RemoveBottle(Adventure adv,String bottleId) {
        Bottle bottle = adv.FindBottle(bottleId);
        adv.RemoveBottle(bottleId);
        System.out.println(adv.getBottles().size() + " " + bottle.getEffect());
    }

    public void RemoveEquipment(Adventure adv,String equipmentId) {
        adv.RemoveEquipment(equipmentId);
        System.out.println(adv.getEquipments().size());
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
