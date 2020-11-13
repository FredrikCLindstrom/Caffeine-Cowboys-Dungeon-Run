
package dgsprinttwo;


 public class Troll extends Monster{
        
  public Troll() {
        super();
        initiativ = 2;
        talighet = 4;
        attack = 7;
        smidighet = 2;
        name = "Troll";
   
      }
    

    @Override
    public String toString() {
        return "Troll"+super.toString();
    }
}





