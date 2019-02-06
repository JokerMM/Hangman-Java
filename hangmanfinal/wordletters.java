/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanfinal;

/**
 *
 * @author User
 */
public class wordletters {
    
    private char CHAR;
    private boolean guessed;

    public wordletters(char CHAR, boolean guessed) {
        this.CHAR = CHAR;
        this.guessed = guessed;
    }

    public char getCHAR() {
        return CHAR;
    }

    public void setCHAR(char CHAR) {
        this.CHAR = CHAR;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

}
