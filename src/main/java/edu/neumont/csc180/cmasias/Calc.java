package edu.neumont.csc180.cmasias;

import java.util.Random;

public class Calc {


    public float randomNumberMax(){
        Random random = new Random();
        return random.nextInt(200+80);

    }
    public float randomNumberMin(){
        Random random = new Random();
        return random.nextInt(100);

    }
    public double dividingNum(double Max, double Min){
        double divide = Min / Max;
        return divide;
    }
    public float subNum(float Max, float Min) {
        float subtract = Max - Min;
        return subtract;
    }

    public float addNum(float Max, float Min) {
        float Add = Max + Min;
        return Add;
    }
    public double multiNum(double Max, double Min){
        double multiply = Min * Max;
        return multiply;
    }


    public void run() {
        System.out.println(dividingNum(randomNumberMax(),randomNumberMin()));
        System.out.println(multiNum(randomNumberMax(),randomNumberMin()));
        System.out.println(addNum(randomNumberMax(),randomNumberMin()));
        System.out.println(subNum(randomNumberMax(),randomNumberMin()));
        System.out.println("calc");

    }
}
