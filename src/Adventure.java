import java.util.ArrayList;

public class Adventure {
    private String id;
    private ArrayList<Bottle> bottles = new ArrayList<>();
    private ArrayList<Equipment> equipments = new ArrayList<>();

    public Adventure(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Bottle> getBottles() {
        return bottles;
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public void AddBottle(Bottle bottle) {
        bottles.add(bottle);
    }

    public void AddEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    public void RemoveBottle(String bottleId) {
        Bottle bottle = this.FindBottle(bottleId);
        bottles.remove(bottle);
    }

    public void RemoveEquipment(String equipmentId) {
        Equipment equipment = this.FindEquipment(equipmentId);
        equipments.remove(equipment);
    }

    public Bottle FindBottle(String bottleId) {
        for (Bottle bottle : bottles) {
            if (bottle.getId().equals(bottleId)) {
                return bottle;
            }
        }
        System.out.println("没要找到瓶子！");
        return null;
    }

    public Equipment FindEquipment(String equipmentId) {
        for (Equipment equipment : equipments) {
            if (equipment.getId().equals(equipmentId)) {
                return equipment;
            }
        }
        System.out.println("没有找到装备！");
        return null;
    }
}
