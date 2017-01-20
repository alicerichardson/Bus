package com.example.demouser.bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    public boolean playComputer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button computerButton = (Button) findViewById(R.id.computer_button);
        Button twoPlayerButton = (Button) findViewById(R.id.player_button);

        computerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playComputer = true;
                play();
            }
        });
        twoPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playComputer = false;
                play();
            }
        });
    }

    private void play()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("playComputer", playComputer);

        startActivity(intent);
    }
}
