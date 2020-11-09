package dungeonrun;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class DungeonRun {
    public static ArrayList<Player>players= new ArrayList<>();
    public static Audio a = new Audio();

    public static String name="";

    //public static Knight k = new Knight(name,tresure);
    //public static Wizard w = new Wizard(name,tresure);
    //public static Thief t = new Thief(name,tresure);


    GameBoardRunner gBoRu=new GameBoardRunner(players,name);

    public static Scanner scan = new Scanner(System.in);
    public static boolean loop=true;


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String RESET = "\"\\033[0m\"";





    
    public static void main(String[] args) {
      a.playMusic("");
       welcomeText();
       while(loop){
           menuOne(menuOneText());
       }
       
       
    }
    public static void menuOne(byte in){
        switch(in){
            case 1:
                menuCharacter();
                break;
            case 2:
                System.out.println("DungeonRun is a textbased adventuregame.\n How to play:Write your choice and press enter to advance");
                break;
            case 3:
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid Choice!");
                break;
        }

    }
    public static void menuCharacter(){
        boolean ploop = true;
        while(ploop){

        System.out.println(ANSI_YELLOW+"Who would you like to choose as your fighter? ");
        System.out.println("1."+k.toString());
        System.out.println("2."+w.toString());
        System.out.println("3."+t.toString());

        int in = scan.nextByte();
                 scan.nextLine();
        switch(in){
            case 1:players.add(k);
                break;
            case 2:players.add(w);
                break;
            case 3:players.add(t);

        }
            System.out.println("Choose your name!");
            name = scan.nextLine();
            System.out.println("Name:"+name+" Class:"+players.get(0));
            System.out.println("Are you sure of your choice?y/n"+RESET);
            String yeOrNay = scan.nextLine();
            if(yeOrNay.equalsIgnoreCase("y")){
                ploop=false;
            }else if(yeOrNay.equalsIgnoreCase("n")){
                players.remove(0);
            }


            Maps.runMap();
    }
    }
    
    public static byte menuOneText(){
        System.out.println(ANSI_YELLOW+"Choose your option by a number input");
        System.out.println(ANSI_YELLOW+"1.Pick pre generated character");
        System.out.println(ANSI_YELLOW+"2.About the game!");
        System.out.println(ANSI_RED+"3.Exit game");


        return scan.nextByte();

        
    }
    public static void welcomeText(){
        System.out.println("   /\\                                                        /\\");
        System.out.println("  |  |                                                      |  |");
        System.out.println(" /----\\                                                    /----\\");
        System.out.println("[______]                                                  [______]");
        System.out.println(" |    |         _____                        _____         |    |");
        System.out.println(" |[]  |        [     ]                      [     ]        |  []|");
        System.out.println(" |    |       [_______][ ][ ][ ][][ ][ ][ ][_______]       |    |");
        System.out.println(" |    [ ][ ][ ]|     |  ,----------------,  |     |[ ][ ][ ]    |");
        System.out.println(" |             |     |/'    ____..____    '\\|     |             |");
        System.out.println("  \\  []        |     |    /'    ||    '\\    |     |        []  /");
        System.out.println("   |      []   |     |   |o     ||     o|   |     |  []       |");
        System.out.println("   |           |  _  |   |     _||_     |   |  _  |           |");
        System.out.println("   |   []      | (_) |   |    (_||_)    |   | (_) |       []  |");
        System.out.println("   |           |     |   |     (||)     |   |     |           |");
        System.out.println("   |           |     |   |      ||      |   |     |           |");
        System.out.println(" /''           |     |   |o     ||     o|   |     |           ''\\");
        System.out.println("[_____________[_______]--'------''------'--[_______]_____________]");
        
        
        
        System.out.println(ANSI_RED +" ___    __ __  ____    ____    ___   ___   ____       ____  __ __  ____  ");
        System.out.println(ANSI_RED +"|   \\  |  |  ||    \\  /    |  /  _] /   \\ |    \\     |    \\|  |  ||    \\ ");
        System.out.println(ANSI_RED +"|    \\ |  |  ||  _  ||   __| /  [_ |     ||  _  |    |  D  )  |  ||  _  |");
        System.out.println(ANSI_RED +"|  D  ||  |  ||  |  ||  |  ||    _]|  O  ||  |  |    |    /|  |  ||  |  |");
        System.out.println(ANSI_RED +"|     ||  :  ||  |  ||  |_ ||   [_ |     ||  |  |    |    \\|  :  ||  |  |");
        System.out.println(ANSI_RED +"|     ||     ||  |  ||     ||     ||     ||  |  |    |  .  \\     ||  |  |");
        System.out.println(ANSI_RED +"|_____| \\__,_||__|__||___,_||_____| \\___/ |__|__|    |__|\\_|\\__,_||__|__|");
        //System.out.println("                                                                         ");             
        System.out.println("                                                                         "); 
        System.out.println(ANSI_PURPLE+"                        By Caffein Cowboys                                ");
        System.out.println("                                                                           ");
    }
    
}
