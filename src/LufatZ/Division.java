package LufatZ;

public class Division extends Calculation {
    public Division(char operator) {
        super(operator);
    }

    protected void calculate(char operator) {
        double result = 0;
        for (Double number : numbers) {
            if (number == 0) {
                System.out.println("Error: Cannot divide by zero!");
                break;
            }
            if (result == 0) {
                System.out.println("  " + number);
                result = numbers.get(0);
            } else {
                System.out.println(operator + " " + number);
                result /= number;
            }
        }
        Calculation.result(result);
    }
}
