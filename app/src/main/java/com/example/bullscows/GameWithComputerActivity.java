package com.example.bullscows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameWithComputerActivity extends AppCompatActivity {


    private ListView results;
    private List<String> resultsData = new ArrayList<>();
    private EditText first;
    private EditText second;
    private EditText third;
    private EditText fourth;
    private RiddleSolver solver;
    private GameRiddle riddle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_ai);
        riddle = new GameRiddle();
        solver = new RiddleSolver();

        first = (EditText) findViewById(R.id.num1);
        second = (EditText) findViewById(R.id.num2);
        third = (EditText) findViewById(R.id.num3);
        fourth = (EditText) findViewById(R.id.num4);

        results = (ListView) findViewById(R.id.resWin);


        first.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        second.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        third.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        fourth.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        second.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (second.getText().toString().equals(first.getText().toString()) && !second.getText().toString().equals(""))
                {
                    second.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        third.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ((third.getText().toString().equals(first.getText().toString()) || third.getText().toString().equals(second.getText().toString())) &&  !third.getText().toString().equals(""))
                {
                    third.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        fourth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ((fourth.getText().toString().equals(first.getText().toString())|| fourth.getText().toString().equals(second.getText().toString()) || fourth.getText().toString().equals(third.getText().toString())) && !fourth.getText().toString().equals(""))
                {
                    fourth.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


        solver.makeNumbers();



    }


    public boolean checkEmpty() {
        boolean empty = false;

        if (fourth.getText().toString().isEmpty() || third.getText().toString().isEmpty() || second.getText().toString().isEmpty() || first.getText().toString().isEmpty())
        {
            empty=true;
        }
        return empty;
    }

    public void startGameAI(View v) {
        if (checkEmpty()) {return;}

        Integer[] num = new Integer[4];

        num[0] = Integer.parseInt(first.getText().toString());
        num[1] = Integer.parseInt(second.getText().toString());
        num[2] = Integer.parseInt(third.getText().toString());
        num[3] = Integer.parseInt(fourth.getText().toString());


        first.setText("");
        second.setText("");
        third.setText("");
        fourth.setText("");

        riddle.getUserNum(num);

    }




    public void step(View v){

        resultsData.add(solver.makeDecision());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,resultsData);
        results.setAdapter(arrayAdapter);



    }


}
