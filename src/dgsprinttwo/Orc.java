
package dgsprinttwo;


 public class Orc extends Monster{
        
 public Orc() {
        super();
        initiativ = 6;
        talighet = 3;
        attack = 4;
        smidighet = 4;
        name = "Orc";
        
      }
    
    
   
        
        
    
    
    @Override
    public String toString() {
        return "Orc"+super.toString();
    }
}



