public class AttackSpell extends Spell {
    public AttackSpell(String id,int manaCost,int power) {
        super(id,manaCost,power);
    }

    @Override
    public String getType() {
        return "AttackSpell";
    }

    @Override
    public boolean use(Adventure adv,Adventure target) {
        if (adv.getAttribute("mana") < this.getManaCost()) {
            return false;
        } else {
            target.changeAttribute((-this.getPower()),"hp");
            adv.changeAttribute(-this.getManaCost(),"mana");
            return true;
        }
    }
}
