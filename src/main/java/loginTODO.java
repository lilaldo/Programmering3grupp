import java.util.Scanner;

public class loginTODO {
    public static String main() {
        var scan = new Scanner(System.in);

        System.out.print("Välkommen! Logga in eller registrera: ");

        String val = scan.nextLine();

        if (val.equalsIgnoreCase("login")) {
            System.out.print("Namn: ");
            String user = scan.next();

            // Kod för att kolla så att användaren finns i json-filen (här eller i main?)?

            return user; // Returnera användarnamnet efter inloggning.

        } else if (val.equalsIgnoreCase("register")) {
            System.out.print("Önskat namn: ");
            String regUser = scan.next();

            //****** Fixa kod för att json ska kunna lägga till användare i filen. ********

            return regUser; // Return användarnamn efter registrering.

        } else {
            System.out.println("Ogiltigt val. Programmet avslutas.");
            return null; // Return null om ogiltigt val.
        }
    }
}
