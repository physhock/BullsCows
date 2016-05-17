package com.example.bullscows;


import java.util.ArrayList;

/**
 * Created by Фёдор on 17.05.2016.
 */
public class GameRiddle {


    private static final int maxSizeActive = 4;

    private ArrayList<Integer> user = new ArrayList<> (maxSizeActive);



    public void getUserNum(Integer[] num){

        user.add(0,num[0]);
        user.add(1,num[1]);
        user.add(2,num[2]);
        user.add(3,num[3]);

    }

    public Integer[] sendAnswer(Integer[] num){

        Integer bulls = 0;
        Integer cows = 0;
        Integer[] BAC = new Integer[2];

        for (int i = 0; i < maxSizeActive; i++) {
            for (int j = 0; j < maxSizeActive; j++) {

                if (user.get(i).equals(num[j]))
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

