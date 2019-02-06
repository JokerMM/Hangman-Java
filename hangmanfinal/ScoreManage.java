/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author 650-079497
 */


public class ScoreManage {
    private int score;

    public ScoreManage() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void addpoint(){
        score++;
    }
    
    public void resetscore(){
        score = 0;
    }
    
    public class Sortbyscore implements Comparator<TopScores> 
    { 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(TopScores a, TopScores b) 
    { 
        return a.getScore() - b.getScore(); 
    } }
    
    @Override
    public String toString(){
        return this.score + "";
    }
    
    private ArrayList<TopScores> readtopscore(){
        File file = new File("src/res/TopScore.txt");
        ArrayList<TopScores> topscores = new ArrayList<>();
         try{
            Scanner scn = new Scanner(file);
            while (scn.hasNext()){
                String name = scn.next();
                int score = scn.nextInt();
                topscores.add(new TopScores(name , score));
                //scn.close();
        }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
         return topscores;
    }
    
    private void writetopscores(ArrayList<TopScores> topscores)
    {
        File file = new File("src/res/TopScore.txt");
        try
        {
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            for(int a = 3 ; a > 0 ; a--)
            {
                pw.println(topscores.get(a).toString());
            }
            pw.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void checktopscore(String pname , int pscore) {
        ArrayList<TopScores> topscores = new ArrayList<>();
        topscores = readtopscore();
        topscores.add(new TopScores(pname , pscore));
        Collections.sort(topscores, new Sortbyscore()); 
        for (TopScores t : topscores){
            System.out.println(t.toString());
        }
        writetopscores(topscores);
}
        
        
}
