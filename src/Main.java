import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (boolean running = true; running;) {
            System.out.println("Gib eine arithmetische Operation ein oder (*,+,/,-):");
            String operation = scanner.nextLine();
            if (containsOperator(operation)) {
                List<Float> numbers =new ArrayList<>();
                System.out.println("Bitte gib die erste Zahl an");
                numbers.add(scanner.nextFloat());
                System.out.println("Bitte gib die zweite zahl an");
                numbers.add(scanner.nextFloat());
                scanner.nextLine();
                while (true){
                    System.out.println("Gib eine weitere Zahl an oder result (r) um das Ergebniss anzuzeigen");
                    String input = scanner.nextLine();
                    if (input.contains("r")){
                        break;
                    }
                    numbers.add(Float.parseFloat(input));
                }
                System.out.println("Das Ergebniss ist: " + berechnung(operation,numbers));
            } else {
                System.out.println("Operator nicht gefunden");
            }
            System.out.println("soll eine weitere Operation ausgeführt werden? Antworte mit true oder flase");
            String continueResponse = scanner.next();
            running = continueResponse.equalsIgnoreCase("true");
            scanner.nextLine(); // Consume newline character
        }
        scanner.close(); // Close scanner to prevent resource leak
    }
    public static boolean containsOperator(String operation){
        String[] operators = {"+","-","/","*","m","d","s","a"};
        for (int i = 0; i < operators.length; i++) {
            if(operation.contains(operators[i])) {
                return true;
            }
        }
        return false;
    }

    public static float berechnung(String operation, List<Float> numbers){
        float result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (operation.equals("*") || operation.contains("m")) {
                result *= numbers.get(i);
            }
            if (operation.equals("+") || operation.contains("a")) {
                result += numbers.get(i);
            }
            if (operation.equals("-") || operation.contains("s")) {
                result -= numbers.get(i);
            }
            if (operation.equals("/") || operation.contains("d")) {
                if (numbers.contains(0F)){
                    System.out.println("Teilen durch null (0) ist nicht erlaubt");
                }else {
                    result /= numbers.get(i);
                }
            }
        }
        return result;
    }
}
