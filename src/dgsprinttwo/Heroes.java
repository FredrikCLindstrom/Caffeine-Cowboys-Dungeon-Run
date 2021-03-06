
package dgsprinttwo;




public class Heroes extends UltimateSuperClass implements inCombatInterface{
    
   
    protected int initiativ;
    protected int talighet;
    protected int attack;
    protected int smidighet;
    protected String name;
    protected int skatter;
    protected int dicesTotal;
    protected boolean isAlive=true;
    protected int monsterKills=0;
    
    @Override
    public String printStatsOfCombaters() {
        return getName();
    }
    
    @Override
    public int getTotalDicesInterf() {
        return getDicesTotal();
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    
    
    public int getDicesTotal() {
        return dicesTotal;
    }

    public void setDicesTotal(int dicesTotal) {
        this.dicesTotal = dicesTotal;
    }
    
    public Heroes(String name, int skatter) {

   
        this.name = name;
    }

    
      public void specialAttack(){
        
    
      }
    
    public Heroes() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    public int getInitiativ() {
        return initiativ;
    }

    public int getAttack() {
        return attack;
    }

    public int getSmidighet() {
        return smidighet;
    }

    public int getTalighet() {
        return talighet;
    }

    
    public int getSkatter() {
        return skatter;
    }
    
    public int addSkatter(int t){
       skatter = skatter +t;
       return skatter;
        
    }

    public void setSkatter(int skatter) {
        this.skatter = skatter;
    }


    public void setTalighet(int talighet) {
        this.talighet = talighet;
    }


    
    
      
    public void removeOneLife() {
        int newTalighet=getTalighet()-1;
        talighet=newTalighet;
    }           

    public int getMonsterKills() {
        return monsterKills;
    }

    public void setMonsterKills(int monsterKills) {
        this.monsterKills = monsterKills;
    }

    public void addMonsterKills(int monsterKills) {
        this.monsterKills =getMonsterKills()+ monsterKills;
    }
    
   
     @Override
     public String toString() {
          
                 
         return "*********************************************" +
                "\n" + getName() +
                "\nIntitativ: " + initiativ +
                "\nTalighet: " + talighet + 
                "\nAttack: " + attack + 
                "\nSmidighet: " + smidighet + 
                "\nPoäng: " + skatter + 
                "\n*********************************************\n";
                 
                 
                /*  getName() + "\n" +
                 " (initiative = " + initiativ +
                 ", tålighet = " + talighet +
                 ", attack = " + attack +
                 ", smidighet = " + smidighet +
                 ", Poäng = " + skatter +
                 '}';*/
     }
 }



