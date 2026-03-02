public class Bottle {
    private final String id;
    private final int effect;

    public Bottle(String name,int effect) {
        this.id = name;
        this.effect = effect;
    }

    public String getId() {
        return id;
    }

    public int getEffect() {
        return effect;
    }

}
