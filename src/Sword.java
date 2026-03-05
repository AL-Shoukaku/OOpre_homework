public class Sword extends Equipment {
    public Sword(String id,int ce) {
        super(id,ce);
    }

    @Override
    public String getType() {
        return "Sword";
    }
}
