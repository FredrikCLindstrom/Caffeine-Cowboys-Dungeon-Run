
package dgsprinttwo;


public class Wizard extends Heroes{
   
  public Wizard(String name) {
        super(name);
        initiativ = 7;
        talighet = 5;
        attack = 5;
        smidighet = 7;

 
      }

@Override
     public void specialAttack(){
        
    
      }

  

    @Override
    public String toString() {
        return "Wizard"+super.toString();
    }
}

