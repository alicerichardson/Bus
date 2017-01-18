package com.example.demouser.bus;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ImageButton card1View;
    ImageButton card2View;
    ImageButton card3View;
    ImageButton card4View;
    ImageButton card5View;
    ImageButton card6View;
    ImageButton card7View;
    ImageButton card8View;
    ImageButton card9View;
    ImageButton card10View;
    ImageButton card11View;
    ImageButton card12View;
    ImageButton card13View;
    ImageButton card14View;
    ImageButton card15View;
    ImageButton card16View;
    Button resetButton;
    Card[] fullDeck;
    ArrayList<Card> drawDeck;
    ArrayList<Card> shownCards;
    int[] shownCardValues;
    int pic;
    private int player1Score;
    private int player2Score;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private String mUserEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if(mFirebaseUser == null){
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else{
            mUserEmail = mFirebaseUser.getEmail();
        }

        setContentView(R.layout.activity_main);

        card1View = (ImageButton)findViewById(R.id.space1);
        card2View = (ImageButton)findViewById(R.id.space2);
        card3View = (ImageButton)findViewById(R.id.space3);
        card4View = (ImageButton)findViewById(R.id.space4);
        card5View = (ImageButton)findViewById(R.id.space5);
        card6View = (ImageButton)findViewById(R.id.space6);
        card7View = (ImageButton)findViewById(R.id.space7);
        card8View = (ImageButton)findViewById(R.id.space8);
        card9View = (ImageButton)findViewById(R.id.space9);
        card10View = (ImageButton)findViewById(R.id.space10);
        card11View = (ImageButton)findViewById(R.id.space11);
        card12View = (ImageButton)findViewById(R.id.space12);
        card13View = (ImageButton)findViewById(R.id.space13);
        card14View = (ImageButton)findViewById(R.id.space14);
        card15View = (ImageButton)findViewById(R.id.space15);
        card16View = (ImageButton)findViewById(R.id.space16);
        resetButton = (Button)findViewById(R.id.newGameButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        card1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card1View);
                //putExtra
            }
        });
        card2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card2View);
            }
        });
        card3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card3View);
            }
        });
        card4View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card4View);
            }
        });
        card5View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card5View);
            }
        });
        card6View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card6View);
            }
        });
        card7View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card7View);
            }
        });
        card8View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card8View);
            }
        });
        card9View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card9View);
            }
        });
        card10View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card10View);
            }
        });
        card11View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card11View);
            }
        });
        card12View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card12View);
            }
        });
        card13View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card13View);
            }
        });
        card14View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card14View);
            }
        });
        card15View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card15View);
            }
        });
        card16View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(card16View);
            }
        });

        initDeck();
        shuffle();


//        pic = R.drawable.ace_of_clubs;
//
//        //remove this from this method
//        card1View.setImageResource(pic);
//
//        card2View.setImageResource(R.drawable.four_of_clubs);
//        card3View.setImageResource(R.drawable.ten_of_clubs);
//        card4View.setImageResource(R.drawable.jack_of_diamonds2);
//        card5View.setImageResource(R.drawable.ten_of_hearts);
//        card6View.setImageResource(R.drawable.five_of_spades);
//        card7View.setImageResource(R.drawable.four_of_spades);
//        card8View.setImageResource(R.drawable.queen_of_hearts2);
//        card9View.setImageResource(R.drawable.ace_of_diamonds);
//        card10View.setImageResource(R.drawable.queen_of_spades2);
//        card11View.setImageResource(R.drawable.eight_of_hearts);
//        card12View.setImageResource(R.drawable.nine_of_spades);
//        card13View.setImageResource(R.drawable.two_of_hearts);
//        card14View.setImageResource(R.drawable.seven_of_diamonds);
//        card15View.setImageResource(R.drawable.six_of_clubs);
//        card16View.setImageResource(R.drawable.four_of_diamonds);


    }

    public void reset(){

        shuffle();
        player1Score = 0;
        player2Score = 0;
    }


    public void viewCard(ImageButton card)
    {
        //
        startActivity(new Intent(this, CardActivity.class));
    }

    private void shuffle()
    {
        shownCards = new ArrayList<Card>();
        drawDeck = new ArrayList<Card>();
        int count = 0;
        //for all 52 cards in the deck
        while (count<52) {
            //get a random card
            Card card = fullDeck[(int)Math.floor(Math.random()*52)];
            //for the first 16 cards drawn
            if (count < 16) {
                //add to the screen
                switch(count = count){
                    case 1: count = 0;
                        setCard(count, card, card1View);
                        break;
                    case 2: count = 1;
                        setCard(count, card, card2View);
                        break;
                    case 3: count = 2;
                        setCard(count, card, card3View);
                        break;
                    case 4: count = 3;
                        setCard(count, card, card4View);
                        break;
                    case 5: count = 4;
                        setCard(count, card, card5View);
                        break;
                    case 6: count = 5;
                        setCard(count, card, card6View);
                        break;
                    case 7: count = 6;
                        setCard(count, card, card7View);
                        break;
                    case 8: count = 7;
                        setCard(count, card, card8View);
                        break;
                    case 9: count = 8;
                        setCard(count, card, card9View);
                        break;
                    case 10: count = 9;
                        setCard(count, card, card10View);
                        break;
                    case 11: count = 10;
                        setCard(count, card, card11View);
                        break;
                    case 12: count = 11;
                        setCard(count, card, card12View);
                        break;
                    case 13: count = 12;
                        setCard(count, card, card13View);
                        break;
                    case 14: count = 13;
                        setCard(count, card, card4View);
                        break;
                    case 15: count = 14;
                        setCard(count, card, card15View);
                        break;
                    case 16: count = 15;
                        setCard(count, card, card16View);
                        break;


                }
                shownCards.add(card);

            }
            //for the rest of the cards
            else {
                //add to the deck
                drawDeck.add(card);
            }
            count++;
        }
    }

    private void setCard(int n, Card card, ImageView view){
        shownCardValues = new int[16];
        shownCardValues[n] = card.getNumber();

        int a = card.getNumber();
        int y = card.getSuit();
        int x = 0;
        int pic = 0;

        if (y == 1){
            switch (x = a){
                case 1: x = 1;
                    pic = R.drawable.ace_of_spades;
                        break;
                case 2: x = 2;
                    pic = R.drawable.two_of_spades;
                        break;
                case 3: x = 3;
                    pic = R.drawable.three_of_spades;
                        break;
                case 4: x = 4;
                    pic = R.drawable.four_of_spades;
                        break;
                case 5: x = 5;
                    pic = R.drawable.five_of_spades;
                        break;
                case 6: x = 6;
                    pic = R.drawable.six_of_spades;
                        break;
                case 7: x = 7;
                    pic = R.drawable.seven_of_spades;
                        break;
                case 8: x = 8;
                    pic  = R.drawable.eight_of_spades;
                        break;
                case 9: x = 9;
                    pic = R.drawable.nine_of_spades;
                        break;
                case 10: x = 10;
                    pic = R.drawable.ten_of_spades;
                        break;
                case 11: x = 11;
                    pic  = R.drawable.jack_of_spades2;
                        break;
                case 12: x = 12;
                    pic = R.drawable.queen_of_spades2;
                        break;
                case 13: x = 13;
                    pic = R.drawable.king_of_spades2;
                        break;
            }
        }else if (y == 2){
            switch (x = a){
                case 1: x = 1;
                    pic = R.drawable.ace_of_hearts;
                        break;
                case 2: x = 2;
                    pic = R.drawable.two_of_hearts;
                        break;
                case 3: x = 3;
                    pic = R.drawable.three_of_hearts;
                        break;
                case 4: x = 4;
                    pic = R.drawable.four_of_hearts;
                        break;
                case 5: x = 5;
                    pic = R.drawable.five_of_hearts;
                        break;
                case 6: x = 6;
                    pic = R.drawable.six_of_hearts;
                        break;
                case 7: x = 7;
                    pic = R.drawable.seven_of_hearts;
                        break;
                case 8: x = 8;
                    pic = R.drawable.eight_of_hearts;
                        break;
                case 9: x = 9;
                    pic  = R.drawable.nine_of_hearts;
                        break;
                case 10: x = 10;
                    pic = R.drawable.ten_of_hearts;
                        break;
                case 11: x = 11;
                    pic = R.drawable.jack_of_hearts2;
                        break;
                case 12: x = 12;
                    pic = R.drawable.queen_of_hearts2;
                        break;
                case 13: x = 13;
                    pic = R.drawable.king_of_hearts2;
                        break;
            }
        }else if (y == 3){
            switch ( x = a){
                case 1: x = 1;
                    pic = R.drawable.ace_of_clubs;
                        break;
                case 2: x = 2;
                    pic = R.drawable.two_of_clubs;
                        break;
                case 3: x = 3;
                    pic = R.drawable.three_of_clubs;
                        break;
                case 4: x = 4;
                    pic = R.drawable.four_of_clubs;
                        break;
                case 5: x = 5;
                    pic = R.drawable.five_of_clubs;
                        break;
                case 6: x = 6;
                    pic = R.drawable.six_of_clubs;
                        break;
                case 7: x = 7;
                    pic = R.drawable.seven_of_clubs;
                        break;
                case 8: x = 8;
                    pic = R.drawable.eight_of_clubs;
                        break;
                case 9: x = 9;
                    pic = R.drawable.nine_of_clubs;
                        break;
                case 10: x = 10;
                    pic = R.drawable.ten_of_clubs;
                        break;
                case 11: x = 11;
                    pic = R.drawable.jack_of_clubs2;
                        break;
                case 12: x = 12;
                    pic = R.drawable.queen_of_clubs2;
                        break;
                case 13: x = 13;
                    pic = R.drawable.king_of_clubs2;
                        break;
            }
        } else if (y == 4){
            switch (x = a){
                case 1: x = 1;
                    pic = R.drawable.ace_of_diamonds;
                        break;
                case 2: x = 2;
                    pic = R.drawable.two_of_diamonds;
                        break;
                case 3: x = 3;
                    pic = R.drawable.three_of_diamonds;
                        break;
                case 4: x = 4;
                    pic = R.drawable.four_of_diamonds;
                        break;
                case 5: x = 5;
                    pic = R.drawable.five_of_diamonds;
                        break;
                case 6: x = 6;
                    pic = R.drawable.six_of_diamonds;
                        break;
                case 7: x = 7;
                    pic = R.drawable.seven_of_diamonds;
                        break;
                case 8: x = 8;
                    pic = R.drawable.eight_of_diamonds;
                        break;
                case 9: x = 9;
                    pic = R.drawable.nine_of_diamonds;
                        break;
                case 10: x = 10;
                    pic = R.drawable.ten_of_diamonds;
                        break;
                case 11: x = 11;
                    pic = R.drawable.jack_of_diamonds2;
                        break;
                case 12: x = 12;
                    pic = R.drawable.queen_of_diamonds2;
                        break;
                case 13: x = 13;
                    pic = R.drawable.king_of_diamonds2;
                        break;
            }
        }
        view.setImageResource(pic);
    }

    private void initDeck(){
        fullDeck = new Card[52];
        for(int j = 1; j <= 13; j++){
            for (int i = 0; i < 52; i+=4){
                fullDeck[i] = new Card(j, 1);
                fullDeck[i+1] = new Card(j, 2);
                fullDeck[i+2] = new Card(j, 3);
                fullDeck[i+3] = new Card(j, 4);
                j++;
            }
        }
    }

}
