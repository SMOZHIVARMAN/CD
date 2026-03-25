import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression (a + b): ");
        int a = sc.nextInt();
        char op = sc.next().charAt(0);
        int b = sc.nextInt();

        switch(op) {
            case '+': System.out.println("Result = " + (a + b)); break;
            case '-': System.out.println("Result = " + (a - b)); break;
            case '*': System.out.println("Result = " + (a * b)); break;
            case '/': System.out.println("Result = " + (a / b)); break;
            default: System.out.println("Invalid operator");
        }
    }
}