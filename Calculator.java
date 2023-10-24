import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression (e.g., 'a + b - c', 'a * b - c', 'a / b * c'):");

        try {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            if (tokens.length != 3) {
                throw new IllegalArgumentException("Invalid input format. Please enter a valid expression.");
            }

            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[2]);
            int c = Integer.parseInt(tokens[4]);

            char operator1 = tokens[1].charAt(0);
            char operator2 = tokens[3].charAt(0);

            int result;

            if (operator1 == '+' && operator2 == '-')
                result = a + b - c;
            else if (operator1 == '-' && operator2 == '+')
                result = a - b + c;
            else if (operator1 == '*' && operator2 == '-')
                result = a * b - c;
            else if (operator1 == '/' && operator2 == '*')
                result = a / b * c;
            else {
                throw new IllegalArgumentException("Invalid operator combination. Please enter a valid expression.");
            }

            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
