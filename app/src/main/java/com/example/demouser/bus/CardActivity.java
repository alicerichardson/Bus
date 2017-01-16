package com.example.demouser.bus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class CardActivity extends AppCompatActivity {

    ImageButton card;
    Button backButton;
    Button lowerButton;
    Button higherButton;
    Toast highToast;
    Toast lowToast;

//    public CardActivity(ImageButton selectedCard){
//        card = selectedCard;
//    }

    //

    LayoutInflater inflater;
    Toast toast;


//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        //
        inflater= getLayoutInflater();
        View view = inflater.inflate(R.layout.image_toast_layout,
                (ViewGroup) findViewById(R.id.relativeLayout1));
        toast = new Toast(this);
        toast.setView(view);

        //


        backButton=(Button)findViewById(R.id.backButton);
        higherButton=(Button)findViewById(R.id.higherButton);
        lowerButton = (Button)findViewById(R.id.lowerButton);
        highToast = Toast.makeText(getApplicationContext(), "You guessed higher!\nThe card was:\nYou lose 0 points", Toast.LENGTH_SHORT);
        lowToast = Toast.makeText(getApplicationContext(), "You guessed lower!\nThe card was: \nYou lose 0 points", Toast.LENGTH_SHORT);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        higherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //compareCards
                //highToast.show();
                toast.show();
                finish();
            }
        });

        lowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //compareCards()
                //lowToast.show();
                toast.show();
                finish();
            }
        });




    }



}
