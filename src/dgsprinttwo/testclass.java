
package dgsprinttwo;

import static dgsprinttwo.DungeonRun.players;



public class testclass {
    
    
    
    public static void choiceTest(){
        int choice =0;
        
        
        
        choice=Input.getUserInputInt();
        
        
        //for (int i = 0; i < 3; i++) {
            if(choice==1){
                Heroes player = new Knight("namn", 0);
                players.add(player);
                //todo, add to index 0
            }
            else if(choice==2){
            Heroes player = new Wizard("namn", 0);
            players.add(player);
           
        }
        else if(choice==3){
            Heroes player = new Thief("namn", 0);
            players.add(player);
            
        }
            
    }
   
   // }
    
}

