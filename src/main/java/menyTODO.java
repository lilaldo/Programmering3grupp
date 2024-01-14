import java.util.Scanner;

public class menyTODO {

    public static void main(String[] args) {
        String username = loginTODO.main(); // Hämtar användarnamnet från login(hoppas jag)
        System.out.println("Välkommen " + username);
        menyalternativ();
    }

    public static void menyalternativ() {
        Scanner scan = new Scanner(System.in);

        // testlista
        String[] ärenden = {"Ärende ", "Ärende ", "Ärende "};

        while (true) {
            System.out.println("Här är dina ärenden:");
            for (int i = 0; i < ärenden.length; i++) {
                System.out.println((i + 1) + ". " + ärenden[i]);
            }

            System.out.println("Ange ditt val (siffror från ovan): ");
            String val = scan.nextLine();

            if (ärValtÄrende(val, ärenden)) {
                visaÄrendeInfo(val);
            } else if (val.equals("add")) {
                läggTillÄrende();
            } else if (val.equals("del")) {
                taBortÄrende();
            } else if (val.equals("change")) {
                ändraÄrende();
            } else {
                System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    public static boolean ärValtÄrende(String val, String[] ärenden) {
        try {
            int index = Integer.parseInt(val) - 1;
            return index >= 0 && index < ärenden.length;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void visaÄrendeInfo(String val) {
        // Logiken för att visa information om det valda ärendet
        System.out.println("Information om ärende " + val);
        // Kod för att visa information om det valda ärendet
    }

    public static void läggTillÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Lägg till nytt ärende:");
        System.out.print("Ange namn: ");
        String nyttÄrende = scan.nextLine();
        // Lägg till kod för att spara det nya ärendet
        System.out.println("Ärende '" + nyttÄrende + "' har lagts till.");
    }

    public static void taBortÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilket ärende vill du ta bort? Ange numret:");
        int index = scan.nextInt() - 1;
        // Lägg till kod för att ta bort det valda ärendet
        System.out.println("Ärende " + (index + 1) + " har tagits bort.");
    }

    public static void ändraÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilket ärende vill du ändra? Ange numret:");
        int index = scan.nextInt() - 1;
        // Lägg till kod för att ändra det valda ärendet
        System.out.println("Ärende " + (index + 1) + " har ändrats.");
    }
}
