public class HpBottle extends Bottle {
    public HpBottle(String id,int effect) {
        super(id,effect);
    }

    @Override
    public String getType() {
        return "HpBottle";
    }

    @Override
    public boolean use(Adventure adv,Adventure target) {
        target.changeAttribute(this.getEffect(),"hp");
        adv.RemoveItem(this.getId());
        return true;
    }
}
