
package dgsprinttwo;

import static dgsprinttwo.DungeonRun.players;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import static dgsprinttwo.Input.RED;
import static dgsprinttwo.Input.RESET_COLOR;
import static dgsprinttwo.Input.sc;
import java.io.FileInputStream;
import java.util.Scanner;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author Melker
 */
public class Menus {
   // public static Audio a = new Audio();
    public static Scanner sc = new Scanner(System.in);
    public static boolean mLoop = true;
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
        System.out.println("- Press 1 for options.");
        System.out.println("- Press 2 for Stats ");
        System.out.println("- Press 3 for killer stats ");
        System.out.println("- Press 4 for startMenu ");
        System.out.println("- GAME MENU INITIALIZED-");
        userInt = getUserInputInt();
        if (userInt == 1) {
            optionsMenu();
        } else if (userInt == 2) {
        System.out.println(DungeonRun.players.get(players.size() - 1).toString());
//System.out.println("Name:"+DungeonRun.players.get(0).getName()+" Class:"+players.get(players.size() - 1).toString());
        } else if (userInt == 3) {
        }else if(userInt == 4){
            DungeonRun.menuOneText();
        }
    }

    public static void charMenu() {

    }

    public static void optionsMenu() {
        String inM;
       System.out.println("-Music on? press Y/N -"); 
        inM = Input.getUserInputString();            
        if(inM.equalsIgnoreCase("y")){
                mLoop=true;
            }else if(inM.equalsIgnoreCase("n")){
               mLoop = false;
    }
        //walkingMenu();
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
