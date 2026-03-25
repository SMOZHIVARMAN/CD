import java.util.*;
import java.util.regex.*;

public class LexSimulator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter code:");
        String input = sc.nextLine();

        String[] tokens = input.split("\\s+");

        for(String token : tokens) {

            if(token.matches("int|float|char|void|main|printf")) {
                System.out.println("Keyword: " + token);
            }
            else if(token.matches("[a-zA-Z][a-zA-Z0-9]*")) {
                System.out.println("Identifier: " + token);
            }
            else if(token.matches("[0-9]+")) {
                System.out.println("Integer: " + token);
            }
            else if(token.matches("[0-9]+\\.[0-9]+")) {
                System.out.println("Float: " + token);
            }
            else if(token.matches("[+\\-*/=]")) {
                System.out.println("Operator: " + token);
            }
            else if(token.matches("[;(){}]")) {
                System.out.println("Punctuation: " + token);
            }
            else {
                System.out.println("Unknown: " + token);
            }
        }

        sc.close();
    }
}