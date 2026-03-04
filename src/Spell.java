public class Spell implements Usable {
    private String id;
    private int power;
    private int manaCost;

    public Spell(String id, int manaCost, int power) {
        this.id = id;
        this.power = power;
        this.manaCost = manaCost;
    }

    public String getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getType() {
        return "Spell";
    }

    public boolean use(Adventure adv,Adventure target) {
        return true;
    }
}
