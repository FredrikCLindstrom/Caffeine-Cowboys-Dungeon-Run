package dgsprinttwo;


import java.util.ArrayList;
import java.util.Random;

public class Maps {

    public static final String RESET_COLOR = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String WHITE = "\033[0;37m";
    public static final String GREEN = "\033[0;32m"; 
    public static final String CYAN = "\033[0;36m";
    
    ArrayList<Maps> mapArrayList = new ArrayList<>();
    
    static private String[][] usersMap;
    
    public static void runMap() {
        boolean quitGame=true;
        boolean quitGameToMainMenu=false;
        int userChoiceOfMap;
        int cornerChoice;
        int currentV;
        int currentH;
        int verticalRandom;
        int horisontellRandom;
        String movePlayer;
        
        do{

        userChoiceOfMap = chooseSizeOfMap();
        
        quitGameToMainMenu=quitToMainMenuChecker(userChoiceOfMap);
        
        if(quitGameToMainMenu==true){
            continue;
        }

        cornerChoice = CornerChoiceMethod();

        createANewMap(userChoiceOfMap);

        currentV = startingVertical(userChoiceOfMap, cornerChoice);

        currentH = startingHorisontell(userChoiceOfMap, cornerChoice);

        mapCreationIterative(currentV, currentH);
        
        verticalRandom=verticalRandomNumberGenExit();
            
        horisontellRandom=horisontellRandomNumberGenExit();

        walkTheMapFirstText();
        do {

            printMap();

            movePlayer = Input.getUserInputString();
            
            usersMap[currentV][currentH] = CYAN + "[*]" + RESET_COLOR;

            currentH = isRightOrLeft(movePlayer, currentH);

            currentV = isUpOrDown(movePlayer, currentV);

            arrMethodChangePlaces(movePlayer, currentV, currentH);
            
            System.out.println("random v = "+verticalRandom+"random h = "+horisontellRandom);
            
            quitGame=exitFound(verticalRandom, horisontellRandom, currentV, currentH);

        } while (quitGame==false);
        
        }while(quitGameToMainMenu==false);

    } //this method contains all other methods, easier to integrate
                                                // to main method, just call runMap(); and everything should run

    public static int chooseSizeOfMap() {
        boolean isValidChoice;
        int userChoiceOfMap;

        do {

            isValidChoice = true;

            System.out.println("*** How big of a Map do you want to explore ***");
            System.out.println("    [1] Small size map");
            System.out.println("    [2] Medium size map");
            System.out.println("    [3] Large size map");
            System.out.println("    [4] Go back to menu");
            System.out.print("Enter Choice: ");

            userChoiceOfMap = Input.getUserInputInt();

            if (userChoiceOfMap > 4 || userChoiceOfMap < 1) {
                System.out.println("Please choose between [1],[2] and [3]");
                isValidChoice = false;
            }
           
        } while (isValidChoice == false);

        return userChoiceOfMap;

    }

    public static int CornerChoiceMethod() {
        boolean isValidChoice;
        int cornerChoice;

        do {
            isValidChoice = true;

            System.out.println("*** Wich corner do you want to start ***");
            System.out.println("    [1] Upper Left");
            System.out.println("    [2] Upper Right");
            System.out.println("    [3] Lower Left");
            System.out.println("    [4] Lower Right");
            System.out.println("Enter choice: ");

            cornerChoice = Input.getUserInputInt();
            if (cornerChoice > 4 || cornerChoice < 1) {
                System.out.println("Please choose between [1],[2],[3] and [4]");
                isValidChoice = false;
            }
        } while (isValidChoice == false);

        return cornerChoice;

    }

    public static void createANewMap(int userChoiceOfMap) {

        

        switch (userChoiceOfMap) {
            case 1:
                String[][] arrMapSmall = new String[4][4];
                usersMap= arrMapSmall;
            break;
            case 2:
                String[][] arrMapMedium = new String[5][5];
                usersMap= arrMapMedium;
            break;
            case 3:
                String[][] arrMapLarge = new String[6][6];
                usersMap= arrMapLarge;
            break;
            
                
        }
    }

    public static int startingVertical(int UserChoiceOfMap, int cornerChoice) {
        int currentV = 0;

        switch (UserChoiceOfMap) {
            case 1:

                if (cornerChoice == 1) {
                    currentV = 0;
                } else if (cornerChoice == 2) {
                    currentV = 0;
                } else if (cornerChoice == 3) {
                    currentV = 3;
                } else if (cornerChoice == 4) {
                    currentV = 3;
                }
                break;

            case 2:

                if (cornerChoice == 1) {
                    currentV = 0;
                } else if (cornerChoice == 2) {
                    currentV = 0;
                } else if (cornerChoice == 3) {
                    currentV = 4;
                } else if (cornerChoice == 4) {
                    currentV = 4;
                }
                break;
            case 3:

                if (cornerChoice == 1) {
                    currentV = 0;
                } else if (cornerChoice == 2) {
                    currentV = 0;
                } else if (cornerChoice == 3) {
                    currentV = 5;
                } else if (cornerChoice == 4) {
                    currentV = 5;
                }
                break;

        }

        return currentV;
    }

    public static int startingHorisontell(int UserChoiceOfMap, int cornerChoice) {//change these to 1 function
        int currentH = 0;

        switch (UserChoiceOfMap) {
            case 1:

                if (cornerChoice == 1) {
                    currentH = 0;
                } else if (cornerChoice == 2) {
                    currentH = 3;
                } else if (cornerChoice == 3) {
                    currentH = 0;
                } else if (cornerChoice == 4) {
                    currentH = 3;
                }
                break;

            case 2:

                if (cornerChoice == 1) {
                    currentH = 0;
                } else if (cornerChoice == 2) {
                    currentH = 4;
                } else if (cornerChoice == 3) {
                    currentH = 0;
                } else if (cornerChoice == 4) {
                    currentH = 4;
                }
                break;
            case 3:

                if (cornerChoice == 1) {
                    currentH = 0;
                } else if (cornerChoice == 2) {
                    currentH = 5;
                } else if (cornerChoice == 3) {
                    currentH = 0;
                } else if (cornerChoice == 4) {
                    currentH = 5;
                }
                break;

        }

        return currentH;
    }

    public static void mapCreationIterative( int currentV, int currentH) {

        for (int i = 0; i < usersMap.length; i++) {

            for (int j = 0; j < usersMap.length; j++) {

                usersMap[i][j] = "[X]";

            }

        }
        usersMap[currentV][currentH] = RED + "[*]" + RESET_COLOR;

    }

    public static void printMap() {

        for (int i = 0; i < usersMap.length; i++) {

            for (int j = 0; j < usersMap.length; j++) {

                System.out.print(usersMap[i][j] + " ");

            }

            System.out.println();
        }
    }

    public static int isRightOrLeft(String movePlayer, int currentH) {
        int newRoomSize = usersMap.length;
        if (movePlayer.equalsIgnoreCase("D")) {
            if (currentH < newRoomSize - 1) {
                currentH++;
            } else {
                System.out.println(RED+"-**--**--**--**--**--**-"+RESET_COLOR);
                System.out.println(RED +"  du kan ej gå höger" + RESET_COLOR);
                System.out.println(RED+"-**--**--**--**--**--**-"+RESET_COLOR);
            }

        } else if (movePlayer.equalsIgnoreCase("A")) {
            if (currentH > 0) {
                currentH--;
            } else {
                System.out.println(RED+"-**--**--**--**--**--**-"+RESET_COLOR);
                System.out.println(RED + "  du kan ej gå vänster" + RESET_COLOR);
                System.out.println(RED+"-**--**--**--**--**--**-"+RESET_COLOR);
            }
        }
        return currentH;
    }

    public static int isUpOrDown(String movePlayer, int currentV) {
        int newRoomSize = usersMap.length;
        if (movePlayer.equalsIgnoreCase("W")) {
            if (currentV > 0) {
                currentV--;
            } else {
                System.out.println(RED+"-**--**--**--**--**--**-"+RESET_COLOR);
                System.out.println(RED +"   du kan ej gå upp" + RESET_COLOR);
                System.out.println(RED+"-**--**--**--**--**--**-"+RESET_COLOR);
            }
        } else if (movePlayer.equalsIgnoreCase("S")) {
            if (currentV < newRoomSize - 1) {
                currentV++;
            } else {
                System.out.println(RED+"-**--**--**--**--**--**-"+RESET_COLOR);
                System.out.println(RED + "  du kan ej gå ner" + RESET_COLOR);
                System.out.println(RED+"-**--**--**--**--**--**-"+RESET_COLOR);
            }
        }
        return currentV;
    }

    public static void arrMethodChangePlaces(String movePlayer, int currentV, int currentH) {

        if (movePlayer.equalsIgnoreCase("d")) {

            //arr[currentV][currentH--] = WHITE+"[*]"+RESET_COLOR;
            usersMap[currentV][currentH] = RED + "[*]" + RESET_COLOR;
            //arr[currentV][currentH--] = WHITE+"[*]"+RESET_COLOR;
            //arr[currentV][currentH--] = RED+"[*]"+RESET_COLOR;
            //arr[currentV][currentH] = WHITE+"[*]"+RESET_COLOR; 

        } else if (movePlayer.equalsIgnoreCase("s")) {

            //arr[currentV--][currentH] = WHITE+"[*]"+RESET_COLOR; 
            usersMap[currentV][currentH] = RED + "[*]" + RESET_COLOR;
            //arr[currentV--][currentH] = WHITE+"[*]"+RESET_COLOR; 
            //arr[currentV--][currentH] = RED+"[*]"+RESET_COLOR; 
            //arr[currentV][currentH] = WHITE+"[*]"+RESET_COLOR; 

        } else if (movePlayer.equalsIgnoreCase("a")) {

            //arr[currentV][currentH++] =WHITE+ "[*]"+RESET_COLOR;
            usersMap[currentV][currentH] = RED + "[*]" + RESET_COLOR;
            //arr[currentV][currentH++] =WHITE+ "[*]"+RESET_COLOR;
            //arr[currentV][currentH++] =RED+ "[*]"+RESET_COLOR;
            //arr[currentV][currentH] = WHITE+"[*]"+RESET_COLOR;

        } else if (movePlayer.equalsIgnoreCase("w")) {

            //arr[currentV++][currentH] =WHITE+ "[*]"+RESET_COLOR;
            usersMap[currentV][currentH] = RED + "[*]" + RESET_COLOR;
            //arr[currentV++][currentH] =WHITE+ "[*]"+RESET_COLOR; 
            //arr[currentV++][currentH] =RED+ "[*]"+RESET_COLOR;
            //arr[currentV][currentH] = WHITE+"[*]"+RESET_COLOR;

        }

       
    }

    public static void walkTheMapFirstText() {
        System.out.println("You are located at the entrance, use W,A,S,D to move around the map");
    }
    
    public static int verticalRandomNumberGenExit(){
        int highestPossibleNr=usersMap.length-1;
        Random rand = new Random();
        int vRandExit=rand.nextInt(highestPossibleNr)+1;
        return vRandExit;
    }
    
    public static int horisontellRandomNumberGenExit(){//change to 1 method isnted of dos
        int highestPossibleNr=usersMap.length-1;
        Random rand = new Random();
        int hRandExit=rand.nextInt(highestPossibleNr)+1;
        return hRandExit;
    }
    
    public static boolean exitFound(int verticalRandom, int horisontellRandom, int currentV, int currentH){
        boolean quitGame = false;
        int userChoice;
        
        if(verticalRandom==currentV && horisontellRandom==currentH){
            System.out.println(GREEN+"-**--**--**--**--**--**-**--**--**-"+RESET_COLOR);
            System.out.println(GREEN+"You have found come across a door, you can see daylight on  \n"
                    + GREEN+"the other side, you can exit the door and youll exit the current map.\n"
                    + GREEN+"Keep playing [1], quit [2]");
            System.out.println(GREEN+"-**--**--**--**--**--**-**--**--**-"+RESET_COLOR);
            System.out.println(GREEN+"make your choice: "+RESET_COLOR);
                    
            
            userChoice=Input.getUserInputInt();
            switch(userChoice){
                case 1:quitGame=false;
                    
                    System.out.println("Alright, lets keep Adventureing!!!");
                    break;
                case 2:quitGame=true;
                    System.out.println("Coward! ok, lets end it here");
                break;
            }
        }
        return quitGame;
    }
    
    public static boolean quitToMainMenuChecker(int userChoiceOfMap){
        boolean quitToMainMenu = false;
        
        if(userChoiceOfMap==4){
            quitToMainMenu=true;
        }
        
        return quitToMainMenu;
    }

}

