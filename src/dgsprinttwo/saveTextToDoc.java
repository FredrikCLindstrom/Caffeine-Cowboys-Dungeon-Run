/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgsprinttwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class saveTextToDoc {
        public static void highScoresTable() {

        
        ArrayList<Heroes> HighScores = new ArrayList<>();

        HighScores.add(DungeonRun.players.get(0));

        //DungeonRun.players.sort(Comparator.comparing(Heroes::getSkatter).reversed());
        int counter = 1;
        
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(DungeonRun.players.get(0).getName()+" "+DungeonRun.players.get(0).getSkatter());
            

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
