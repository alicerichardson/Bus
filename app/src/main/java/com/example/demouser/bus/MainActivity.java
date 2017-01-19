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

        shownCardValues = new int[16];


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
                viewCard(1);
            }
        });
        card2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(2);
            }
        });
        card3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(3);
            }
        });
        card4View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(4);
            }
        });
        card5View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(5);
            }
        });
        card6View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(6);
            }
        });
        card7View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(7);
            }
        });
        card8View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(8);
            }
        });
        card9View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(9);
            }
        });
        card10View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(10);
            }
        });
        card11View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(11);
            }
        });
        card12View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(12);
            }
        });
        card13View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(13);
            }
        });
        card14View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(14);
            }
        });
        card15View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(15);
            }
        });
        card16View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(16);
            }
        });

        initDeck();
        shuffle();

<<<<<<< Updated upstream
=======

<<<<<<< Updated upstream
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
=======
        //remove this from this method
        card1View.setImageResource(R.drawable.ace_of_clubs);
        card2View.setImageResource(R.drawable.four_of_clubs);
        card3View.setImageResource(R.drawable.ten_of_clubs);
        card4View.setImageResource(R.drawable.jack_of_diamonds2);
        card5View.setImageResource(R.drawable.ten_of_hearts);
        card6View.setImageResource(R.drawable.five_of_spades);
        card7View.setImageResource(R.drawable.four_of_spades);
        card8View.setImageResource(R.drawable.queen_of_hearts2);
        card9View.setImageResource(R.drawable.ace_of_diamonds);
        card10View.setImageResource(R.drawable.queen_of_spades2);
        card11View.setImageResource(R.drawable.eight_of_hearts);
        card12View.setImageResource(R.drawable.nine_of_spades);
        card13View.setImageResource(R.drawable.two_of_hearts);
        card14View.setImageResource(R.drawable.seven_of_diamonds);
        card15View.setImageResource(R.drawable.six_of_clubs);
        card16View.setImageResource(R.drawable.four_of_diamonds);
>>>>>>> Stashed changes


>>>>>>> Stashed changes
    }

    public void reset(){

        shuffle();
        player1Score = 0;
        player2Score = 0;
    }


    public void viewCard(int x)
    {
        int temp = 0;
        int id = 0;
        int value = 0;

        id = shownCards.get(x-1).getId();
        value = shownCards.get(x-1).getNumber();

        //draw a new card and put it on top of the one selected
        int nextValue = drawCard(x);
        //show the selected card in the CardActivity
        Intent intent = new Intent(this, CardActivity.class);
        intent.putExtra("card", id);
        intent.putExtra("value", value);
        intent.putExtra("next", nextValue);
        startActivity(intent);


    }
    private void shuffle()
    {
        shownCards = new ArrayList<Card>();
        drawDeck = new ArrayList<Card>();
        ImageView cardView = null;
        int count = 1;
        //for all 52 cards in the deck
        while (count<53) {
            //get a random card
            Card card = fullDeck[(int)Math.floor(Math.random()*52)];
            //for the first 16 cards drawn
            if (count < 17) {
                //add to the screen
                switch (count) {
                    case 1: cardView = card1View; break;
                    case 2: cardView = card2View; break;
                    case 3: cardView = card3View; break;
                    case 4: cardView = card4View; break;
                    case 5: cardView = card5View; break;
                    case 6: cardView = card6View; break;
                    case 7: cardView = card7View; break;
                    case 8: cardView = card8View; break;
                    case 9: cardView = card9View; break;
                    case 10: cardView = card10View; break;
                    case 11: cardView = card11View; break;
                    case 12: cardView = card12View; break;
                    case 13: cardView = card13View; break;
                    case 14: cardView = card14View; break;
                    case 15: cardView = card15View; break;
                    case 16: cardView = card16View; break;
                }
                setCard(count-1, card, cardView);
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
        shownCardValues[n] = card.getNumber();
        view.setImageResource(card.getId());
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

    private int drawCard(int location){
        ImageView spot = null;
        //pop the first card off the draw deck
        Card newCard = drawDeck.remove(0);
        //get the value of the new card
        int value = newCard.getNumber();
        //put the new card on top of the previous one
        switch(location) {
            case 1:
                spot = card1View;
                break;
            case 2:
                spot = card2View;
                break;
            case 3:
                spot = card3View;
                break;
            case 4:
                spot = card4View;
                break;
            case 5:
                spot = card5View;
                break;
            case 6:
                spot = card6View;
                break;
            case 7:
                spot = card7View;
                break;
            case 8:
                spot = card8View;
                break;
            case 9:
                spot = card9View;
                break;
            case 10:
                spot = card10View;
                break;
            case 11:
                spot = card11View;
                break;
            case 12:
                spot = card12View;
                break;
            case 13:
                spot = card13View;
                break;
            case 14:
                spot = card14View;
                break;
            case 15:
                spot = card15View;
                break;
            case 16:
                spot = card16View;
                break;
        }

        setCard(location, newCard, spot);

        //return the value
        return value;
    }

    private boolean gameOver()
    {
        return drawDeck.isEmpty();
    }

}
