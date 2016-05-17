package com.example.bullscows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void startFriend(View v)
    {
        startActivity(new Intent(getApplicationContext(), GameActivity.class));
    }

    public void startAI(View v)
    {
        startActivity(new Intent(getApplicationContext(), GameWithComputerActivity.class));
    }

}
