import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loginTODO {
    private static final String USER_DATA_FILE = "user_data.json";

    public static String login() {
        var scan = new Scanner(System.in);

        System.out.print("Welcome! \nLog in or sign up: ");

        String val = scan.nextLine();

        if (val.equalsIgnoreCase("login")) {
            System.out.print("Name: ");
            String user = scan.next();

            List<UserData> users = loadUserData();

            for (UserData userData : users) {
                if (userData.getUsername().equals(user)) {
                    return user;
                }
            }

            return null;
        } else if (val.equalsIgnoreCase("signup")) {
            System.out.print("Name: ");
            String regUser = scan.next();

            List<UserData> users = loadUserData();

            for (UserData userData : users) {
                if (userData.getUsername().equals(regUser)) {
                    System.out.println("User already exists, try again.");
                    return null;
                }
            }

            users.add(new UserData(regUser, new ArrayList<>()));
            saveUserData(users);

            return regUser;
        } else {
            System.out.println("Try again.");
            return null;
        }
    }

    public static List<UserData> loadUserData() {
        try (Reader reader = new FileReader(USER_DATA_FILE)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<List<UserData>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void saveUserData(List<UserData> users) {
        try (Writer writer = new FileWriter(USER_DATA_FILE)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
