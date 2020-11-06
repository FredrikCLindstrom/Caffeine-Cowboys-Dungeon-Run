
package dgsprinttwo;




public class Heroes {
    
   
    protected int initiativ;
    protected int talighet;
    protected int attack;
    protected int smidighet;
    protected String name;
    
    public Heroes(String name) {

   
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

   public void Stats(){
       //return Stats();
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



