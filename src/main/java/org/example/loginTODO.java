package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class loginTODO {
    // Filvägen till JSON.
    private static final String USER_DATA_FILE = "user_data.json";

    // Metod för att hantera login eller registrering
    public static String login() {
        // Skapa en Scanner för att läsa användarinmatning
        Scanner scan = new Scanner(System.in);

        // Visa välkomstmeddelande och be användaren att logga in eller registrera sig
        System.out.print("Welcome! \nLogin or signup: ");

        // Läs användarens val (!!!login eller signup!!!)
        String val = scan.nextLine();

        // Om användaren väljer att logga in.
        if (val.equalsIgnoreCase("login")) {
            // Be användaren ange sitt användarnamn
            System.out.print("Name: ");
            String user = scan.next();

            // Ladda användardata från JSON.
            List<UserData> users = loadUserData();

            // Loopa igenom användardata för att hitta matchande användarnamn.
            for (UserData userData : users) {
                if (userData.getUsername().equals(user)) {
                    return user; // Returnera användarnamnet om det hittas.
                }
            }

            return null; // Returnera null om användaren inte hittas.
        }
        // Om användaren väljer att registrera sig...
        else if (val.equalsIgnoreCase("signup")) {
            // Be användaren ange ett nytt användarnamn.
            System.out.print("Name: ");
            String regUser = scan.next();

            // Ladda användardata från JSON.
            List<UserData> users = loadUserData();

            // Kontrollera om användarnamnet redan finns.
            for (UserData userData : users) {
                if (userData.getUsername().equals(regUser)) {
                    System.out.println("User already exists, try again.");
                    return null; // Returnera null om användarnamnet redan finns.
                }
            }

            // Skapa en ny användare och lägg till den i JSON.
            users.add(new UserData(regUser, new ArrayList<>()));
            // Spara uppdaterad användardata till JSON.
            saveUserData(users);

            return regUser; // Returnera det nya användarnamnet.
        }
        // Om användaren gör ett ogiltigt val.
        else {
            System.out.println("Invalid choice. Try again.");
            return null; // Returnera null om valet är ogiltigt.
        }
    }

    // Metod för att ladda användardata från filen
    public static List<UserData> loadUserData() {
        try (Reader reader = new FileReader(USER_DATA_FILE)) {
            // Skapa en Gson-instans för att konvertera JSON till objekt.
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<List<UserData>>() {}.getType());
        } catch (IOException e) {
            // Om det uppstår ett fel -
            return new ArrayList<>(); // Returnera en tom lista.
        }
    }

    // Metod för att spara användardata till JSON.
    public static void saveUserData(List<UserData> users) {
        try (Writer writer = new FileWriter(USER_DATA_FILE)) {
            // Skapa en Gson-instans för att konvertera objekt till JSON.
            Gson gson = new Gson();
            // Konvertera användardata till JSON och skriva till filen.
            gson.toJson(users, writer);
        } catch (IOException e) {
            // Om det uppstår ett fel vid sparande -
            e.printStackTrace(); // Skriv ut felmeddelandet.
        }
    }
}