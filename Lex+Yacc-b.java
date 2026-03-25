import java.util.*;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expr = sc.nextLine();

        try {
            double result = eval(expr);
            System.out.println("Result = " + result);
        } catch(Exception e) {
            System.out.println("Invalid Expression");
        }
    }

    // Simple evaluator using Java Script Engine
    public static double eval(String expr) throws Exception {
        return new javax.script.ScriptEngineManager()
                .getEngineByName("JavaScript")
                .eval(expr) instanceof Number
                ? ((Number)new javax.script.ScriptEngineManager()
                .getEngineByName("JavaScript")
                .eval(expr)).doubleValue() : 0;
    }
}