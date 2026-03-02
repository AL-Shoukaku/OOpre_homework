import java.util.ArrayList;

public class Adventure {
    private final String id;
    private ArrayList<Bottle> bottleArray =  new ArrayList<>();
    private ArrayList<Equipment> equipmentArray =  new ArrayList<>();
    private int equipmentnum = 0;
    private int bottlenum = 0;

    public Adventure(String name) {
        this.id = name;
    }

    public void AddEquipment(String name) {
        Equipment equipment = new Equipment(name);
        this.equipmentArray.add(equipment);
        this.equipmentnum++;
    }

    public void AddBottle(String name,int effect) {
        Bottle bottle = new Bottle(name,effect);
        this.bottleArray.add(bottle);
        this.bottlenum++;
    }

    public void RemoveBottle(String name) {
        for (Bottle bottle : this.bottleArray) {
            if (bottle.getId().equals(name)) {
                bottlenum--;
                System.out.printf("%d %d%n",bottlenum,bottle.getEffect());
                this.bottleArray.remove(bottle);
                break;
            }
        }
    }

    public void RemoveEquipment(String name) {
        for (Equipment equipment : this.equipmentArray) {
            if (equipment.getId().equals(name)) {
                equipmentnum--;
                System.out.printf("%d%n",equipmentnum);
                this.equipmentArray.remove(equipment);
                break;
            }
        }
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Bottle> getBottleArray() {
        return this.bottleArray;
    }

    public ArrayList<Equipment> getEquipmentArray() {
        return this.equipmentArray;
    }
}
