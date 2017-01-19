package com.example.demouser.bus;

/**
 * Created by demouser on 1/16/17.
 */

public class Card implements Comparable<Card>{

    public int number;
    public int suit;
    public int id;
    public int idB;

    public Card(int number, int suit){
        this.number = number;
        this.suit = suit;
        setId();
        setLargeId();
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
                case 11: id  = R.drawable.jack_of_spades; break;
                case 12: id = R.drawable.queen_of_spades; break;
                case 13: id = R.drawable.king_of_spades; break;
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
                case 11: id = R.drawable.jack_of_hearts; break;
                case 12: id = R.drawable.queen_of_hearts; break;
                case 13: id = R.drawable.king_of_hearts; break;
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
                case 11: id = R.drawable.jack_of_clubs; break;
                case 12: id = R.drawable.queen_of_clubs; break;
                case 13: id = R.drawable.king_of_clubs; break;
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
                case 11: id = R.drawable.jack_of_diamonds; break;
                case 12: id = R.drawable.queen_of_diamonds; break;
                case 13: id = R.drawable.king_of_diamonds; break;
            }
        }
    }

    public void setLargeId(){
        if (suit == 1){
            switch (number){
                case 1: idB = R.drawable.ace_of_spades_big; break;
                case 2: idB = R.drawable.two_of_spades_big; break;
                case 3: idB = R.drawable.three_of_spades_big; break;
                case 4: idB = R.drawable.four_of_spades_big; break;
                case 5: idB = R.drawable.five_of_spades_big; break;
                case 6: idB = R.drawable.six_of_spades_big; break;
                case 7: idB = R.drawable.seven_of_spades_big; break;
                case 8: idB = R.drawable.eight_of_spades_big; break;
                case 9: idB = R.drawable.nine_of_spades_big; break;
                case 10: idB = R.drawable.ten_of_spades_big; break;
                case 11: idB  = R.drawable.jack_of_spades_big; break;
                case 12: idB = R.drawable.queen_of_spades_big; break;
                case 13: idB = R.drawable.king_of_spades_big; break;
            }
        }else if (suit == 2){
            switch (number){
                case 1: idB = R.drawable.ace_of_hearts_big; break;
                case 2: idB = R.drawable.two_of_hearts_big; break;
                case 3: idB = R.drawable.three_of_hearts_big; break;
                case 4: idB = R.drawable.four_of_hearts_big; break;
                case 5: idB = R.drawable.five_of_hearts_big; break;
                case 6: idB = R.drawable.six_of_hearts_big; break;
                case 7: idB = R.drawable.seven_of_hearts_big; break;
                case 8: idB = R.drawable.eight_of_hearts_big; break;
                case 9: idB  = R.drawable.nine_of_hearts_big; break;
                case 10: idB = R.drawable.ten_of_hearts_big; break;
                case 11: idB = R.drawable.jack_of_hearts_big; break;
                case 12: idB = R.drawable.queen_of_hearts_big; break;
                case 13: idB = R.drawable.king_of_hearts_big; break;
            }
        }else if (suit == 3){
            switch ( number ){
                case 1: idB = R.drawable.ace_of_clubs_big; break;
                case 2: idB = R.drawable.two_of_clubs_big; break;
                case 3: idB = R.drawable.three_of_clubs_big; break;
                case 4: idB = R.drawable.four_of_clubs_big; break;
                case 5: idB = R.drawable.five_of_clubs_big; break;
                case 6: idB = R.drawable.six_of_clubs_big; break;
                case 7: idB = R.drawable.seven_of_clubs_big; break;
                case 8: idB = R.drawable.eight_of_clubs_big; break;
                case 9: idB = R.drawable.nine_of_clubs_big; break;
                case 10: idB = R.drawable.ten_of_clubs_big; break;
                case 11: idB = R.drawable.jack_of_clubs_big; break;
                case 12: idB = R.drawable.queen_of_clubs_big; break;
                case 13: idB = R.drawable.king_of_clubs_big; break;
            }
        } else if (suit == 4){
            switch (number){
                case 1: idB = R.drawable.ace_of_diamonds_big; break;
                case 2: idB = R.drawable.two_of_diamonds_big; break;
                case 3: idB = R.drawable.three_of_diamonds_big; break;
                case 4: idB = R.drawable.four_of_diamonds_big; break;
                case 5: idB = R.drawable.five_of_diamonds_big; break;
                case 6: idB = R.drawable.six_of_diamonds_big; break;
                case 7: idB = R.drawable.seven_of_diamonds_big; break;
                case 8: idB = R.drawable.eight_of_diamonds_big; break;
                case 9: idB = R.drawable.nine_of_diamonds_big; break;
                case 10: idB = R.drawable.ten_of_diamonds_big; break;
                case 11: idB = R.drawable.jack_of_diamonds_big; break;
                case 12: idB = R.drawable.queen_of_diamonds_big; break;
                case 13: idB = R.drawable.king_of_diamonds_big; break;
            }
        }
    }

    public int getId() {
        return id;
    }

    public int getLargeId() {
        return idB;
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
