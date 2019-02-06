/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanfinal;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class manageword {
    
    WordReader wordreader = new WordReader();
    private ArrayList<wordletters> letterlist = new ArrayList<>();
    private String newword;
    public int GuessNumber;
        
    public manageword() {

           newgame();
    }
    public String getWord(){
        return this.newword;
    }
    @Override
    public String toString()
    {
        String word = "";
        for (wordletters d : letterlist )
        {
            if (d.isGuessed())
            {
                word += d.getCHAR() +" ";
            }else{
                word += "_ ";
            }
        }
        return word;
    }
    
    public void resetword(){
        this.newword = "";
    }
    
    public boolean checkletter(char c){
        boolean good = false;
        for (wordletters d : letterlist )
        {
            if (d.getCHAR() == c)
            {
                d.setGuessed(true);
                good = true;
            }
        }
        if(!good)GuessNumber--;
        return good;
    }
    
    public void newgame(){
        letterlist.clear();
        newword =  wordreader.getRandomWord();
        for (int i = 0 ; i < newword.length() ; i++){
            letterlist.add(new wordletters(newword.charAt(i) , false));}
        
        this.GuessNumber = 6;
    }
    
    public boolean checkwordfinish(){
        boolean finished = true;
        for (wordletters word : letterlist)
        {
            if(!word.isGuessed())finished = false;
        }
        return finished;
    }
    
}
