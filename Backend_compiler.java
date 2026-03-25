import java.util.*;

public class BackendCompiler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter TAC (t1=a+b): ");
        String input = sc.nextLine();

        char a = input.charAt(3);
        char op = input.charAt(4);
        char b = input.charAt(5);

        System.out.println("\nAssembly Code:");

        System.out.println("MOV " + a + ", R0");

        switch(op) {
            case '+':
                System.out.println("ADD " + b + ", R0");
                break;
            case '-':
                System.out.println("SUB " + b + ", R0");
                break;
            case '*':
                System.out.println("MUL " + b + ", R0");
                break;
            case '/':
                System.out.println("DIV " + b + ", R0");
                break;
        }

        System.out.println("MOV R0, RESULT");

        sc.close();
    }
}