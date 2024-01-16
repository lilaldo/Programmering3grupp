import java.util.Scanner;

public class menyTODO {

    public static void main(String[] args) {
        String username = loginTODO.login(); // Hämtar användarnamnet från login(hoppas jag)
        välkomnaAnvändare(username);
        menyalternativ();
    }

    public static void välkomnaAnvändare(String username) {
        System.out.println("Välkommen " + username);
    }

    public static void menyalternativ() {
        Scanner scan = new Scanner(System.in);

        // test-array.
        String[] ärenden = {"TODO now", "TODO later ", "TODO tomorrow "};

        while (true) {
            System.out.println("Dina TODOs:");
            for (int i = 0; i < ärenden.length; i++) {
                System.out.println((i + 1) + ". " + ärenden[i]);
            }

            System.out.print("Vad vill du göra idag? ");
            String val = scan.nextLine();

            if (valtÄrende(val, ärenden)) {
                visaÄrendeInfo(val);
            } else if (val.equals("add")) {     // lägg till
                läggTillÄrende();
            } else if (val.equals("del")) {     // ta bort
                taBortÄrende();
            } else if (val.equals("change")) {  // ändra
                ändraÄrende();
            } else if (val.equals("logout")) {  // logga ut
                loginTODO.login();
            } else {
                System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    // För att fkn java ska fatta vilket jävla nummer jag väljer.
    public static boolean valtÄrende(String val, String[] ärenden) {
        try {
            int index = Integer.parseInt(val) - 1;
            return index >= 0 && index < ärenden.length;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void visaÄrendeInfo(String val) {
        // visa information ärende.
        System.out.println("Ärende: " + val);
        // kod för att visa information
    }

    public static void läggTillÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Lägg till nytt ärende:");
        System.out.print("Ange namn: ");
        String nyttÄrende = scan.nextLine();
        // kod för att spara det nya ärendet
        // Behöver:
        // Namn, Prio, Datum(?),
        System.out.println("Ärende '" + nyttÄrende + "' har lagts till.");
    }

    public static void taBortÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilket ärende vill du ta bort? Ange numret:");
        int index = scan.nextInt() - 1;
        // kod för att ta bort
        System.out.println("Ärende " + (index + 1) + " har tagits bort.");
    }

    public static void ändraÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilket ärende vill du ändra? Ange numret:");
        int index = scan.nextInt() - 1;
        // kod för att ändra
        System.out.println("Ärende " + (index + 1) + " har ändrats.");
    }
}
