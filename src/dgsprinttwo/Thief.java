
package dgsprinttwo;


public class Thief extends Heroes{
   
    
  public Thief(String name) {
        super(name);
        initiativ = 6;
        talighet = 4;
        attack = 9;
        smidighet = 5;
         

    
      }
    
    @Override
     public void specialAttack(){
        
    
      }
    
        
        
    
    
    @Override
    public String toString() {
        return "Thief"+super.toString();
    }
}


