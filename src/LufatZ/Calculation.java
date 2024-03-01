package LufatZ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Calculation {
    protected static List<Double> numbers = new ArrayList<>();
    protected char operator;

    public Calculation(char operator) {
        Scanner numberScan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number to calculate \nor a letter to calculate the result.");
            try {
                numbers.add(numberScan.nextDouble());
            } catch (Exception e) {
                System.out.println("Info: The calculation of your result is shown below.");
                break;
            }
        }
        this.operator = operator;
        calculate(operator);
    }

    protected static void result(double result) {
        System.out.println("—".repeat(10));
        System.out.println(result);
        System.out.println("=".repeat(10));
        numbers.clear();
    }

    protected abstract void calculate(char operator);
}
