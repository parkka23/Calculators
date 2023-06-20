import java.util.*;
import java.io.IOException;

public class RPN_calculator {
    public Double calculate(String[] tokens)
    {
        Stack<String> stack = new Stack<String>();
        Double x, y;
        String result = "";
        String choice;
        Double value = (double) 0;
        String p = "";

        // Iterating to each character
        // in the array of the string
        for (int i = 0; i < tokens.length; i++) {

            // If the character is not the special character
            // ('+', '-' ,'*' , '/')
            // then push the character to the stack
            if (!tokens[i].equals("+") && !tokens[i].equals("-")
                    && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(tokens[i]);
                continue;
            }
            else {
                // else if the character is the special
                // character then use the switch method to
                // perform the action
                choice = tokens[i];


                // Switch-Case
                switch (choice) {
                    case "+":

                        // Performing the "+" operation by popping
                        // put the first two character
                        // and then again store back to the stack

                        x = Double.parseDouble(stack.pop());
                        y = Double.parseDouble(stack.pop());
                        value = x + y;
                        result = p + value;
                        stack.push(result);
                        break;

                    case "-":

                        // Performing the "-" operation by popping
                        // put the first two character
                        // and then again store back to the stack
                        x = Double.parseDouble(stack.pop());
                        y = Double.parseDouble(stack.pop());
                        value = y - x;
                        result = p + value;
                        stack.push(result);
                        break;

                    case "*":

                        // Performing the "*" operation
                        // by popping put the first two character
                        // and then again store back to the stack

                        x = Double.parseDouble(stack.pop());
                        y = Double.parseDouble(stack.pop());
                        value = x * y;
                        result = p + value;
                        stack.push(result);
                        break;

                    case "/":

                        // Performing the "/" operation by popping
                        // put the first two character
                        // and then again store back to the stack

                        x = Double.parseDouble(stack.pop());
                        y = Double.parseDouble(stack.pop());
                        value = y / x;
                        result = p + value;
                        stack.push(result);
                        break;

                    default:
                        continue;
                }
            }
        }

        // Method to convert the String to integer
        return Double.parseDouble(stack.pop());
    }
}

class Test {
    public static void main(String[] args) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        String input=" ";

        do {
            // String Input
            System.out.print(">> ");
            input = sc.nextLine();
            String[] s = input.split(" ");

//            for (String st : s) {
//                System.out.println(st);
//            }

//        String[] s
//                = { "10", "6", "9",  "3", "+", "-11", "*",
//                "/",  "*", "17", "+", "5", "+" };

            RPN_calculator str = new RPN_calculator();
            Double result = str.calculate(s);
            System.out.println(result);
            System.out.println();

        } while (!input.equals("x"));
    }
}