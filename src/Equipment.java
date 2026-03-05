public class Equipment implements Item {
    private String id;
    private int ce;

    public Equipment(String id,int ce) {
        this.id = id;
        this.ce = ce;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return "Equipment";
    }

    public int getCE() {
        return ce;
    }
}

