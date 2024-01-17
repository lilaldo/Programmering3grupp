import java.util.ArrayList;


// Gjorde en modify klass för att kunna särskilja på funktionerna, och för att menyTODO inte skulle bli så lång.
public class modifyTODO {

    // Svarar till case 1 i ändraÄrende (klassen alltså)
    public static void ändraNamn(int index, String nyttNamn, ArrayList<String> ärenden) {
        // Ändra namnet på ärendet i listan
        ärenden.set(index, nyttNamn + ", " + ärenden.get(index).substring(11));
        System.out.println("Namn ändrat till: " + nyttNamn);
    }

    // Svarar till case 2 i ändraÄrende.
    public static void ändraDatum(int index, String nyttDatum, ArrayList<String> ärenden) {
        String[] delar = ärenden.get(index).split(", ");
        ärenden.set(index, delar[0] + ", " + delar[1] + ", När: " + nyttDatum);
        System.out.println("Datum ändrat till: " + nyttDatum);
    }

    // Svarar till case 3 i ändraÄrende.
    public static void ändraPrioritet(int index, String nyPrioritet, ArrayList<String> ärenden) {
        String[] delar = ärenden.get(index).split(", ");
        ärenden.set(index, delar[0] + ", Prioritet: " + nyPrioritet + ", " + delar[2]);
        System.out.println("Prioritet ändrad till: " + nyPrioritet);
    }


    // för att hämta rätt ärende i TODOs.
    public static boolean valtÄrende(String val, ArrayList<String> ärenden) {
        try {
            int index = Integer.parseInt(val) - 1;
            return index >= 0 && index < ärenden.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
