public class Factory {
    public static Equipment createEquipment(String equipmentId,String type,int ce) {
        switch (type) {
            case "Sword":
                return new Sword(equipmentId,ce);
            case "Magicbook":
                return new Magicbook(equipmentId,ce);
            case "Armour":
                return new Armour(equipmentId,ce);
            default:
                return null;
        }
    }

    public static Bottle createBottle(String bottleId,String type,int effect) {
        switch (type) {
            case "HpBottle":
                return new HpBottle(bottleId,effect);
            case "AtkBottle":
                return new AtkBottle(bottleId,effect);
            case "DefBottle":
                return new DefBottle(bottleId,effect);
            case "ManaBottle":
                return new ManaBottle(bottleId,effect);
            default:
                return null;
        }
    }

    public static Spell createSpell(String spellId,String type,int cost,int power) {
        switch (type) {
            case "AttackSpell":
                return new AttackSpell(spellId,cost,power);
            case "HealSpell":
                return new HealSpell(spellId,cost,power);
            default:
                return null;
        }
    }

    public static Item createItem(String itemId,String type,int amount) {
        switch (type) {
            case "HpBottle":
                return new HpBottle(itemId,amount);
            case "AtkBottle":
                return new AtkBottle(itemId,amount);
            case "DefBottle":
                return new DefBottle(itemId,amount);
            case "ManaBottle":
                return new ManaBottle(itemId,amount);
            case "Sword":
                return new Sword(itemId,amount);
            case "Magicbook":
                return new Magicbook(itemId,amount);
            case "Armour":
                return new Armour(itemId,amount);
            default:
                return null;
        }
    }
}
