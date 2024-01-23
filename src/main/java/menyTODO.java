import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menyTODO {
    private static ArrayList<String> ärenden = new ArrayList<>();

    public static void menyalternativ(String username) {
        List<UserData> users = loginTODO.loadUserData();
        UserData currentUser = null;

        for (UserData userData : users) {
            if (userData.getUsername().equals(username)) {
                currentUser = userData;
                break;
            }
        }

        if (currentUser != null) {
            ärenden = new ArrayList<>(currentUser.getTasks());
        }

        while (true) {
            Scanner scan = new Scanner(System.in);

            rensaTerminal.rensa();
            visaÄrenden();

            System.out.println("**********************");
            System.out.println("1. Add");
            System.out.println("2. Change");
            System.out.println("3. Delete");
            System.out.println("4. Logout");
            System.out.println("**********************");

            System.out.print("What would you like to do today? ");
            String val = scan.nextLine();

            if (valtÄrende(val, ärenden)) {
                visaÄrendeInfo(val);
            } else if (val.equals("add")) {
                läggTillÄrende(scan);
            } else if (val.equals("change")) {
                ändraÄrende();
            } else if (val.equals("delete")) {
                taBortÄrende();
            } else if (val.equals("logout")) {
                System.out.println(" ");
                currentUser.setTasks(new ArrayList<>(ärenden));
                loginTODO.saveUserData(users);
                loginTODO.login();
            } else {
                System.out.println("Try again with a valid choice.");
            }
        }
    }

    public static void välkomnaAnvändare(String username) {
        System.out.println("Welcome " + username);
    }

    public static void visaÄrenden() {
        System.out.println("Your tasks:");
        for (int i = 0; i < ärenden.size(); i++) {
            System.out.println((i + 1) + ". " + ärenden.get(i));
        }
    }

    public static boolean valtÄrende(String val, ArrayList<String> ärenden) {
        try {
            int index = Integer.parseInt(val) - 1;
            return index >= 0 && index < ärenden.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void visaÄrendeInfo(String val) {
        System.out.println("Task: " + ärenden.get(Integer.parseInt(val) - 1));
    }

    public static void läggTillÄrende(Scanner scan) {
        System.out.println("New task: ");
        System.out.print("What is the task: ");
        String nyttÄrende = scan.nextLine();
        System.out.print("Deadline: ");
        String datum = scan.nextLine();
        System.out.print("Priority: ");
        String prioritet = scan.nextLine();

        ärenden.add(nyttÄrende + " | When: " + datum + " | Priority: " + prioritet);

        System.out.println("Task '" + nyttÄrende + "' is added.");
    }

    public static void taBortÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which task would you like to delete? Write a number:");
        int index = scan.nextInt() - 1;
        ärenden.remove(index);
        System.out.println("Task " + (index + 1) + " is deleted.");
    }

    public static void ändraÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which task would you like to change? Write a number:");
        int index = scan.nextInt() - 1;

        if (modifyTODO.valtÄrende(Integer.toString(index + 1), ärenden)) {
            visaÄrendeInfo(Integer.toString(index + 1));

            System.out.println("What would you like to change?");
            System.out.println("1. Name");
            System.out.println("2. Deadline");
            System.out.println("3. Priority");
            System.out.println("4. Go back");
            int val = scan.nextInt();
            scan.nextLine();

            switch (val) {
                case 1:
                    System.out.print("New name: ");
                    String nyttNamn = scan.nextLine();
                    modifyTODO.ändraNamn(index, nyttNamn, ärenden);
                    break;
                case 2:
                    System.out.print("New deadline: ");
                    String nyttDatum = scan.nextLine();
                    modifyTODO.ändraDatum(index, nyttDatum, ärenden);
                    break;
                case 3:
                    System.out.print("New priority: ");
                    String nyPrioritet = scan.nextLine();
                    modifyTODO.ändraPrioritet(index, nyPrioritet, ärenden);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice, no modification done.");
                    break;
            }
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
