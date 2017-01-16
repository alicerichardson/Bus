package com.example.demouser.bus;

/**
 * Created by demouser on 1/16/17.
 */

public class Card implements Comparable<Card>{

    public int number;
    public int suit;

    public Card(int number, int suit){
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public int getSuit() {
        return suit;
    }

    public int compareTo(Card card){
        if(number > card.number){
            return 1;
        }
        else if(number < card.number){
            return -1;
        }
        else{
            return 0;
        }
    }
}
