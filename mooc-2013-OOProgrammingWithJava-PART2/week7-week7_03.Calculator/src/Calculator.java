/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class Calculator {
    private Reader reader;
    private int counter;
    
    public Calculator() {
        reader = new Reader();
        counter = 0;
    }
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
                counter++;
            } else if (command.equals("difference")) {
                difference();
                counter++;
            } else if (command.equals("product")) {
                product();
                counter++;
            }
        }

        statistics();
    }
    
    private void sum() {
        int a = getValue(1);
        int b = getValue(2);
        printResult(1, a + b);
    }
    
    private void difference() {
        int a = getValue(1);
        int b = getValue(2);
        printResult(2, a - b);
    }
    
    private void product() {
        int a = getValue(1);
        int b = getValue(2);
        printResult(3, a * b);
    }
    
    private void statistics() {
        System.out.println("Calculations done " + counter);
    }
    
    private int getValue(int number) {
        System.out.print("value" + number + ": ");
        return reader.readInteger();
    }
    
    private void printResult(int operation, int result) {
        switch(operation) {
            case 1:
                System.out.println("sum of the values " + result);
                break;
            case 2:
                System.out.println("difference of the values " + result);
                break;
            case 3:
                System.out.println("product of the values " + result);
                break;
        }
        System.out.println("");
    }
}
