import java.util.*;

public class ThreeAddressCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression (a=b+c*d): ");
        String expr = sc.nextLine();

        char a = expr.charAt(0);
        char b = expr.charAt(2);
        char c = expr.charAt(4);
        char d = expr.charAt(6);

        System.out.println("\nThree Address Code:");

        System.out.println("t1 = " + c + " * " + d);
        System.out.println("t2 = " + b + " + t1");
        System.out.println(a + " = t2");

        sc.close();
    }
}