import java.util.ArrayList;
import java.util.Scanner;

public class menyTODO {

    // Array för att kunna lagra todos.
    private static ArrayList<String> ärenden = new ArrayList<>();

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

        while (true) {
            visaÄrenden();

            System.out.print("Vad vill du göra idag? ");
            String val = scan.nextLine();

            if (valtÄrende(val, ärenden)) {
                visaÄrendeInfo(val);
            } else if (val.equals("add")) {     // lägg till
                läggTillÄrende(scan);
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

    public static void visaÄrenden() {
        System.out.println("Dina TODOs:");
        for (int i = 0; i < ärenden.size(); i++) {
            System.out.println((i + 1) + ". " + ärenden.get(i));
        }
    }

    // För att fkn java ska fatta vilket jävla nummer jag väljer.
    public static boolean valtÄrende(String val, ArrayList<String> ärenden) {
        try {
            int index = Integer.parseInt(val) - 1;
            return index >= 0 && index < ärenden.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void visaÄrendeInfo(String val) {
        // visa information ärende.
        System.out.println("Ärende: " + ärenden.get(Integer.parseInt(val) - 1));
        // kod för att visa information ...........
        // Namn
        // Information om ärendet?
        // Prio?
    }

    public static void läggTillÄrende(Scanner scan) {
        System.out.println("Lägg till nytt ärende: ");
        String nyttÄrende = scan.nextLine();

        // Kod för att lägga till prioritet och datum.
        System.out.print("Prioritet: ");
        String prioritet = scan.nextLine();
        System.out.print("När? ");
        String datum = scan.nextLine();

        // Lägg till nya todos med add. behöver justeras.
        ärenden.add(nyttÄrende + ", Prioritet: " + prioritet + ", När: " + datum);

        System.out.println("Ärende '" + nyttÄrende + "' har lagts till.");
    }

    public static void taBortÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilket ärende vill du ta bort? Ange numret:");
        int index = scan.nextInt() - 1;
        ärenden.remove(index); // kod för att ta bort ärende från listan.
        System.out.println("Ärende " + (index + 1) + " har tagits bort.");
    }

    public static void ändraÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilket ärende vill du ändra? Ange numret:");
        int index = scan.nextInt() - 1;
        // kod för att ändra, behöver utvecklas.
        System.out.println("Ärende " + (index + 1) + " har ändrats.");
    }
}
