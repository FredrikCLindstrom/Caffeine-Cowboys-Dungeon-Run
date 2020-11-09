package dgsprinttwo;

import java.awt.EventQueue;//importera denna till eran main 

public class Runner {

    public static void main(String[] args) {
        
       // EventQueue.invokeLater(() -> {
        //    DGsprintTwo ex = new DGsprintTwo();     // shows image, can be put first in menu
       //     ex.setVisible(true);
       // });

        Maps.runMap(); //runs all map methods, all needed to be done is putting this method in menu choice
        //System.exit(0);
    }
}
