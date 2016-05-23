package com.example.bullscows;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    private GameRiddle riddle = new GameRiddle();
    private RiddleSolver solver = new RiddleSolver();






    @Test
    public void riddleCheck() {

        int[] num = new int[4];

        for (int i=0; i < 4; i++)
        {
            num[i] = i++;
        }

        riddle.getUserNum(num);

        int[] test = new int[4];
        num[0] = 4;
        num[1] = 2;
        num[2] = 3;
        num[3] = 1;

        int[] bacT = new int[2];
        bacT[0] = 2;
        bacT[1] = 2;

        int[] bac;

        bac =  riddle.sendAnswer(test);
        assertArrayEquals(bacT,bac);
    }

    @Test
    public void solverCheck() {

        String res;
        int[] num = new int[4];


        for (int i=0; i < 4; i++)
        {
            num[i] = i++;
        }

        riddle.getUserNum(num);
        do {
            res = solver.makeDecision();
        }while (!res.equals("Number: " + num[0] + num[1] + num[2] + num[3] + " WELL DONE COMPUTER "));


    }
}