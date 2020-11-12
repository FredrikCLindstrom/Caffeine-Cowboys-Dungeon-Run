
package dgsprinttwo;




public class Heroes {
    
   
    protected int initiativ;
    protected int talighet;
    protected int attack;
    protected int smidighet;
    protected String name;
    protected int skatter;
    
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

    public void setSkatter(int skatter) {
        this.skatter = skatter;
    }

    public int addSkatter(int t){
       skatter = skatter +t;
       return skatter;
       
    }
    
    
      
               


    
   
     @Override
     public String toString() {
         return
                 " (initiative = " + initiativ +
                 ", tålighet = " + talighet +
                 ", attack = " + attack +
                 ", smidighet = " + smidighet +
                 ", Poäng = " + skatter +
                 '}';
     }
 }



