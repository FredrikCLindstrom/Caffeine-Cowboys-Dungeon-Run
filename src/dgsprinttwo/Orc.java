
package dgsprinttwo;


 public class Orc extends Monster{
        
 public Orc() {
        super();
        initiativ = 4;
        talighet = 2;
        attack = 3;
        smidighet = 3;
        name = "Orc";
        
      }
    
    
   
        
        
    
    
    @Override
    public String toString() {
        return "Orc"+super.toString();
    }
}




