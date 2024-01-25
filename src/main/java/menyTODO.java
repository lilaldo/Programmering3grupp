import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menyTODO {
    private static ArrayList<String> ärenden = new ArrayList<>();

    // Simple print day function
    public static void printDay() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        System.out.println(dayOfWeek);
    }


    // Metod för att hantera menyalternativen för en användaren.
    public static void menyalternativ(String username) {
        // Ladda användardata från filen
        List<UserData> users = loginTODO.loadUserData();
        UserData currentUser = null;

        // Hitta den användaren baserat på användarnamn.
        for (UserData userData : users) {
            if (userData.getUsername().equals(username)) {
                currentUser = userData;
                break;
            }
        }

        // Kopiera användarens tasks till den JSON.
        if (currentUser != null) {
            ärenden = new ArrayList<>(currentUser.getTasks());
        }

        // Huvudloopen för användarmenyn.
        while (true) {
            Scanner scan = new Scanner(System.in);

            // Rensa terminalen och visa användarens ärenden (fungerar ej just nu).
            rensaTerminal.rensa();
            visaÄrenden();

            // Visa menyalternativ
            System.out.println("**********************");
            printDay();
            System.out.println("1. Add");
            System.out.println("2. Change");
            System.out.println("3. Delete");
            System.out.println("4. Logout");
            System.out.println("**********************");

            // Läs in användarens val
            System.out.print("What would you like to do today? ");
            String val = scan.nextLine();

            // Utför åtgärden baserat på användarens val
            if (valtÄrende(val, ärenden)) {
                visaÄrendeInfo(val);
            } else if (val.equals("add")) {
                läggTillÄrende(scan);
            } else if (val.equals("change")) {
                ändraÄrende();
            } else if (val.equals("delete")) {
                taBortÄrende();
            } else if (val.equals("logout")) {
                // Logga ut användaren och spara ändringar i användardata (Kanske flytta så allt sparas tidigare?).
                System.out.println(" ");
                currentUser.setTasks(new ArrayList<>(ärenden));
                loginTODO.saveUserData(users);
                loginTODO.login();
            } else {
                System.out.println("Try again with a valid choice.");
            }
        }
    }

    // Metod för att välkomna användaren.
    public static void välkomnaAnvändare(String username) {
        System.out.println("Welcome " + username);
    }

    // Metod för att visa användarens TODOs.
    public static void visaÄrenden() {
        System.out.println("Your tasks:");
        for (int i = 0; i < ärenden.size(); i++) {
            System.out.println((i + 1) + ". " + ärenden.get(i));
        }
    }

    // Metod för att kontrollera om användaren har valt ett giltigt ärende.
    public static boolean valtÄrende(String val, ArrayList<String> ärenden) {
        try {
            int index = Integer.parseInt(val) - 1;
            return index >= 0 && index < ärenden.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Metod för att visa information om en specifik TODOs.
    public static void visaÄrendeInfo(String val) {
        System.out.println("Task: " + ärenden.get(Integer.parseInt(val) - 1));
    }
    public static void deadlines(String dayOfWeek) {
        System.out.println("Tasks for " + dayOfWeek + ":");

        for (String task : ärenden) {
            if (task.contains("| When: " + dayOfWeek)) {
                System.out.println(task);
            }
        }
    }

    private static Map<String, DayOfWeek> svDayMap;

    static {
        // Mapping of dag till day
        svDayMap = new HashMap<>();
        svDayMap.put("måndag", DayOfWeek.MONDAY);
        svDayMap.put("tisdag", DayOfWeek.TUESDAY);
        svDayMap.put("onsdag", DayOfWeek.WEDNESDAY);
        svDayMap.put("torsdag", DayOfWeek.THURSDAY);
        svDayMap.put("fredag", DayOfWeek.FRIDAY);
        svDayMap.put("lördag", DayOfWeek.SATURDAY);
        svDayMap.put("söndag", DayOfWeek.SUNDAY);
    }

    // Metod för att lägga till ett nytt ärende.
    public static void läggTillÄrende(Scanner scan) {
        System.out.println("New task: ");
        System.out.print("What is the task: ");
        String nyttÄrende = scan.nextLine();
        System.out.print("Deadline: ");
        String datum = scan.nextLine().toLowerCase(Locale.forLanguageTag("sv"));

        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        if (datum.equals("tomorrow") || datum.equals("imorgon")) {
            DayOfWeek nextDay = currentDayOfWeek.plus(1);
            System.out.print("Priority: ");
            String prioritet = scan.nextLine();

            ärenden.add(nyttÄrende + " | When: " + nextDay + " | Priority: " + prioritet);
            System.out.println("Task '" + nyttÄrende + "' is added for " + nextDay + ".");

        } else if (svDayMap.containsKey(datum)) {
            DayOfWeek datums = svDayMap.get(datum);
            System.out.print("Priority: ");
            String prioritet = scan.nextLine();

            ärenden.add(nyttÄrende + " | When: " + datums + " | Priority: " + prioritet);
            System.out.println("Task '" + nyttÄrende + "' is added for " + datums + ".");

        } else {
            System.out.println("Invalid day of the week. The task will be added without a deadline.");
            System.out.print("Priority: ");
            String prioritet = scan.nextLine();

            ärenden.add(nyttÄrende + " | Priority: " + prioritet);
            System.out.println("Task '" + nyttÄrende + "' is added without deadline.");
        }
    }

    // Metod för att ta bort ett ärende.
    public static void taBortÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which task would you like to delete? Write a number:");
        int index = scan.nextInt() - 1;
        ärenden.remove(index);
        System.out.println("Task " + (index + 1) + " is deleted.");
    }

    // Metod för att ändra ett ärende.
    // Utökad kod ligger i modifyTODO-klassen.
    public static void ändraÄrende() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which task would you like to change? Write a number:");
        int index = scan.nextInt() - 1;

        // Kontrollera om användaren har valt ett giltigt ärende.
        if (modifyTODO.valtÄrende(Integer.toString(index + 1), ärenden)) {
            visaÄrendeInfo(Integer.toString(index + 1));

            // Visa alternativ för att ändra ärendet.
            System.out.println("What would you like to change?");
            System.out.println("1. Name");
            System.out.println("2. Deadline");
            System.out.println("3. Priority");
            System.out.println("4. Go back");
            int val = scan.nextInt();
            scan.nextLine();

            // Kallar på metod utifrån användarens val.
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
