public class Bottle implements Usable {
    private String id;
    private int effect;

    public Bottle(String id, int effect) {
        this.id = id;
        this.effect = effect;
    }

    public String getId() {
        return id;
    }

    public int getEffect() {
        return effect;
    }

    public String getType() {
        return "Bottle";
    }

    public boolean use(Adventure adv,Adventure target) {
        return true;
    }
}
