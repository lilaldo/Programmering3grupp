import java.util.ArrayList;

public class modifyTODO {

    public static void ändraNamn(int index, String nyttNamn, ArrayList<String> ärenden) {
        // Ändra namnet på ärendet i listan
        String existingTask = ärenden.get(index);
        String[] parts = existingTask.split(", ");
        String modifiedTask = nyttNamn + ", " + parts[1] + ", " + parts[2];
        ärenden.set(index, modifiedTask);
        System.out.println("Name changed to: " + nyttNamn);
    }

    public static void ändraDatum(int index, String nyttDatum, ArrayList<String> ärenden) {
        // Ändra datumet på ärendet i listan
        String[] delar = ärenden.get(index).split(", ");
        ärenden.set(index, delar[0] + ", " + delar[1] + ", När: " + nyttDatum);
        System.out.println("Date changed to: " + nyttDatum);
    }

    public static void ändraPrioritet(int index, String nyPrioritet, ArrayList<String> ärenden) {
        // Ändra prioriteten på ärendet i listan
        String[] delar = ärenden.get(index).split(", ");
        ärenden.set(index, delar[0] + ", Prioritet: " + nyPrioritet + ", " + delar[2]);
        System.out.println("Priority changed to: " + nyPrioritet);
    }

    public static boolean valtÄrende(String val, ArrayList<String> ärenden) {
        try {
            int index = Integer.parseInt(val) - 1;
            return index >= 0 && index < ärenden.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
