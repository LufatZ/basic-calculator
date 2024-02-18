import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String[] operators = {"+","-","/","*","m","d","s","a"};
    static String[] proceedInput = {"y","t"};
    static String[] abortInput = {"n","f", "e"};
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String continueResponse="";
        while (!abort(continueResponse)) {
            System.out.println("Do you want to perform an operation? Answer with yes or no (y|n)!");
            continueResponse = scanner.next();
            if (abort(continueResponse)) {
                System.out.println("See you next time!");
                break;
            } else if (!proceed(continueResponse)) {
                System.out.println(continueResponse + " is no vaild answer!");
                continue;
            }
            scanner.nextLine();
            System.out.println("Please enter a arithmetic operation name or (*,+,/,-)!");
            String operation = scanner.nextLine();
            if (!containsOperator(operation)) {
                System.out.println("Operator " + operation + " not found!");
                continue;
            }
            List<Float> numbers =new ArrayList<>();
            String input = "";
            while (!input.contains("r")) {
                System.out.println("Please enter a number or type result (r) to show the result");
                input = scanner.nextLine();
                try {
                    numbers.add(Float.parseFloat(input));
                } catch (NumberFormatException e) {
                    System.out.println("The result is: " + calculation(operation, numbers));
                }
            }
        }
        scanner.close();
    }
    public static boolean abort(String response){
        for (String responsestring : abortInput) {
            if (response.contains(responsestring)) {
                return true;
            }
        }
        return false;
    }
    public static boolean proceed(String response){
        for (String responsestring : proceedInput) {
            if (response.contains(responsestring)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsOperator(String operation){
        for (String operator : operators) {
            if (operation.contains(operator)) {
                return true;
            }
        }
        return false;
    }

    public static float calculation(String operation, List<Float> numbers){
        float result = 0;
        for (float i : numbers) {
            if (operation.equals("*") || operation.contains("m")) {
                result *= i;
            }
            else if (operation.equals("+") || operation.contains("a")) {
                result += i;
            }
            else if (operation.equals("-") || operation.contains("s")) {
                result -= i;
            }
            else if (operation.equals("/") || operation.contains("d")) {
                if (numbers.contains(0F)){
                    System.out.println("Dividing by 0 is not allowed!");
                }else {
                    result /= i;
                }
            }
        }
        return result;
    }
}
