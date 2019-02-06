/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class TopScores {
    private String name;
    private int score;

    public TopScores(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public class Sortbyscore implements Comparator<TopScores> 
    { 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(TopScores a, TopScores b) 
    { 
        return a.getScore() - b.getScore(); 
    } 
    }
    
    @Override
    public String toString(){
        return this.name + " " + this.score;
    }

    
    
}
