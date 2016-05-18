package com.example.bullscows;


import java.util.ArrayList;

/**
 * Created by Фёдор on 17.05.2016.
 */
public class GameRiddle {


    private static final int maxSizeActive = 4;
    private static Integer[] user = new Integer[maxSizeActive];



    public void getUserNum(Integer[] num){

        user = num;

    }

    public Integer[] sendAnswer(Integer[] num){

        Integer bulls = 0;
        Integer cows = 0;
        Integer[] BAC = new Integer[2];

        for (int i = 0; i < maxSizeActive; i++) {
            for (int j = 0; j < maxSizeActive; j++) {

                if (user[i].equals(num[j]))
                {
                    if (i==j)
                        bulls++;
                    else
                        cows++;
                }

            }
        }

        BAC[0] = bulls;
        BAC[1] = cows;

        return BAC;
    }



}

