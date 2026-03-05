public class Armour extends Equipment {
    public Armour(String id,int ce) {
        super(id,ce);
    }

    @Override
    public String getType() {
        return "Armour";
    }
}
