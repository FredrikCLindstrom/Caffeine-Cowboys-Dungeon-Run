
package dgsprinttwo;



import static dgsprinttwo.Input.RED;
import static dgsprinttwo.Input.RESET_COLOR;
import static dgsprinttwo.Input.sc;
import java.util.Scanner;

/**
 *
 * @author Melker
 */
public class Menus {

    public static Scanner sc = new Scanner(System.in);

    static String userInput;
    int parseInput = 0;
    boolean runInput = true;
    String welcome;
    int menuChoice;

    public static void runMenus() {

        welcomeMenu();

    }

    public static void welcomeMenu() {

        System.out.println("Welcome to Dungeone Run! Please enter your name:");

        userInput = userInput();

        System.out.println("Alright " + userInput + " please create or choose a hero!");

    }

    public static void soundMenu() {

    }

    public static void walkingMenu() {
        int userInt;
        System.out.println("-GAME MENU INITIALIZED-");
        System.out.println("Press 1 for options.");
        System.out.println("-Press 2 for ");
        System.out.println("Press 3 for ");
        System.out.println("-GAME MENU INITIALIZED-");
        userInt = getUserInputInt();
        if (userInt == 1) {
            optionsMenu();
        } else if (userInt == 2) {
            
        } else if (userInt == 3) {
            
        } else if (userInt == 4) {
        }
    }

    public static void charMenu() {

    }

    public static void optionsMenu() {

    }

    public static String userInput() {
        String user = null;
        boolean run = true;

        do {
            try {
                user = sc.nextLine();
                run = false;
            } catch (NullPointerException e) {
                System.out.println(RED + "Wrong input, Try again: " + RESET_COLOR);
            }
        } while (run);
        return user;
    }

    public static int getUserInputInt() {
        String userInput;
        int parseInput = 0;
        boolean runInput = true;

        do {
            try {
                userInput = sc.nextLine();
                parseInput = Integer.parseInt(userInput);
                runInput = false;
            } catch (Exception e) {
                System.out.println(RED + "Wrong input, Try again: " + RESET_COLOR);
            }
        } while (runInput);
        return parseInput;
    }

}
