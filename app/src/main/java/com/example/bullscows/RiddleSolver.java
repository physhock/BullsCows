package com.example.bullscows;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Фёдор on 18.05.2016.
 */
public class RiddleSolver {


    private static final int maxSizeAll = 4536;
    private static final int maxSizeActive = 4;

    private ArrayList<int[]> number = new ArrayList<> (maxSizeAll);
    private ArrayList<Boolean> usage  = new ArrayList<>(maxSizeAll);
    private GameRiddle answer = new GameRiddle();
    private int[] prediction = new int[maxSizeActive];
    private int turn = 0;




    //Generate all 4536 numbers
    public void makeNumbers() {
        for (int i = 1; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                for (int k = 0; k < 10; k++)
                {
                    for (int l = 0; l < 10; l++)
                    {
                        if (i != j && i != k && i != l && j != k && j != l && k !=l)
                        {
                            int[] n = new int[maxSizeActive];
                            n[0] = i;
                            n[1] = j;
                            n[2] = k;
                            n[3] = l;
                            number.add(n);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < maxSizeAll; i++)
        {
            usage.add(i,true);
        }
    }


    public String makeDecision(){

        int[] bac = new int[2];
        String res;

        for (int i = 0; i < maxSizeAll; i++ ){

            Random rand = new Random();
            int r = rand.nextInt(4536);

            if (usage.get(r)){

                bac = answer.sendAnswer(number.get(r));
                usage.set(r,false);
               for (int j = 0; j < maxSizeActive; j++)
               {
                   prediction[j] = number.get(r)[j];
               }
                break;

            }


        }

        markNum(bac);

        res = makeRes(bac);

        turn++;
        return res;

    }

    public void markNum(int[] bac)
    {

        int cows;
        int bulls;

        for (int i = 0; i < maxSizeAll; i++)
        {
            bulls = 0;
            cows = 0;

            for (int j = 0; j < maxSizeActive; j++)
            {
                for (int k = 0; k <maxSizeActive; k++)
                {
                    if (number.get(i)[j] == prediction[k] && usage.get(i))
                    {
                        cows++;
                        break;
                    }

                }


            }

            for (int p =0; p < maxSizeActive; p++)
            {
                if (number.get(i)[p] == prediction[p])
                {
                    bulls++;
                }
            }

            if (bulls != bac[0] && cows != bac[1]) usage.set(i,false);
        }
    }

    public String makeRes(int[] bac){
        String res;
        if (bac[0] == 4)
        {
            res = "Number: " + prediction[0] + prediction[1] + prediction[2] + prediction[3] + " WELL DONE COMPUTER ";
        }
        else
        {
            res ="Turn: " + turn + " Number: " + prediction[0] + prediction[1] + prediction[2] + prediction[3] + " Bulls: " + bac[0] + " Cows: " + bac[1];
        }
        return res;
    }






















     /*
     public void checkNum(Integer[] num){

        Integer bulls = 0;
        Integer cows = 0;
        Integer n = num[0]*1000+num[1]*100+num[2]*10+num[3];

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

        if (cows.equals(0) && bulls.equals(0) && !n.equals(0))
        {
            for (int i = 0; i < maxSizeAll; i++)
            {

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(num[k]))
                        {
                            usage.set(i,false);
                            break;
                        }
                    }

                }
            }
        }




    }


    public void startTryingSemi(Integer korovi, Integer byki ,Integer[] chislo){

        Integer n = chislo[0]*1000+chislo[1]*100+chislo[2]*10+chislo[3];
        int popitka = 0;


        if (korovi.equals(0) && byki.equals(0) && !n.equals(0))
        {
            for (int i = 0; i < maxSizeAll; i++)
            {

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(chislo[k]))
                        {
                            usage.set(i,false);
                            break;
                        }
                    }

                }
            }
        }

        if (byki.equals(4))
        {
            resultsData.add("Num was: " + chislo + "You WIN!!!" + popitka);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,resultsData);
            results.setAdapter(arrayAdapter);
        }

    }
    */

}
