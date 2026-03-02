import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Adventure> adventureArray = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String operate = input.next();
            if (operate.equals("aa")) {
                String advid = input.next();
                Adventure adv = new Adventure(advid);
                adventureArray.add(adv);
            }
            else if (operate.equals("ab")) {
                String id = input.next();
                for (Adventure adv : adventureArray) {
                    if (adv.getId().equals(id)) {
                        String bottleid = input.next();
                        int bottleeffect =  input.nextInt();
                        adv.AddBottle(bottleid,bottleeffect);
                    }
                }
            }
            else if (operate.equals("ae")) {
                String id = input.next();
                for (Adventure adv : adventureArray) {
                    if (adv.getId().equals(id)) {
                        String equipid = input.next();
                        adv.AddEquipment(equipid);
                    }
                }
            }
            else if (operate.equals("rb")) {
                String id = input.next();
                for (Adventure adv : adventureArray) {
                    if (adv.getId().equals(id)) {
                        String bottleid = input.next();
                        adv.RemoveBottle(bottleid);
                    }
                }
            }
            else {
                String id = input.next();
                for (Adventure adv : adventureArray) {
                    if (adv.getId().equals(id)) {
                        String equipid = input.next();
                        adv.RemoveEquipment(equipid);
                    }
                }
            }
        }


    }

}