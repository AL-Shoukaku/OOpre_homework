import java.util.ArrayList;
import java.util.HashMap;

public class Adventure {
    private String id;
    private int hp;
    private int atk;
    private int def;
    private int mana;
    private int money;
    private HashMap<String,Bottle> bottles = new HashMap<>();
    private ArrayList<Bottle> bottlesBag = new ArrayList<>();
    private HashMap<String,Equipment> equipments = new HashMap<>();
    private Equipment weapon = null;
    private Equipment armour = null;
    private HashMap<String,Spell> spells = new HashMap<>();

    public Adventure(String id) {
        this.id = id;
        this.hp = 500;
        this.atk = 1;
        this.def = 0;
        this.mana = 10;
        this.money = 50;
    }

    public String getId() {
        return id;
    }

    public HashMap<String,Bottle> getBottles() {
        return bottles;
    }

    public HashMap<String,Equipment> getEquipments() {
        return equipments;
    }

    public void AddBottle(Bottle bottle) {
        bottles.put(bottle.getId(),bottle);
    }

    public void AddEquipment(Equipment equipment) {
        equipments.put(equipment.getId(),equipment);
    }

    public void LearnSpell(Spell spell) {
        spells.put(spell.getId(),spell);
    }

    public String TakeItem(String itemId) {
        if (bottles.containsKey(itemId)) {
            if (!bottlesBag.contains(bottles.get(itemId))) {
                if (bottlesBag.size() < 10) {
                    bottlesBag.add(bottles.get(itemId));
                } else {
                    bottlesBag.remove(0);
                    bottlesBag.add(bottles.get(itemId));
                }
            }
            return bottles.get(itemId).getType();
        } else if (equipments.containsKey(itemId)) {
            if (equipments.get(itemId) instanceof Sword) {
                this.weapon = equipments.get(itemId);
            } else if (equipments.get(itemId) instanceof Magicbook) {
                this.weapon = equipments.get(itemId);
            } else {
                this.armour = equipments.get(itemId);
            }
            return equipments.get(itemId).getType();
        }
        return "Can't find item when take item!";
    }

    public String RemoveItem(String itemId) {
        String type = null;
        if (bottles.containsKey(itemId)) {
            type = bottles.get(itemId).getType();
            bottlesBag.remove(bottles.get(itemId));
            bottles.remove(itemId);
        } else if (equipments.containsKey(itemId)) {
            type = equipments.get(itemId).getType();
            if (weapon != null && weapon.equals(equipments.get(itemId))) {
                weapon = null;
            } else if (armour != null && armour.equals(equipments.get(itemId))) {
                armour = null;
            }
            equipments.remove(itemId);
        }
        if (type != null) {
            return type;
        }
        return "Can't find item when remove item!";
    }

    public void UseItem(Adventure target,String usableId) {
        Usable usable;
        if (bottles.containsKey(usableId) && bottlesBag.contains(bottles.get(usableId))) {
            usable = bottles.get(usableId);
            bottlesBag.remove(bottles.get(usableId));
            bottles.remove(usableId);
        } else if (spells.containsKey(usableId)) {
            usable = spells.get(usableId);
        } else {
            usable = null;
        }
        if (usable != null && usable.use(this,target)) {
            int hp = target.getAttribute("hp");
            int atk = target.getAttribute("atk");
            int def = target.getAttribute("def");
            int mana = target.getAttribute("mana");
            System.out.println(target.getId() + " " + hp + " " + atk + " " + def + " " + mana);
            if (target.getAttribute("hp") == 0) {
                this.money += target.countMoney();
            }
        } else {
            System.out.println(this.getId() + " fail to use " + usableId);
        }
    }

    public int BuyItem(String itemId,String type) {
        int num = Math.min(this.money, 100);
        Item item = Factory.createItem(itemId,type,num);
        if (item != null) {
            if (item instanceof Bottle) {
                bottles.put(itemId,(Bottle) item);
            } else {
                equipments.put(itemId,(Equipment) item);
            }
        }
        this.money -= num;
        return this.money;
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
            case "mana":
                this.mana += num;
                break;
            default:
                this.money += num;
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
            case "mana":
                return  this.mana;
            default:
                return this.money;
        }
    }

    public int getDef() {
        if (armour != null) {
            return this.def + armour.getCE();
        } else {
            return this.def;
        }
    }

    public int countMoney() {
        int ans = 0;
        ans += this.money;
        for (Bottle bottle : bottles.values()) {
            ans += bottle.getEffect();
        } for (Equipment equipment : equipments.values()) {
            ans += equipment.getCE();
        }
        return ans;
    }

    public boolean fight(int maxDef,ArrayList<Adventure> targets) {
        if (this.weapon == null || this.weapon instanceof Sword) {
            int attack = (weapon == null) ? atk : (atk + weapon.getCE());
            if (attack > maxDef) {
                for (Adventure target : targets) {
                    target.changeAttribute(maxDef - attack,"hp");
                    if (target.getAttribute("hp") == 0) {
                        this.money += target.countMoney();
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            if (mana > (int)Math.ceil(Math.sqrt(weapon.getCE()))) {
                for (Adventure target : targets) {
                    target.changeAttribute(-this.atk - weapon.getCE(), "hp");
                    if (target.getAttribute("hp") == 0) {
                        this.money += target.countMoney();
                    }
                }
                this.mana -= (int)Math.ceil(Math.sqrt(weapon.getCE()));
                return true;
            } else {
                return false;
            }
        }
    }
}
