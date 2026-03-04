public class AtkBottle extends Bottle {
    public AtkBottle(String id,int effect) {
        super(id,effect);
    }

    @Override
    public String getType() {
        return "AtkBottle";
    }

    @Override
    public boolean use(Adventure adv,Adventure target) {
        target.changeAttribute(this.getEffect(),"atk");
        adv.RemoveItem(this.getId());
        return true;
    }
}
