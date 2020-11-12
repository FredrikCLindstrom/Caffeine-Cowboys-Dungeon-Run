package dgsprinttwo;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static dgsprinttwo.Menus.mLoop;
import static dgsprinttwo.Menus.playMusic;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class DungeonRun {
    public static ArrayList<Heroes>players= new ArrayList<>();
    //public static Audio a = new Audio();
    public static int skatter = 0;
    public static String name="";

    
   /* public static Heroes k = new Knight(name, 0);
    public static Heroes w = new Wizard(name, 0);
    public static Heroes t = new Thief(name, 0);*/


  

    public static Scanner scan = new Scanner(System.in);
    public static boolean loop=true;


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String RESET = "\"\\033[0m\"";





    
    public static void main(String[] args) {
      //while(mLoop){
     // playMusic("Dungeons Run Game Music.wav");
     //   }
        
        //a.playMusic("");
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
                
                resumeGame();
                break;
            case 4:    
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
        System.out.println("1.Knight");
        System.out.println("2.Wizard");
        System.out.println("3.Thief");
        //k.setSkatter(0);
        int in = scan.nextByte();
                 scan.nextLine();
        
    for (int i = 0; i < 3; i++) {
            if(in==1){
                Heroes player = new Knight("namn", 0);
                players.add(player);
            }
            else if(in==2){
            Heroes player = new Wizard("namn", 0);
           players.add(player);
        }
        else if(in==3){
            Heroes player = new Thief("namn", 0);
            players.add(player);
        }    
    }     
                 
                 
                 
                 
                 
                 /*if(in==1){
                Heroes k = new Knight("namn", 0);
                k.setSkatter(0);
                players.add(k);
            }
            else if(in==2){
           Heroes w = new Wizard("namn", 0);
           w.setSkatter(0);
           players.add(w);
        }
        else if(in==3){
            Heroes t = new Thief("namn", 0);
            t.setSkatter(0);
            players.add(t);
        }  */       
                 

            System.out.println("Choose your name!");
            name = scan.nextLine();
            players.get(0).setName(name);
          System.out.println("Name: "+players.get(0).getName()+" Class:"+players.get(players.size() - 1).toString());
                  //players.get(0).toString());
            System.out.println("Are you sure of your choice? y/n "+Maps.RESET_COLOR);
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
         System.out.println(ANSI_YELLOW+"3.Resume game");
        System.out.println(ANSI_RED+"4.Exit game");


        return scan.nextByte();

        
    }
    public static void resumeGame(){
         int index = 0;
         System.out.println(players.toString());
               System.out.println("Enter first name : " );
                    String nameSearch = scan.nextLine();
                        
                  for (Heroes player : players) {
                        
                        if(player.getName().equalsIgnoreCase(nameSearch)){
                            index = index + 1;
                            Maps.runMap();
                            //System.out.println(player.toString());
                            
                            break;
                         } else {
                            System.out.println("Hero is not found is not found");
                        }
                    
                  }
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
