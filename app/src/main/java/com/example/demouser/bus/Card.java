package com.example.demouser.bus;

/**
 * Created by demouser on 1/16/17.
 */

public class Card implements Comparable<Card>{

    public int number;
    public int suit;
    public int id;

    public Card(int number, int suit){
        this.number = number;
        this.suit = suit;
        setId();
    }

    public void setId(){
        if (suit == 1){
            switch (number){
                case 1: id = R.drawable.ace_of_spades; break;
                case 2: id = R.drawable.two_of_spades; break;
                case 3: id = R.drawable.three_of_spades; break;
                case 4: id = R.drawable.four_of_spades; break;
                case 5: id = R.drawable.five_of_spades; break;
                case 6: id = R.drawable.six_of_spades; break;
                case 7: id = R.drawable.seven_of_spades; break;
                case 8: id = R.drawable.eight_of_spades; break;
                case 9: id = R.drawable.nine_of_spades; break;
                case 10: id = R.drawable.ten_of_spades; break;
                case 11: id  = R.drawable.jack_of_spades2; break;
                case 12: id = R.drawable.queen_of_spades2; break;
                case 13: id = R.drawable.king_of_spades2; break;
            }
        }else if (suit == 2){
            switch (number){
                case 1: id = R.drawable.ace_of_hearts; break;
                case 2: id = R.drawable.two_of_hearts; break;
                case 3: id = R.drawable.three_of_hearts; break;
                case 4: id = R.drawable.four_of_hearts; break;
                case 5: id = R.drawable.five_of_hearts; break;
                case 6: id = R.drawable.six_of_hearts; break;
                case 7: id = R.drawable.seven_of_hearts; break;
                case 8: id = R.drawable.eight_of_hearts; break;
                case 9: id  = R.drawable.nine_of_hearts; break;
                case 10: id = R.drawable.ten_of_hearts; break;
                case 11: id = R.drawable.jack_of_hearts2; break;
                case 12: id = R.drawable.queen_of_hearts2; break;
                case 13: id = R.drawable.king_of_hearts2; break;
            }
        }else if (suit == 3){
            switch ( number ){
                case 1: id = R.drawable.ace_of_clubs; break;
                case 2: id = R.drawable.two_of_clubs; break;
                case 3: id = R.drawable.three_of_clubs; break;
                case 4: id = R.drawable.four_of_clubs; break;
                case 5: id = R.drawable.five_of_clubs; break;
                case 6: id = R.drawable.six_of_clubs; break;
                case 7: id = R.drawable.seven_of_clubs; break;
                case 8: id = R.drawable.eight_of_clubs; break;
                case 9: id = R.drawable.nine_of_clubs; break;
                case 10: id = R.drawable.ten_of_clubs; break;
                case 11: id = R.drawable.jack_of_clubs2; break;
                case 12: id = R.drawable.queen_of_clubs2; break;
                case 13: id = R.drawable.king_of_clubs2; break;
            }
        } else if (suit == 4){
            switch (number){
                case 1: id = R.drawable.ace_of_diamonds; break;
                case 2: id = R.drawable.two_of_diamonds; break;
                case 3: id = R.drawable.three_of_diamonds; break;
                case 4: id = R.drawable.four_of_diamonds; break;
                case 5: id = R.drawable.five_of_diamonds; break;
                case 6: id = R.drawable.six_of_diamonds; break;
                case 7: id = R.drawable.seven_of_diamonds; break;
                case 8: id = R.drawable.eight_of_diamonds; break;
                case 9: id = R.drawable.nine_of_diamonds; break;
                case 10: id = R.drawable.ten_of_diamonds; break;
                case 11: id = R.drawable.jack_of_diamonds2; break;
                case 12: id = R.drawable.queen_of_diamonds2; break;
                case 13: id = R.drawable.king_of_diamonds2; break;
            }
        }
    }

    public int getId() {
        return id;
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
