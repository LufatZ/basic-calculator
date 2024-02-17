import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (boolean running = true; running;) {
            System.out.println("Welche Operation wollen Sie Ausführen?");
            String operation = scanner.nextLine();
            System.out.println("Bitte gib die erste Zahl an");
            int first = scanner.nextInt();
            System.out.println("Bitte gib die zweite zahl an");
            int scnd = scanner.nextInt();
            int result = 0;
            if (operation.equals("*") || operation.contains("mult")) {
                result = first * scnd;
            }
            if (operation.equals("+") || operation.contains("add")) {
                result = first + scnd;
            }
            if (operation.equals("-") || operation.contains("sub")) {
                result = first - scnd;
            }
            if (operation.equals("/") || operation.contains("div")) {
                result = first / scnd;
            } else {
                System.out.println("Operator" + operation + "nicht gefunden");
            }
            System.out.println("Das Ergebniss ist: " + result);
            System.out.println("soll eine weitere Operation ausgeführt werden? Antworte mit true oder flase");
            String continueResponse = scanner.next();
            running = continueResponse.equalsIgnoreCase("true");
            scanner.nextLine(); // Consume newline character
        }
        scanner.close(); // Close scanner to prevent resource leak
    }
}
