import java.util.Scanner;

public class Calculator {
        static double add(double a, double b) {
        return a + b;
    }
    static double subtract(double a, double b) {
        return a - b;
    }
    static double multiply(double a, double b) {
        return a * b;
    }
    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCalc = true;

        while (continueCalc) {
            System.out.println("\n--- Simple Calculator ---");
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            System.out.println("Choose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();

            double result = 0;
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    System.out.println("Result = " + result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.println("Result = " + result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.println("Result = " + result);
                    break;
                case 4:
                    result = divide(num1, num2);
                    System.out.println("Result = " + result);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String answer = sc.next().toLowerCase();
            if (!answer.equals("yes")) {
                continueCalc = false;
                System.out.println("Exiting Calculator. Goodbye!");
            }
        }
        sc.close();
    }
}
