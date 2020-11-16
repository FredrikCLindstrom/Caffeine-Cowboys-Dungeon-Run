package dgsprinttwo;


public class Wizard extends Heroes{
   
  public Wizard(String name, int skatter) {
        super(name, skatter);
        initiativ = 6;
        talighet = 4;//ska vara 4
        attack = 9;
        smidighet = 5;//

 
        
      }

@Override
     public void specialAttack(){
        
    
      }

  

    @Override
    public String toString() {
        return "Wizard"+super.toString();
    }
}


