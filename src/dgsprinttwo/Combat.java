
package dgsprinttwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class Combat {
    
    public static ArrayList<inCombatInterface>combatList =new ArrayList<>();
    
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
            System.out.print(" ["+randomNumber+"] ");
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
        randomGenerator.monsterListForCombat.sort(Comparator.comparing(Monster::getDicesTotal).reversed());
        
        int count=1;
        System.out.println("*************************************");
        System.out.println("Attack order is as follows...");
        for (inCombatInterface participants: combatList) {
            System.out.println(count+": "+participants.printStatsOfCombaters()+" ");
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
    
    public static void rollForAttack(){
        int totalDeadCount=0;
        
        while(totalDeadCount<combatList.size()){
        
        for (int i = 0; i < combatList.size(); i++) {
            
        
        if(combatList.get(i).getClass().equals(Knight.class)||combatList.get(i).getClass().equals(Wizard.class)||combatList.get(i).getClass().equals(Thief.class)){
            

            totalDeadCount = totalDeadCount+playerAttacks(i);
            //spelare attacker monster
            
        }
        if(combatList.get(i).getClass().equals(Skelett.class)||combatList.get(i).getClass().equals(Spider.class)||combatList.get(i).getClass().equals(Troll.class)||combatList.get(i).getClass().equals(Orc.class)){
            //System.out.println("monster börjar");
            monsterAttacks(i);
            //spelare attacker monster
            
        }
        }
        }
                
        //combatList.clear();
    }
    
    public static int playerAttacks(int inputnr) {
        //Monster monsterArray[] = new Monster[randomGenerator.monsterListForCombat.size()];
        boolean oneTime = true;
        int damage = 0;
        int deadCount=0;

        while (DungeonRun.players.get(0).getTalighet() > 0 && oneTime == true) {
            
            damage = 0;

            for (int i = inputnr; i < randomGenerator.monsterListForCombat.size(); i++) {
                
                if(randomGenerator.monsterListForCombat.get(i).getTalighet()>0){
                System.out.println("dis is player"+randomGenerator.monsterListForCombat.get(i));
                }
                
                
            }
            for (int i = 0; i < randomGenerator.monsterListForCombat.size(); i++) {
                if (randomGenerator.monsterListForCombat.get(i).getTalighet() > 0) {
                    System.out.println("Press enter to throw dices:");
                    Input.getUserInputString();
                    System.out.println(DungeonRun.players.get(0).getName()+" throws dice");// TODO add sound
                    damage = diceRoll(DungeonRun.players.get(0).getAttack());
                    if (damage > randomGenerator.monsterListForCombat.get(i).getSmidighet()) {
                        System.out.println("hit");
                        randomGenerator.monsterListForCombat.get(i).removeOneLife();
                        System.out.println(DungeonRun.players.get(0).getName()+" hurts " + randomGenerator.monsterListForCombat.get(i).getName()+" has lives left "+randomGenerator.monsterListForCombat.get(i).getTalighet());
                    } else {
                        System.out.println(DungeonRun.players.get(0).getName()+" missed");
                    }

                }

                if (randomGenerator.monsterListForCombat.get(i).getTalighet() < 1) {
                    
                    
                    System.out.println("you have killed " + randomGenerator.monsterListForCombat.get(i).getName());
                    System.out.println(Maps.RED+"DEAD "+randomGenerator.monsterListForCombat.get(i)+Maps.RESET_COLOR);
                    deadCount++;
                }
            }
            oneTime = false;
        }
        return deadCount;
    }
    
    public static void monsterAttacks(int inputnr){
        
        boolean playerIsDead=false;
        boolean oneTime=true;
        int damage=0;
        while (DungeonRun.players.get(0).getTalighet()>0 && oneTime==true) {
            
            damage=0;
            int printCount=0;
            /*
            for (int i = 0; i < randomGenerator.monsterListForCombat.size(); i++) {
                
                System.out.println("dis"+randomGenerator.monsterListForCombat.get(i));
                
            }
            */
            for (int i = inputnr; i < randomGenerator.monsterListForCombat.size(); i++) {
                if(DungeonRun.players.get(0).getTalighet()>0 && randomGenerator.monsterListForCombat.get(i).getTalighet()>0){
                    System.out.println(randomGenerator.monsterListForCombat.get(i).getName()+" is about to attack, push enter to brace for impact!"); 
                    Input.getUserInputString();
                System.out.println(randomGenerator.monsterListForCombat.get(i).getName()+" throws dice");
                damage=diceRoll(randomGenerator.monsterListForCombat.get(i).getAttack());
                if(damage>DungeonRun.players.get(0).getSmidighet()){
                    System.out.println("***** hit, it hurts! *****");
                    DungeonRun.players.get(0).removeOneLife();
                System.out.println("Monster removes one life, "+DungeonRun.players.get(0).getName()+" "+DungeonRun.players.get(0).getTalighet()+" lifes left");
                
                }
                else{
                    System.out.println(randomGenerator.monsterListForCombat.get(i).getName()+" He missed!!!");
                    
                }
                
                }
                
                if(DungeonRun.players.get(0).getTalighet()<1 && randomGenerator.monsterListForCombat.get(i).getTalighet()>0 && printCount<1){
                    
                    System.out.println(randomGenerator.monsterListForCombat.get(i).getName()+" have killed you ");
                    
                }
                oneTime=false;
                break;
            }
            
            
        }
        
        //randomGenerator.monsterListForCombat.clear();
    }
    
    
    
}
