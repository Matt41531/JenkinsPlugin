package io.jenkins.plugins.sample;

public class maths {

    double add(double a, double b) {
        double answer = a+b;
        return answer;          
    }
    int add(int a, int b) {
    	int answer = a+b;
    	return answer;
    }

    double subtract(double a, double b) {
        double answer = a-b;
        return answer;          
    }

    int subtract(int a, int b) {
    	int answer = a-b;
    	return answer;
    }
    
    double multiply(double a, double b) {
        double answer = a*b;
        return answer;          
    }
    
    int multiply(int a, int b) {
    	int answer = a*b;
    	return answer;
    }

    double divide(double a, double b) {
        double answer = a/b;
        return answer;          
    }

    double power(double a, double b){
        double answer =a;

        for (int x=2; x<=b; x++){
            answer *= a;
        }

        return answer;
    }

}
