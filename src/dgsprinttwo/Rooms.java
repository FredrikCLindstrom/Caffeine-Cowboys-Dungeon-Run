package dgsprinttwo;

public class Rooms {

    static int counter = 0;

    public static void runAwayOrFightMethod(int howManyMonsters) {

        if (howManyMonsters > 0) {
            System.out.println(Maps.CYAN+"You're facing " + howManyMonsters + " monster right now, [1] run or [2] fight?"+Maps.RESET_COLOR);
            int choice = Input.getUserInputInt();
            switch (choice) {
                case 1:
                    System.out.println("you choose to run");
                    //call runaway method
                    //runAway = true; = inga skatter
                    break;
                case 2:
                    System.out.println("you choose to fight");
                    //call fight method
                    //runAway = false;= kala på skatter vid vinst
                    break;
                default:
                    System.out.println("default");
                //runAway = false;

            }

        } else {
            System.out.println("No monsters in this room, lucky you");
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
        howManyMonsters = randomGenerator.monstersGenRun();
        howMuchTreasurePoints = randomGenerator.treasuresGenRun();

        runAwayOrFightMethod(howManyMonsters);

        System.out.println(Maps.YELLOW+"[you collected " + howMuchTreasurePoints + " points]"+Maps.RESET_COLOR);

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

}
