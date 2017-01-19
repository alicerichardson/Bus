package com.example.demouser.bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class CardActivity extends AppCompatActivity {

    ImageView cardView;
    Button backButton;
    Button lowerButton;
    Button higherButton;
    Toast highToast;
    Toast lowToast;
    Toast resultToast;
    int value;
    int nextValue;
    int player1Score;
    int player2Score;
    boolean guessedHigh;

    LayoutInflater inflater;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        cardView = ((ImageView)findViewById(R.id.cardView));

        //
        inflater= getLayoutInflater();
        View view = inflater.inflate(R.layout.image_toast_layout,
                (ViewGroup) findViewById(R.id.relativeLayout1));
        toast = new Toast(this);
        toast.setView(view);

        //
        Intent intent = getIntent();
        int id = intent.getIntExtra("card", 0);
        value = intent.getIntExtra("value", 0);
        nextValue = intent.getIntExtra("next",0);

        viewCard(id);

        backButton=(Button)findViewById(R.id.backButton);
        higherButton=(Button)findViewById(R.id.higherButton);
        lowerButton = (Button)findViewById(R.id.lowerButton);
        highToast = Toast.makeText(getApplicationContext(), "You guessed higher!\nThe card was:\nYou lose 0 points", Toast.LENGTH_LONG);
        lowToast = Toast.makeText(getApplicationContext(), "You guessed lower!\nThe card was: \nYou lose 0 points", Toast.LENGTH_LONG);
        resultToast = Toast.makeText(getApplicationContext(), "You guessed %s!\nThe card was: %d\nYou %s points", Toast.LENGTH_LONG);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        higherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessedHigh = true;
                checkCard();
                //highToast.show();
                resultToast.show();
                //toast.show();
                finish();
            }
        });

        lowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessedHigh = false;
                checkCard();
                resultToast.show();
                //lowToast.show();
                //toast.show();
                finish();
            }
        });
    }

    private void viewCard(int x){
        //int pic = card.getId();
        cardView.setImageResource(x);
    }

    public void checkCard()
    {
        int result=0;
        //compare the selected card value with the drawn card value
        //if it was the same
        if (value == nextValue)
        {
            //gain no points

            result = 0;
        }

        //if the user selected higher and it was higher
        else if(value<nextValue && guessedHigh)
        {
            //gain a point

            result = 1;
        }

        //if the user selected lower and it was lower
        else if (value>nextValue && !guessedHigh)
        {
            //gain a point

            result = 1;
        }
        //if the user selected lower and it was higher
        else if(value<nextValue && !guessedHigh)
        {
            //lose a point

            result = -1;
        }
        //if the user selected higher and it was higher
        else if (value>nextValue && guessedHigh)
        {
            //lose a point

            result = -1;
        }

        setResultToast(result);

        //check if game is over

    }

    private void setResultToast(int result)
    {
        String guess;
        String results;

        if (guessedHigh)
            guess = "higher";
        else
            guess = "lower";

        if (result==-1)
            results = "lose 1 point";
        else if(result==1)
            results = "gain 1 point";
        else
            results = "gain no points";


        resultToast.setText(String.format("You guessed %s!\nThe card was: %d\nYou %s!", guess,nextValue,results ));
    }

}
