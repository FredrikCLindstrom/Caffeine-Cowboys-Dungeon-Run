
package dgsprinttwo;


public class Monster extends UltimateSuperClass implements inCombatInterface{
  
   
    protected int initiativ;
    protected int talighet;
    protected int attack;
    protected int smidighet;
    protected String name;
    protected int dicesTotal;
    protected boolean isAlive=true;

    @Override
    public String printStatsOfCombaters() {
        return getName();
    }
    
    
    
    @Override
    public int getTotalDicesInterf() {
        return getDicesTotal();
    }

    public int getDicesTotal() {
        return dicesTotal;
    }

    public void setDicesTotal(int dicesTotal) {
        this.dicesTotal = dicesTotal;
    }
    
    
    public Monster() {
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

    public void removeOneLife() {
        int newTalighet=getTalighet()-1;
        talighet=newTalighet;
    }
    


    


   
     @Override
     public String toString() {
         return
                 " {initiative=" + initiativ +
                 ", tålighet=" + talighet +
                 ", attack=" + attack +
                 ", smidighet=" + smidighet +

                 '}';
     }
 }




