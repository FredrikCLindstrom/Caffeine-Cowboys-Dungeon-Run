
package dgsprinttwo;


 public class Troll extends Monster{
        
  public Troll() {
        super();
        initiativ = 4;
        talighet = 2;
        attack = 3;
        smidighet = 3;

   
      }
    

    @Override
    public String toString() {
        return "Troll"+super.toString();
    }
}





