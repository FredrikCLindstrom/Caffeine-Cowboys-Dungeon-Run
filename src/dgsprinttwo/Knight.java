
package dgsprinttwo;


public class Knight extends Heroes{
   
    
    public Knight(String name) {
        super(name);
        initiativ = 5;
        talighet = 9;
        attack = 6;
        smidighet = 6;
         
    }
    @Override
    public void specialAttack(){
        
    
      }
    
    @Override
    public String toString() {
        return "Knight"+super.toString();
    }
}
