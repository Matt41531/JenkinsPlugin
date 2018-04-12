package test;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class calculator {

public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    maths Maths = new maths();

    double zeroAnswer = 0; //Possible refactor needed here at some point
    double negAnswer = 0; //Change variable names
    double posAnswer = 0;
    int randAnswer = 0;
    boolean positive = false;
    double inputA, inputB, inputVar, inputEq;
    char inputStr;
    char operator;
    boolean done = false;

     while (done == false) {
    	positive = false;
        System.out.print("Please enter your expression: ");
        randAnswer = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

        inputA = input.next().charAt(0);
        inputA = 0;
        operator = input.next().charAt(0);
        inputB = input.nextDouble();        
        switch (operator) {
            case '+': {
            			zeroAnswer = Maths.subtract(inputA, inputB);
            			negAnswer = zeroAnswer + 1; 
            }
                      break;
            case '-': {
            			zeroAnswer = Maths.add(inputA, inputB);
            			negAnswer = zeroAnswer - 1;
            }
                      break;
            case '*': {
            			zeroAnswer = Maths.divide(inputA, inputB);
            			negAnswer = -1;
            }
                      break;
            case '/': {
            			zeroAnswer = Maths.multiply(inputA, inputB);
            			negAnswer = -1;
            }
                      break;
            case '^': {
            			zeroAnswer = Maths.power(inputA, inputB);
            			negAnswer = 1;
            }
            		  break;
            case '>': {
            			zeroAnswer = inputB;
            			negAnswer = inputB - 1;
            			posAnswer = inputB + 1;
            			positive = true;
            }
            		  break;
            case '<': {
            			zeroAnswer = inputB;
            			negAnswer = inputB + 1;
            			posAnswer = inputB - 1;
            			positive = true;
            }
            		  break;
            
        }
        
        	System.out.print("Possible edge cases for " + inputStr + " are: ");
        	if(!positive)
        	{
        		System.out.println(Double.toString(zeroAnswer) + ',' + Double.toString(negAnswer) + ',' + Integer.toString(randAnswer));   
        	}
        	else 
        	{
        		System.out.println(Double.toString(zeroAnswer) + ',' + Double.toString(negAnswer) + ',' + Double.toString(posAnswer) + ',' + Double.toString(randAnswer));
        	}
    }       

    input.close();

  }

}
