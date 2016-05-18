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

    private ArrayList<Integer[]> number = new ArrayList<> (maxSizeAll);
    private ArrayList<Boolean> usage  = new ArrayList<>(maxSizeAll);
    private GameRiddle answer = new GameRiddle();
    private Integer[] prediction = new Integer[maxSizeActive];




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
                            Integer[] n = new Integer [maxSizeActive];
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

        Integer[] bac = new Integer[2];
        String res;
        int cows;
        int bulls;


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

        if (bac[0].equals(0) && bac[1].equals(0))
        {
            for (int i = 0; i < maxSizeAll; i++)
            {

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]))
                        {
                            usage.set(i,false);
                        }
                    }

                }
            }
        }



        if (bac[0].equals(0) && bac[1].equals(1) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                            break;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls != 0 && cows < 1) usage.set(i,false);
            }
        }

        if (bac[0].equals(0) && bac[1].equals(2) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls != 0 && cows < 2) usage.set(i,false);
            }
        }

        if (bac[0].equals(0) && bac[1].equals(3) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls != 0 && cows < 3) usage.set(i,false);
            }
        }

        if (bac[0].equals(1) && bac[1].equals(0) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                            break;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 1 && cows != 0) usage.set(i,false);
            }
        }

        if (bac[0].equals(2) && bac[1].equals(0) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                            break;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 2 && cows != 0) usage.set(i,false);
            }
        }

        if (bac[0].equals(3) && bac[1].equals(0) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                            break;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 3 && cows != 0) usage.set(i,false);
            }
        }



        if (bac[0].equals(1) && bac[1].equals(1) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                            break;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 1 && cows < 1) usage.set(i,false);
            }
        }

        if (bac[0].equals(1) && bac[1].equals(2) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 1 && cows < 2) usage.set(i,false);
            }
        }

        if (bac[0].equals(1) && bac[1].equals(3) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 1 && cows < 3) usage.set(i,false);
            }
        }

        if (bac[0].equals(2) && bac[1].equals(1) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                            break;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 2 && cows < 1) usage.set(i,false);
            }
        }


        if (bac[0].equals(3) && bac[1].equals(1) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                            break;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 3 && cows < 1) usage.set(i,false);
            }
        }

        if (bac[0].equals(2) && bac[1].equals(2) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                bulls = 0;
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                        }

                    }


                }

                for (int p =0; p < maxSizeActive; p++)
                {
                    if (number.get(i)[p].equals(prediction[p]))
                    {
                        bulls++;
                    }
                }

                if (bulls < 2 && cows < 2) usage.set(i,false);
            }
        }

        if ( bac[1].equals(4) )
        {
            for (int i = 0; i < maxSizeAll; i++)
            {
                cows = 0;

                for (int j = 0; j < maxSizeActive; j++)
                {
                    for (int k = 0; k <maxSizeActive; k++)
                    {
                        if (number.get(i)[j].equals(prediction[k]) && usage.get(i))
                        {
                            cows++;
                        }

                    }

                }

                if (cows < 4) usage.set(i,false);
            }
        }




        int cT = 0;

        for (int i = 0; i < maxSizeAll; i ++)
        {
            if (usage.get(i))
            {
                cT++;
            }
        }



         res = makeRes(bac,cT);

        return res;

    }

    public String makeRes(Integer[] bac,int ostatok ){
        String res;
        res = "Number: " + prediction[0] + prediction[1] + prediction[2] + prediction[3] + " Bulls: " + bac[0].toString() + " Cows: " + bac[1] + " ostatok: "+ostatok;

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
