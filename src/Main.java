import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner operationScanner = new Scanner(System.in);
        char operator;
        while (true) {
            System.out.println("Please enter a arithmetic operation name or (*,+,/,-)! \nType e or exit to close the program.");
            String operation = operationScanner.nextLine().toLowerCase();
            if (operation.equals("e") || operation.equals("exit")) {
                System.out.println("Info: You have entered " + operation + " to close the calculator. \nLooking forward to seeing you again!");
                operationScanner.close();
                break;
            }
            switch (operation) {
                case "+", "a", "addition":
                    operator = '+';
                    new Addition(operator);
                    break;
                case "-", "s", "subtraction":
                    operator = '-';
                    new Subtraction(operator);
                    break;
                case "*", "m", "multiplication":
                    operator = '*';
                    new Multiplication(operator);
                    break;
                case "/", "d", "division":
                    operator = '/';
                    new Division(operator);
                    break;
                default:
                    System.out.println("Error: Operator " + operation + " not found!");
                    break;
            }
        }
    }
}
