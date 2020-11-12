package dgsprinttwo;

import java.util.Random;

public class randomGenerator {

    static Random rand = new Random();

    public static int treasuresGenRun() {
        int howManyTreasurePoints = 0;
        howManyTreasurePoints = looseChange();
        howManyTreasurePoints = howManyTreasurePoints + moneyBag();
        howManyTreasurePoints = howManyTreasurePoints + goldJewelry();
        howManyTreasurePoints = howManyTreasurePoints + preciousStone();
        howManyTreasurePoints = howManyTreasurePoints + smallTreasureChest();
        DungeonRun.players.get(0).addSkatter(howManyTreasurePoints);
        return howManyTreasurePoints;
    }

    public static int monstersGenRun() {
        int HowManyMonsters = 0;
        HowManyMonsters = giantSpider();
        HowManyMonsters = HowManyMonsters + skelleton();
        HowManyMonsters = HowManyMonsters + orc();
        HowManyMonsters = HowManyMonsters + troll();
        
        return HowManyMonsters;
    }

    public static int looseChange() {
        int randomNr = rand.nextInt(20);
        int howManyTreasurePoints = 0;
        if (randomNr < 8) {
            System.out.println(Maps.YELLOW+"Loose change found, 2 points"+Maps.RESET_COLOR);
            howManyTreasurePoints = 2;
            
           
        }
        return howManyTreasurePoints;
    }

    public static int moneyBag() {
        int randomNr = rand.nextInt(20);
        int howManyTreasurePoints = 0;
        if (randomNr > 7 && randomNr < 12) {
            System.out.println(Maps.YELLOW+"Money bag found, 6 points"+Maps.RESET_COLOR);
            howManyTreasurePoints = 6;
    
        }
        return howManyTreasurePoints;
    }

    public static int goldJewelry() {
        int randomNr = rand.nextInt(20);
        int howManyTreasurePoints = 0;
        if (randomNr > 11 && randomNr < 15) {
            System.out.println(Maps.YELLOW+"Gold Jewelry found, 10 points"+Maps.RESET_COLOR);
            howManyTreasurePoints = 10;
          
        }
        return howManyTreasurePoints;
    }

    public static int preciousStone() {
        int randomNr = rand.nextInt(20);
        int howManyTreasurePoints = 0;
        if (randomNr > 14 && randomNr < 17) {
            System.out.println(Maps.YELLOW+"A Precious Stone found, 14 points"+Maps.RESET_COLOR);
            howManyTreasurePoints = 14;
      
        }
        return howManyTreasurePoints;
    }

    public static int smallTreasureChest() {
        int randomNr = rand.nextInt(20);
        int howManyTreasurePoints = 0;
        if (randomNr > 18) {
            System.out.println(Maps.YELLOW+"JACKPOT!!! A Small Treasurechest is found, 20 points"+Maps.RESET_COLOR);
            howManyTreasurePoints = 20;
           
        }
        return howManyTreasurePoints;
    }

    public static int giantSpider() {
        int randomNr = rand.nextInt(20);
        int howManyMonsters = 0;
        if (randomNr < 4) {
            System.out.println("[Giant Spider] ohhhhhhh, scary");
            //giantSpider.toString();
            howManyMonsters++;
        }
        return howManyMonsters;
    }

    public static int skelleton() {
        int randomNr = rand.nextInt(20);
        int howManyMonsters = 0;
        if (randomNr > 3 && randomNr < 7) {
            System.out.println("[Skelleton]!!! oh no");
            //skelleton.toString();
            howManyMonsters++;
        }
        return howManyMonsters;
    }

    public static int orc() {
        int randomNr = rand.nextInt(20);
        int howManyMonsters = 0;
        if (randomNr > 7 && randomNr < 10) {
            System.out.println("[Orc]! this is not good....");
            //orc.toString();
            howManyMonsters++;
        }
        return howManyMonsters;
    }

    public static int troll() {
        int randomNr = rand.nextInt(20);
        int howManyMonsters = 0;
        if (randomNr > 10 && randomNr < 12) {
            System.out.println("[Troll], this is NOT a drill!!!!");
            //troll.toString();
            howManyMonsters++;
        }
        return howManyMonsters;
    }

}
