package dgsprinttwo;

import static dgsprinttwo.randomGenerator.rand;
import java.util.ArrayList;

public class Rooms {

    static int counter = 0;

    public static void runAwayOrFightMethod() {
        int howMuchTreasurePoints = 0;
        randomGenerator.monstersGenRun();
        
        if (randomGenerator.monsterListForCombat.size()> 0) {
            System.out.println(Maps.CYAN+"You're facing " + randomGenerator.monsterListForCombat.size() + " monster right now, [1] run or [2] fight?"+Maps.RESET_COLOR);
            int choice = Input.getUserInputInt();
            switch (choice) {
                case 1:
                    System.out.println("you choose to run");
                    tryToRunAway();
                    
                    randomGenerator.monsterListForCombat.clear();
                    Combat.combatList.clear();
                    
                    break;
                case 2:
                    System.out.println("you choose to fight");
                    combatRoom();
                    Combat.firstCombatMethod();
                    randomGenerator.monsterListForCombat.clear();
                    Combat.combatList.clear();
                    if(DungeonRun.dead==false){
                    howMuchTreasurePoints = randomGenerator.treasuresGenRun();

                    System.out.println(Maps.YELLOW + "[you collected " + howMuchTreasurePoints + " points]" + Maps.RESET_COLOR);
                    }
                    break;
                default:
                    System.out.println("default");
                //runAway = false;

            }

        } else {
            System.out.println("No monsters in this room, lucky you");
            howMuchTreasurePoints = randomGenerator.treasuresGenRun();

            System.out.println(Maps.YELLOW + "[you collected " + howMuchTreasurePoints + " points]" + Maps.RESET_COLOR);
        }
    }

    public static boolean decideToExitOrNot(int currentV, int currentH, int verticalRandom, int horisontellRandom) {

        boolean quitGame = false;

        if (checkIfAtExit(currentV, currentH, verticalRandom, horisontellRandom) == true) {
            Maps.printMap();
            if (currentV == verticalRandom && currentH == horisontellRandom) {
                quitGame = Maps.exitFound(verticalRandom, horisontellRandom, currentV, currentH);
            }
        }
        return quitGame;
    }
    
    public static void firstTimeInRoom(int currentV, int currentH) {
        int howManyMonsters = 0;
        int howMuchTreasurePoints = 0;

        Maps.printMap();
        
        runAwayOrFightMethod();
        
        //howMuchTreasurePoints = randomGenerator.treasuresGenRun();

        

        //System.out.println(Maps.YELLOW+"[you collected " + howMuchTreasurePoints + " points]"+Maps.RESET_COLOR);

    }

    public static void makeExitGreenIfFound(int verticalRandom, int horisontellRandom) {

        for (int i = 0; i < Maps.verticalArray.length; i++) {
            if (verticalRandom == Maps.verticalArray[i] && horisontellRandom == Maps.horisontellArray[i]) {
                Maps.usersMap[verticalRandom][horisontellRandom] = Maps.GREEN + "[#]" + Maps.RESET_COLOR;
            }

        }
    }

    public static boolean checkIfAtExit(int currentV, int currentH, int verticalRandom, int horisontellRandom) {

        boolean isAtExit = false;

        if (currentV == verticalRandom && currentH == horisontellRandom) {
            isAtExit = true;
        }

        return isAtExit;
    }

    public static void combatRoom() {
        
        for (Monster obj : randomGenerator.monsterListForCombat) {
            System.out.println(obj.toString());
        }
       
    }
    
    
    public static void tryToRunAway(){
        
        int smidighet=DungeonRun.players.get(0).getSmidighet()*10;
        int randomOneToHundred=randomGenerator.rand.nextInt(99);
        try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
        if(DungeonRun.players.get(0).getClass().equals(Wizard.class)){
            smidighet=80;
        }
        
        if(randomOneToHundred<smidighet){
            System.out.println(Maps.GREEN+"********************************"+Maps.RESET_COLOR);
            System.out.println(Maps.GREEN+" You successfully fled the room"+Maps.RESET_COLOR);
            System.out.println(Maps.GREEN+"********************************"+Maps.RESET_COLOR);
            if(DungeonRun.players.get(0).getClass().equals(Wizard.class)){
                System.out.println("Special ability: Wizard Throws lightning bolt and escapes");
        }
        }
        else{
            System.out.println(Maps.PURPLE+"<><><><><><><><><><><><><><><><><><>"+Maps.RESET_COLOR);
            System.out.println(Maps.PURPLE+" You cannot flee, you must fight!!!"+Maps.RESET_COLOR);
            System.out.println(Maps.PURPLE+"<><><><><><><><><><><><><><><><><><>"+Maps.RESET_COLOR);
            System.out.println("Ready or not, you have to fight, press enter to continue");
            Input.getUserInputString();
            combatRoom(); 
            Combat.firstCombatMethod();
        }
    }
}
