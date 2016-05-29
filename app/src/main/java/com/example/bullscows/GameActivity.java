package com.example.bullscows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity{


    private ListView results;
    private List<String> resultsData = new ArrayList<String>();
    private EditText first;
    private EditText second;
    private EditText third;
    private EditText fourth;
    private Button check;
    private GameRiddle riddle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        riddle = new GameRiddle();
        first = (EditText) findViewById(R.id.num1);
        second = (EditText) findViewById(R.id.num2);
        third = (EditText) findViewById(R.id.num3);
        fourth = (EditText) findViewById(R.id.num4);
        check = (Button) findViewById(R.id.button2);

        results = (ListView) findViewById(R.id.logWindow);

        first.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        second.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        third.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        fourth.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        check.setEnabled(false);
        first.requestFocus();

        first.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {second.requestFocus();}
        });

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
                                          public void afterTextChanged(Editable s) {third.requestFocus();}
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
                                          public void afterTextChanged(Editable s) {fourth.requestFocus();}
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

    }

    public boolean checkEmpty() {
        boolean empty = false;

        if (fourth.getText().toString().isEmpty() || third.getText().toString().isEmpty() || second.getText().toString().isEmpty() || first.getText().toString().isEmpty())
        {
            empty=true;
        }
        return empty;
    }

    public void startGame(View v) {
        if (checkEmpty()) {return;}

        int[] num = new int[4];

        num[0] = Integer.parseInt(first.getText().toString());
        num[1] = Integer.parseInt(second.getText().toString());
        num[2] = Integer.parseInt(third.getText().toString());
        num[3] = Integer.parseInt(fourth.getText().toString());

        v.setEnabled(false);

        first.setText("");
        second.setText("");
        third.setText("");
        fourth.setText("");
        check.setEnabled(true);
        riddle.getUserNum(num);
        first.requestFocus();

    }

    public void check(View v) {

        if (checkEmpty()) {return;}

        int[] num = new int[4];
        int[] bac;
        int cow;
        int bull;

        num[0] = Integer.parseInt(first.getText().toString());
        num[1] = Integer.parseInt(second.getText().toString());
        num[2] = Integer.parseInt(third.getText().toString());
        num[3] = Integer.parseInt(fourth.getText().toString());

        bac = riddle.sendAnswer(num);

        bull = bac[0];
        cow = bac[1];



        if (bull == 4) {
            resultsData.add("YOU WIN");
        }
        else {
            resultsData.add(Integer.toString(num[0]) + Integer.toString(num[1]) + Integer.toString(num[2])+ Integer.toString(num[3]) + " bulls: " + bull + " cows: " + cow);
        }

        first.setText("");
        second.setText("");
        third.setText("");
        fourth.setText("");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,resultsData);

        results.setAdapter(arrayAdapter);
        first.requestFocus();

    }


}
