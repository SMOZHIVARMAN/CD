import java.util.*;

public class PredictiveParser {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input string (end with $): ");
        String input = sc.next();
        int i = 0;

        stack.push('$');
        stack.push('S');

        while(!stack.isEmpty()) {
            char top = stack.peek();
            char current = input.charAt(i);

            // Match terminal
            if(top == current) {
                stack.pop();
                i++;
            }
            // Grammar: S → aSb
            else if(top == 'S' && current == 'a') {
                stack.pop();
                stack.push('b');
                stack.push('S');
                stack.push('a');
            }
            // S → ε
            else if(top == 'S' && current == 'b') {
                stack.pop();
            }
            else if(top == '$' && current == '$') {
                System.out.println("String Accepted");
                return;
            }
            else {
                System.out.println("String Rejected");
                return;
            }
        }

        sc.close();
    }
}