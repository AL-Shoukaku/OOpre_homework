public class DefBottle extends Bottle {
    public DefBottle(String id,int effect) {
        super(id,effect);
    }

    @Override
    public String getType() {
        return "DefBottle";
    }

    @Override
    public boolean use(Adventure adv,Adventure target) {
        target.changeAttribute(this.getEffect(),"def");
        adv.RemoveItem(this.getId());
        return true;
    }

}
