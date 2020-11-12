
package dgsprinttwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class Combat {
    
    static ArrayList<inCombatInterface>combatList =new ArrayList<>();
    
    static int [] monsterdices= new int[4];
    
    
    public static void firstCombatMethod(){
        
       
       
       int amountOfDicesOfPlayer=DungeonRun.players.get(0).getInitiativ();
       int amountOfDicesOfMonsters=0;
        for (Monster mon : randomGenerator.monsterListForCombat) {
            int counter = 0;
            amountOfDicesOfMonsters=mon.getInitiativ();
            monsterdices[counter]=amountOfDicesOfMonsters;
           // System.out.println(mon.getName()+" dices "+monsterdices[counter]);
            counter++;
        }
        
        //System.out.println("playerdice "+amountOfDicesOfPlayer);
        
        DungeonRun.players.get(0).setDicesTotal(diceRoll(amountOfDicesOfPlayer));
        System.out.println(DungeonRun.players.get(0).getName()+" "+DungeonRun.players.get(0).getDicesTotal());
        
        for (Monster mon : randomGenerator.monsterListForCombat) {
            mon.setDicesTotal(diceRoll(mon.getInitiativ()));
            System.out.println(mon.getName()+ " " +mon.getDicesTotal());
        }
        
        sortWhosFirst();
        
    }
    
    public static int diceRoll(int howManyDices){
        int totalResult=0;
        
        Random randNr=new Random();
        
        
        for (int i = 0; i < howManyDices; i++) {
            int randomNumber=randNr.nextInt(6);
            randomNumber++;
            System.out.println("dice nr "+(i+1)+" result: "+randomNumber);
            totalResult=totalResult+randomNumber;
            
        }
        
        
        
        return totalResult;
    }
    
    public static void sortWhosFirst(){
        
        
        
        
        
        for (int i = 0; i < randomGenerator.monsterListForCombat.size(); i++) {
            combatList.add(randomGenerator.monsterListForCombat.get(i));
            
        }
        
        combatList.add(DungeonRun.players.get(0));
        
        combatList.sort(Comparator.comparing(inCombatInterface::getTotalDicesInterf).reversed());
        
        System.out.println("Attack order is as follows...");
        for (inCombatInterface participants: combatList) {
            System.out.println(participants.printStatsOfCombaters());
        }
        
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
    
    public static void rollForAttack(){
        

        
        if(combatList.get(0).getClass().equals(Knight.class)||combatList.get(0).getClass().equals(Wizard.class)||combatList.get(0).getClass().equals(Thief.class)){
            System.out.println("spelare börjar");
            playerAttacks();
            //spelare attacker monster
        }
        if(combatList.get(0).getClass().equals(Skelett.class)||combatList.get(0).getClass().equals(Spider.class)||combatList.get(0).getClass().equals(Troll.class)||combatList.get(0).getClass().equals(Orc.class)){
            System.out.println("monster börjar");
            //spelare attacker monster
        }
                
        combatList.clear();
    }
    
    public static void playerAttacks() {
        Monster monsterArray[] = new Monster[randomGenerator.monsterListForCombat.size()];
        
        while (DungeonRun.players.get(0).getTalighet()>0) {

            for (int i = 0; i < monsterArray.length; i++) {
                monsterArray[i] = randomGenerator.monsterListForCombat.get(i);
                System.out.println(monsterArray[i]);
                DungeonRun.players.get(0).setTalighet(DungeonRun.players.get(0).getTalighet()-1);
                //System.out.println(DungeonRun.players.get(0).getTalighet());
            }
            for (int i = 0; i < 10; i++) {
                
            }
        }

    }
    
    public static void monsterAttacks(){
        
        //todo fill
    }
    
}
