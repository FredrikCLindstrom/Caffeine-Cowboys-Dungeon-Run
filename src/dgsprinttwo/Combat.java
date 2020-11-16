package dgsprinttwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Combat {

    public static int counter = 0;

    public static ArrayList<inCombatInterface> combatList = new ArrayList<>();

    static int[] monsterdices = new int[4];

    public static void firstCombatMethod() {

        int amountOfDicesOfPlayer = DungeonRun.players.get(0).getInitiativ();
        int amountOfDicesOfMonsters = 0;
        for (Monster mon : randomGenerator.monsterListForCombat) {
            int counter = 0;
            amountOfDicesOfMonsters = mon.getInitiativ();
            monsterdices[counter] = amountOfDicesOfMonsters;
            // System.out.println(mon.getName()+" dices "+monsterdices[counter]);
            counter++;
        }

        //System.out.println("playerdice "+amountOfDicesOfPlayer);
        for (Monster mon : randomGenerator.monsterListForCombat) {
            mon.setDicesTotal(diceRoll(mon.getInitiativ()));
            System.out.println(mon.getName() + " " + mon.getDicesTotal());
        }
        DungeonRun.players.get(0).setDicesTotal(diceRoll(amountOfDicesOfPlayer));
        System.out.println(DungeonRun.players.get(0).getName() + " " + DungeonRun.players.get(0).getDicesTotal());

        DungeonRun.playMusic("Dice Rolling.wav");
        sortWhosFirst();

    }

    public static int diceRoll(int howManyDices) {
        int totalResult = 0;

        Random randNr = new Random();

        for (int i = 0; i < howManyDices; i++) {
            int randomNumber = randNr.nextInt(6);
            randomNumber++;

            System.out.print(" [" + randomNumber + "] ");
            totalResult = totalResult + randomNumber;

        }
        System.out.println("");

        return totalResult;
    }

    public static void sortWhosFirst() {

        for (int i = 0; i < randomGenerator.monsterListForCombat.size(); i++) {
            combatList.add(randomGenerator.monsterListForCombat.get(i));

        }

        combatList.add(DungeonRun.players.get(0));

        combatList.sort(Comparator.comparing(inCombatInterface::getTotalDicesInterf).reversed());

        randomGenerator.monsterListForCombat.sort(Comparator.comparing(Monster::getDicesTotal).reversed());

        int count = 1;
        System.out.println("*************************************");
        System.out.println("Attack order is as follows...");
        for (inCombatInterface participants : combatList) {
            System.out.println(count + ": " + participants.printStatsOfCombaters() + " ");
            count++;
        }
        System.out.println("**************************************");
        rollForAttack();
        /*
        randomGenerator.monsterListForCombat.sort(Comparator.comparing(Monster:: getDicesTotal).reversed());
        //randomGenerator.monsterListForCombat.forEach(System.out::println);
        for (Monster mon: randomGenerator.monsterListForCombat) {
            System.out.println(mon.getName()+" "+mon.getDicesTotal());
        }
         */

 /*
        if(DungeonRun.players.get(0).getDicesTotal()>randomGenerator.monsterListForCombat.get(0).getDicesTotal()){
            System.out.println("spelare have biggest number");
            //choose attack    chooseAttack.player
        }
        
        else if(DungeonRun.players.get(0).getDicesTotal()<randomGenerator.monsterListForCombat.get(0).getDicesTotal()){
        }
         */
    }

    public static void rollForAttack() {
        int totalDeadCount = 1;
        counter = 0;
        while (totalDeadCount < combatList.size() && DungeonRun.players.get(0).getIsAlive() == true) {
            //           System.out.println("total dead count= "+totalDeadCount);//ta bort
            //           System.out.println("combat list size="+combatList.size());

            for (int i = 0; i < combatList.size(); i++) {//combatList.size

                if (combatList.get(i).getClass().equals(Knight.class) || combatList.get(i).getClass().equals(Wizard.class) || combatList.get(i).getClass().equals(Thief.class)) {

                    totalDeadCount = totalDeadCount + playerAttacks();
                    //spelare attacker monster

                }
                if (combatList.get(i).getClass().equals(Skelett.class) || combatList.get(i).getClass().equals(Spider.class) || combatList.get(i).getClass().equals(Troll.class) || combatList.get(i).getClass().equals(Orc.class)) {
                    //System.out.println("monster börjar");
                    monsterAttacks(i);
                    //spelare attacker monster

                }
            }
        }

        if (totalDeadCount == combatList.size()) {
            DungeonRun.playMusic("Win.wav");
        }
        //combatList.clear();
    }

    public static int playerAttacks() {
        //Monster monsterArray[] = new Monster[randomGenerator.monsterListForCombat.size()];
        boolean oneTime = true;
        int damage = 0;
        int deadCount = 0;

        while (DungeonRun.players.get(0).getTalighet() > 0 && oneTime == true) {

            damage = 0;

            for (int i = 0; i < randomGenerator.monsterListForCombat.size(); i++) {

                if (randomGenerator.monsterListForCombat.get(i).getTalighet() > 0) {
                    System.out.println(randomGenerator.monsterListForCombat.get(i));
                }

            }
            for (int i = 0; i < randomGenerator.monsterListForCombat.size(); i++) {
                if (randomGenerator.monsterListForCombat.get(i).getTalighet() > 0) {
                    System.out.println(Maps.PURPLE + "Press enter to throw dices against " + randomGenerator.monsterListForCombat.get(i).getName() + " :" + Maps.RESET_COLOR);
                    Input.getUserInputString();
                    DungeonRun.playMusic("Dice Rolling.wav");
                    System.out.println(DungeonRun.players.get(0).getName() + " throws dice");// TODO add sound
                    damage = diceRoll(DungeonRun.players.get(0).getAttack());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    if (damage > randomGenerator.monsterListForCombat.get(i).getSmidighet()) {
                        System.out.println(Maps.GREEN + "- Hit -" + Maps.RESET_COLOR);
                        DungeonRun.playMusic("Punch.wav");

                        if (DungeonRun.players.get(0).getClass().equals(Thief.class)) {
                            int chance = 25;
                            int randomnumber = randomGenerator.rand.nextInt(99);

                            if (chance >= randomnumber) {
                                try {
                                    Thread.sleep(600);
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }
                                System.out.println("Special Ability. thief makes double damage!");
                                randomGenerator.monsterListForCombat.get(i).removeOneLife();
                                System.out.println(Maps.GREEN + "- Hit -" + Maps.RESET_COLOR);
                                DungeonRun.playMusic("Punch.wav");
                                System.out.println(DungeonRun.players.get(0).getName() + " hurts " + randomGenerator.monsterListForCombat.get(i).getName() + ", lives left " + randomGenerator.monsterListForCombat.get(i).getTalighet());
                            }
                        }

                        randomGenerator.monsterListForCombat.get(i).removeOneLife();
                        System.out.println(DungeonRun.players.get(0).getName() + " hurts " + randomGenerator.monsterListForCombat.get(i).getName() + ", lives left " + randomGenerator.monsterListForCombat.get(i).getTalighet());

                        if (randomGenerator.monsterListForCombat.get(i).getTalighet() < 1) {

                            System.out.println("You have killed " + randomGenerator.monsterListForCombat.get(i).getName());
                            System.out.println(Maps.RED + "DEAD " + randomGenerator.monsterListForCombat.get(i) + Maps.RESET_COLOR);
                            deadCount++;
                            DungeonRun.players.get(0).addMonsterKills(1);
                        }
                    } else {
                        System.out.println(Maps.CYAN + DungeonRun.players.get(0).getName() + " missed" + Maps.RESET_COLOR);
                    }

                }

            }
            oneTime = false;
        }
        return deadCount;
    }

    public static void monsterAttacks(int inputnr) {

        boolean playerIsDead = false;
        boolean oneTime = true;
        int damage = 0;
        int i = inputnr;

        while (DungeonRun.players.get(0).getTalighet() > 0 && oneTime == true) {

            damage = 0;

            /*
            for (int i = 0; i < randomGenerator.monsterListForCombat.size(); i++) {
                
                System.out.println("dis"+randomGenerator.monsterListForCombat.get(i));
                
            }
             */
            //for (int i = inputnr; i < randomGenerator.monsterListForCombat.size(); i++) {
            if (DungeonRun.players.get(0).getTalighet() > 0 && combatList.get(i).getTalighet() > 0) { //changed
                System.out.println(Maps.PURPLE + combatList.get(i).getName() + " is about to attack, push enter to brace for impact!" + Maps.RESET_COLOR);//changed
                Input.getUserInputString();
                DungeonRun.playMusic("Dice Rolling.wav");
                System.out.println(combatList.get(i).getName() + " throws dice");//changed
                damage = diceRoll(combatList.get(i).getAttack());//changed

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                if (damage > DungeonRun.players.get(0).getSmidighet()) {

                    if (DungeonRun.players.get(0).getClass().equals(Knight.class) && counter < 1) {
                        System.out.println("Knight uses special ability, blocks first attack!");
                        counter++;
                        break;

                    }

                    System.out.println(Maps.RED + "***** hit, it hurts! *****" + Maps.RESET_COLOR);
                    DungeonRun.playMusic("Pain.wav");
                    DungeonRun.players.get(0).removeOneLife();
                    System.out.println("Monster removes one life from " + DungeonRun.players.get(0).getName() + ", its now >>> " + DungeonRun.players.get(0).getTalighet() + " lifes left");

                    if (DungeonRun.players.get(0).getTalighet() < 1 && combatList.get(i).getTalighet() > 0) {//changed

                        System.out.println(Maps.RED + combatList.get(i).getName() + " have killed you " + Maps.RESET_COLOR);//changed
                        DungeonRun.players.get(0).setIsAlive(false);
                        death();
                    }

                } else {
                    System.out.println(Maps.GREEN + combatList.get(i).getName() + " Missed!!!" + Maps.RESET_COLOR);//changed

                }

            }

            oneTime = false;

            //}
        }

        //randomGenerator.monsterListForCombat.clear();
    }

    public static void death() {
        DungeonRun.playMusic("Lose.wav");
        System.out.println("                \n"
                + "             ;::::;\n"
                + "           ;::::; :;\n"
                + "         ;:::::'   :;\n"
                + "        ;:::::;     ;.\n"
                + "       ,:::::'       ;           OOO\\\n"
                + "       ::::::;       ;          OOOOO\\\n"
                + "       ;:::::;       ;         OOOOOOOO\n"
                + "      ,;::::::;     ;'         / OOOOOOO\n"
                + "    ;:::::::::`. ,,,;.        /  / DOOOOOO\n"
                + "  .';:::::::::::::::::;,     /  /     DOOOO\n"
                + " ,::::::;::::::;;;;::::;,   /  /        DOOO\n"
                + ";`::::::`'::::::;;;::::: ,#/  /          DOOO\n"
                + ":`:::::::`;::::::;;::: ;::#  /            DOOO\n"
                + "::`:::::::`;:::::::: ;::::# /              DOO\n"
                + "`:`:::::::`;:::::: ;::::::#/               DOO\n"
                + " :::`:::::::`;; ;:::::::::##                OO\n"
                + " ::::`:::::::`;::::::::;:::#                OO\n"
                + " `:::::`::::::::::::;'`:;::#                O\n"
                + "  `:::::`::::::::;' /  / `:#\n"
                + "   ::::::`:::::;'  /  /   `#  ");
        System.out.println(Maps.RED + "  ▄▄ •  ▄▄▄· • ▌ ▄ ·. ▄▄▄ .           ▌ ▐·▄▄▄ .▄▄▄      \n"
                + Maps.RED + "▐█ ▀ ▪▐█ ▀█ ·██ ▐███▪▀▄.▀·    ▪     ▪█·█▌▀▄.▀·▀▄ █·    \n"
                + Maps.RED + "▄█ ▀█▄▄█▀▀█ ▐█ ▌▐▌▐█·▐▀▀▪▄     ▄█▀▄ ▐█▐█•▐▀▀▪▄▐▀▀▄     \n"
                + Maps.RED + "▐█▄▪▐█▐█ ▪▐▌██ ██▌▐█▌▐█▄▄▌    ▐█▌.▐▌ ███ ▐█▄▄▌▐█•█▌    \n"
                + Maps.RED + "·▀▀▀▀  ▀  ▀ ▀▀  █▪▀▀▀ ▀▀▀      ▀█▄▀▪. ▀   ▀▀▀ .▀  ▀   " + Maps.RESET_COLOR);
        DungeonRun.dead = true;
        System.out.println("Player " + DungeonRun.players.get(0).getName() + " killed: " + DungeonRun.players.get(0).getMonsterKills() + " Monsters and collected " + DungeonRun.players.get(0).getSkatter() + " points");
        Input.getUserInputString();
    }
}
