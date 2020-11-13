
package dgsprinttwo;


public class Wizard extends Heroes{
   
  public Wizard(String name, int skatter) {
        super(name, skatter);
        initiativ = 7;
        talighet = 500;//ta bort 00.
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

