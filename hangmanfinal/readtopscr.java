/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class readtopscr {
    
    ArrayList<TopScores> topscores = new ArrayList<>();
    

    public readtopscr() {
        readfile();
    }
    
    public String printtopscores(){
        String topscore = "<html><h3 align=\"center\"><span style=\"color: red;\"><u>Top Scores:</u></span>";  //Second line</html>
        readfile();
        for (int i = 0; i < topscores.size(); i++){
            topscore += "<br>";
            topscore += topscores.get(i).getName() + " : " + topscores.get(i).getScore();
        }
        
        topscore += "</h3></html>";
        
        return topscore;
    }
    private void readfile(){
        topscores.clear();
                try{
        Scanner scn = new Scanner(new File("src/res/TopScore.txt"));
        while (scn.hasNext()){
            String name = scn.next();
            int score = scn.nextInt();
            topscores.add(new TopScores(name , score));
        }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
}
