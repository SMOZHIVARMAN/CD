import java.util.*;

public class LexicalAnalyzer {

    static String keywords[] = {
        "int","float","char","if","else",
        "while","for","return","void","printf"
    };

    static boolean isKeyword(String str) {
        for(String k : keywords) {
            if(k.equals(str))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a line of code:");
        String line = sc.nextLine();

        int i = 0;
        while(i < line.length()) {

            // Identifier or keyword
            if(Character.isLetter(line.charAt(i))) {
                String temp = "";

                while(i < line.length() && 
                      Character.isLetterOrDigit(line.charAt(i))) {
                    temp += line.charAt(i);
                    i++;
                }

                if(isKeyword(temp))
                    System.out.println(temp + " is Keyword");
                else
                    System.out.println(temp + " is Identifier");
            }

            // Number
            else if(Character.isDigit(line.charAt(i))) {
                String temp = "";

                while(i < line.length() && 
                      Character.isDigit(line.charAt(i))) {
                    temp += line.charAt(i);
                    i++;
                }

                System.out.println(temp + " is Constant");
            }

            // Operator
            else if("+-*/=%".indexOf(line.charAt(i)) != -1) {
                System.out.println(line.charAt(i) + " is Operator");
                i++;
            }

            // Special symbols
            else if("();{}".indexOf(line.charAt(i)) != -1) {
                System.out.println(line.charAt(i) + " is Special Symbol");
                i++;
            }

            else {
                i++;
            }
        }

        sc.close();
    }
}