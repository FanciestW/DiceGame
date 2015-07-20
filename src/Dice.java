/**
 * Dice.java
 * Created By: William Lin
 * This program is an object class and used to represent a Dice. Contains the main
 * function of a dice object, roll()
 */

import java.util.Random; //Imports the Random java library to help with the dice roll().

public class Dice{

    int sides; //Local variable that will determine how many sides the dice object has.

    /**
     * This is a object constructor and it constructs a dice object.
     * @param sides tells the program how many sides are on this dice object.
     */
    public Dice(int sides){
        this.sides = sides;
    }

    /**
     * Rolls the dice object using how many sides it has.
     * @return The randomly generated number roll based on how many sides are on the dice.
     */
    public int roll(){
        Random number = new Random(); //Random object is created to help generate the random number.
        int result = number.nextInt(sides); //Set to produce a number based on how many sides are on the dice.
        return result + 1; //returns the result + 1 because you get a number from 0 - (sides -1).
    }

}