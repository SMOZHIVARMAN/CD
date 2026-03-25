import java.util.*;

public class VariableCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter variable: ");
        String var = sc.next();

        if(var.matches("[a-zA-Z][a-zA-Z0-9]*"))
            System.out.println("Valid Variable");
        else
            System.out.println("Invalid Variable");
    }
}