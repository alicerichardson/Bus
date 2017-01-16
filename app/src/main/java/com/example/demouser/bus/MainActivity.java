package com.example.demouser.bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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

    private int player1Score;
    private int player2Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        int count = 0;
        //for all 52 cards in the deck
        while (count<52) {
            //get a random card
            Card card = fullDeck[(int)Math.floor(Math.random()*52)];
            //for the first 16 cards drawn
            if (count < 16) {
                //add to the screen
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

}
