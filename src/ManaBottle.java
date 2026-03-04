public class ManaBottle extends Bottle {
    public ManaBottle(String id,int effect) {
        super(id,effect);
    }

    @Override
    public String getType() {
        return "ManaBottle";
    }

    @Override
    public boolean use(Adventure adv,Adventure target) {
        target.changeAttribute(this.getEffect(),"mana");
        adv.RemoveItem(this.getId());
        return true;
    }
}
