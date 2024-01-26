package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class modifyTODO {

    public static void ändraNamn(int index, String nyttNamn, ArrayList<String> ärenden) {
        if (index >= 0 && index < ärenden.size()) {
            String existingTask = ärenden.get(index);

            // Kontrollera om det befintliga ärendet har rätt format
            if (existingTask.matches(".+ \\| When: .+ \\| Priority: .+")) {
                // Extrahera datum och prioritet från det befintliga ärendet
                String[] parts = existingTask.split(" \\| When: | \\| Priority: ");

                // Kontrollera om delar innehåller tillräckligt med element
                if (parts.length == 3) {
                    String modifiedTask = nyttNamn + " | When: " + parts[1] + " | Priority: " + parts[2];
                    ärenden.set(index, modifiedTask);
                    System.out.println(parts[0] + " changed to: " + nyttNamn); //////
                } else {
                    System.out.println("Invalid format for existing task: " + existingTask);
                }
            } else {
                System.out.println("Invalid format for existing task: " + existingTask);
            }
        } else {
            System.out.println("Invalid index: " + index);
        }
    }


    public static void ändraDatum(int index, String nyttDatumInput, ArrayList<String> ärenden) {
        if (index >= 0 && index < ärenden.size()) {
            String existingTask = ärenden.get(index);

            // Kontrollera om det befintliga ärendet har rätt format
            if (existingTask.matches(".+ \\| When: .+ \\| Priority: .+")) {
                // Extrahera namn och prioriteten från det befintliga ärendet
                String[] parts = existingTask.split(" \\| When: | \\| Priority: ");

                // Kontrollera om delar innehåller tillräckligt med element
                if (parts.length == 3) {
                    // Använd det befintliga datumet om användaren inte anger ett nytt datum
                    String nyttDatum = nyttDatumInput.isEmpty() ? parts[1] : nyttDatumInput;

                    // Skapa det modifierade ärendet
                    String modifiedTask = parts[0] + " | When: " + nyttDatum + " | Priority: " + parts[2];
                    ärenden.set(index, modifiedTask);
                    System.out.println("Date changed to: " + nyttDatum);
                } else {
                    System.out.println("Invalid format for existing task: " + existingTask);
                }
            } else {
                System.out.println("Invalid format for existing task: " + existingTask);
            }
        } else {
            System.out.println("Invalid index: " + index);
        }
    }



    public static void ändraPrioritet(int index, String nyPrioritetInput, ArrayList<String> ärenden) {
        if (index >= 0 && index < ärenden.size()) {
            String existingTask = ärenden.get(index);

            // Kontrollera om det befintliga ärendet har rätt format
            if (existingTask.matches(".+ \\| When: .+ \\| Priority: .+")) {
                // Extrahera namn och datum från det befintliga ärendet
                String[] parts = existingTask.split(" \\| When: | \\| Priority: ");

                // Kontrollera om delar innehåller tillräckligt med element
                if (parts.length == 3) {
                    // Använd den befintliga prioriteten om användaren inte anger en ny prioriteten
                    String nyPrioritet = nyPrioritetInput.isEmpty() ? parts[2] : nyPrioritetInput;

                    // Skapa det modifierade ärendet
                    String modifiedTask = parts[0] + " | When: " + parts[1] + " | Priority: " + nyPrioritet;
                    ärenden.set(index, modifiedTask);
                    System.out.println("Priority changed to: " + nyPrioritet);
                } else {
                    System.out.println("Invalid format for existing task: " + existingTask);
                }
            } else {
                System.out.println("Invalid format for existing task: " + existingTask);
            }
        } else {
            System.out.println("Invalid index: " + index);
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
}
