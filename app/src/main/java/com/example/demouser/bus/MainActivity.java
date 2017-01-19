package com.example.demouser.bus;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

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
    ImageButton[] viewArray;
    Button resetButton;

    Card[] fullDeck;
    ArrayList<Card> drawDeck;
    ArrayList<Card> shownCards;
    int[] shownCardValues;

    private int player1Score;
    private int player2Score;

    Players whosTurn;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private String mUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mFirebaseAuth = FirebaseAuth.getInstance();
//        mFirebaseUser = mFirebaseAuth.getCurrentUser();
//        if(mFirebaseUser == null){
//            startActivity(new Intent(this, SignInActivity.class));
//            finish();
//            return;
//        } else{
//            mUserEmail = mFirebaseUser.getEmail();
//        }

        setContentView(R.layout.activity_main);

        shownCardValues = new int[16];
        viewArray = new ImageButton[16];
        shownCards = new ArrayList<Card>();
        drawDeck = new ArrayList<Card>();

        viewArray[0] = card1View = (ImageButton)findViewById(R.id.space1);
        viewArray[1] = card2View = (ImageButton)findViewById(R.id.space2);
        viewArray[2] = card3View = (ImageButton)findViewById(R.id.space3);
        viewArray[3] = card4View = (ImageButton)findViewById(R.id.space4);
        viewArray[4] = card5View = (ImageButton)findViewById(R.id.space5);
        viewArray[5] = card6View = (ImageButton)findViewById(R.id.space6);
        viewArray[6] = card7View = (ImageButton)findViewById(R.id.space7);
        viewArray[7] = card8View = (ImageButton)findViewById(R.id.space8);
        viewArray[8] = card9View = (ImageButton)findViewById(R.id.space9);
        viewArray[9] = card10View = (ImageButton)findViewById(R.id.space10);
        viewArray[10] = card11View = (ImageButton)findViewById(R.id.space11);
        viewArray[11] = card12View = (ImageButton)findViewById(R.id.space12);
        viewArray[12] = card13View = (ImageButton)findViewById(R.id.space13);
        viewArray[13] = card14View = (ImageButton)findViewById(R.id.space14);
        viewArray[14] = card15View = (ImageButton)findViewById(R.id.space15);
        viewArray[15] = card16View = (ImageButton)findViewById(R.id.space16);

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
                viewCard(0);
            }
        });
        card2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(1);
            }
        });
        card3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(2);
            }
        });
        card4View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(3);
            }
        });
        card5View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(4);
            }
        });
        card6View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(5);
            }
        });
        card7View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(6);
            }
        });
        card8View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(7);
            }
        });
        card9View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(8);
            }
        });
        card10View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(9);
            }
        });
        card11View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(10);
            }
        });
        card12View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(11);
            }
        });
        card13View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(12);
            }
        });
        card14View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(13);
            }
        });
        card15View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(14);
            }
        });
        card16View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard(15);
            }
        });

        initDeck();
        shuffle();
    }

    public void reset(){
        shownCards.clear();
        drawDeck.clear();
        shuffle();
        player1Score = 0;
        player2Score = 0;
    }

    /**
     *
     * @param x
     */
    public void viewCard(int x)
    {
        int id = 0;
        int value = 0;

        id = shownCards.get(x).getLargeId();
        value = shownCards.get(x).getNumber();

        //show the selected card in the CardActivity
        Intent intent = new Intent(this, CardActivity.class);
        intent.putExtra("card", id);
        intent.putExtra("value", value);
        //draw a new card and put it on top of the one selected
        int nextValue = drawCard(x);
        intent.putExtra("next", nextValue);
        if(whosTurn == Players.PLAYER2){
            boolean player2 = true;
            intent.putExtra("player2", player2);
            boolean player2Move = higher();
            intent.putExtra("player2Move", player2Move);
        }
        startActivityForResult(intent, 9001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 9001) {
            // CardActivity has finished, show the next card
            updateView();
        }
    }

    /**
     *
     */
    private void shuffle()
    {
        ImageView cardView = null;
        int count = 0;
        //for all 52 cards in the deck
        while (count<52) {
            //get a random card
            Card card = fullDeck[(int) Math.floor(Math.random() * 52)];
            if (shownCards.contains(card) || drawDeck.contains(card)) {
                count--;
            }
            else {
                shownCards.add(card);

                //for the first 16 cards drawn
                if (count < 16) {
                    //add to the screen
                    switch (count) {
                        case 0:
                            cardView = card1View;
                            break;
                        case 1:
                            cardView = card2View;
                            break;
                        case 2:
                            cardView = card3View;
                            break;
                        case 3:
                            cardView = card4View;
                            break;
                        case 4:
                            cardView = card5View;
                            break;
                        case 5:
                            cardView = card6View;
                            break;
                        case 6:
                            cardView = card7View;
                            break;
                        case 7:
                            cardView = card8View;
                            break;
                        case 8:
                            cardView = card9View;
                            break;
                        case 9:
                            cardView = card10View;
                            break;
                        case 10:
                            cardView = card11View;
                            break;
                        case 11:
                            cardView = card12View;
                            break;
                        case 12:
                            cardView = card13View;
                            break;
                        case 13:
                            cardView = card14View;
                            break;
                        case 14:
                            cardView = card15View;
                            break;
                        case 15:
                            cardView = card16View;
                            break;
                    }
                    setCard(count, card, cardView);

                }
                //for the rest of the cards
                else {
                    //add to the deck
                    drawDeck.add(card);
                }
            }
            count++;
        }
    }

    /**
     *
     * @param n
     * @param card
     * @param view
     */
    private void setCard(int n, Card card, ImageView view){
        shownCardValues[n] = card.getNumber();
        view.setImageResource(card.getId());
    }

    /**
     *
     */
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

    /**
     *
     * @param location
     * @return
     */
    private int drawCard(int location){
        //pop the first card off the draw deck
        Card newCard = drawDeck.remove(0);
        //get the value of the new card
        int nextValue = newCard.getNumber();
        //put the new card on top of the previous one
        shownCardValues[location] = newCard.getNumber();
        shownCards.add(location, newCard);
        //return the value of the card
        return nextValue;
    }

    /**
     *
     */
    private void updateView(){
        for(int i = 0; i < 16; i++){
            setCard(i, shownCards.get(i), viewArray[i]);
        }
    }

    /**
     *
     * @return
     */
    private boolean gameOver()
    {
        return drawDeck.isEmpty();
    }

    private boolean higher(){
        //logic for deciding to choose based on other shown cards
        return true;
    }

    final Handler timerHandler = new Handler();
    private void computerTurnIn500(){
        timerHandler.postDelayed(new Runnable(){
            @Override
            public void run(){
                computerTurn();
                if(whosTurn == Players.PLAYER2){
                    computerTurnIn500();
                }
            }
        }, 1000);
    }

    private void computerTurn(){
        int temp = (int) Math.floor(Math.random() * 16);
        viewCard(temp);
    }
}

enum Players{
    PLAYER1,
    PLAYER2
}



