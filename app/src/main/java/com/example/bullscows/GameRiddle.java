package com.example.bullscows;


import java.util.ArrayList;

/**
 * Created by Фёдор on 17.05.2016.
 */
public class GameRiddle {


    private static final int maxSizeActive = 4;
    private static int[] user = new int[maxSizeActive];



    public void getUserNum(int[] num){

        user = num;

    }

    public int[] sendAnswer(int[] num){

        int bulls = 0;
        int cows = 0;
        int[] bac = new int[2];

        for (int i = 0; i < maxSizeActive; i++) {
            for (int j = 0; j < maxSizeActive; j++) {

                if (user[i] == num[j])
                {
                    if (i==j)
                        bulls++;
                    else
                        cows++;
                }

            }
        }

        bac[0] = bulls;
        bac[1] = cows;

        return bac;
    }



}

