import java.util.ArrayList;

public class Adventure {
    private String id;
    private int hp;
    private int atk;
    private int def;
    private int mana;
    private ArrayList<Bottle> bottles = new ArrayList<>();
    private ArrayList<Bottle> bottlesBag = new ArrayList<>();
    private ArrayList<Equipment> equipments = new ArrayList<>();
    private ArrayList<Equipment> equipmentsBag = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();

    public Adventure(String id) {
        this.id = id;
        this.hp = 500;
        this.atk = 1;
        this.def = 0;
        this.mana = 10;
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

    public void LearnSpell(Spell spell) {
        spells.add(spell);
    }

    public String TakeItem(String itemId) {
        Bottle bottle = FindBottle(itemId);
        Equipment equipment = FindEquipment(itemId);
        if (bottle != null) {
            this.bottlesBag.add(bottle);
            return bottle.getType();
        } else {
            this.equipmentsBag.add(equipment);
            return equipment.getType();
        }
    }

    public String RemoveItem(String itemId) {
        Bottle bottle = FindBottle(itemId);
        Equipment equipment = FindEquipment(itemId);
        if (bottle != null) {
            bottles.remove(bottle);
            bottlesBag.remove(bottle);
            return bottle.getType();
        } else {
            equipments.remove(equipment);
            equipmentsBag.remove(equipment);
            return equipment.getType();
        }
    }

    public void UseItem(Adventure target,String usableId) {
        Usable usable;
        if (FindBottle(usableId) != null && this.bottlesBag.contains(FindBottle(usableId))) {
            usable = FindBottle(usableId);
        } else if (FindSpell(usableId) != null) {
            usable = FindSpell(usableId);
        } else {
            usable = null;
        }
        if (usable != null && usable.use(this,target)) {
            int hp = target.getAttribute("hp");
            int atk = target.getAttribute("atk");
            int def = target.getAttribute("def");
            int mana = target.getAttribute("mana");
            System.out.println(target.getId() + " " + hp + " " + atk + " " + def + " " + mana);

        } else {
            System.out.println(this.getId() + " fail to use " + usableId);
        }
    }

    public void changeAttribute(int num,String type) {
        switch (type) {
            case "hp":
                this.hp += num;
                if (this.hp <= 0) {
                    this.hp = 0;
                }
                break;
            case "atk":
                this.atk += num;
                break;
            case "def":
                this.def += num;
                break;
            default:
                this.mana += num;
        }
    }

    public int getAttribute(String type) {
        switch (type) {
            case "hp":
                return  this.hp;
            case "atk":
                return  this.atk;
            case "def":
                return  this.def;
            default:
                return  this.mana;
        }
    }

    public Bottle FindBottle(String bottleId) {
        for (Bottle bottle : bottles) {
            if (bottle.getId().equals(bottleId)) {
                return bottle;
            }
        }
        return null;
    }

    public Equipment FindEquipment(String equipmentId) {
        for (Equipment equipment : equipments) {
            if (equipment.getId().equals(equipmentId)) {
                return equipment;
            }
        }
        return null;
    }

    public Spell FindSpell(String spellId) {
        for (Spell spell : spells) {
            if (spell.getId().equals(spellId)) {
                return spell;
            }
        }
        return null;
    }
}
