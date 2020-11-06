
package dgsprinttwo;


public class Monster {
  
   
    protected int initiativ;
    protected int talighet;
    protected int attack;
    protected int smidighet;
 
    
    
    
    public Monster() {
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




