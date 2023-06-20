import javax.swing.*;
        import java.awt.event.*;
        import java.awt.*;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Stack;


public class RPN_calculator_interface implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont=new Font("Poppings", Font.BOLD, 21);

    double num1=0, num2=0;
    char operator;

    //String[] input;

    List<String> input = new ArrayList<>();

    Stack<String> stack = new Stack<String>();

    Double x, y;
    String result = "";
    String choice;
    Double value = (double) 0;
    String p = "";

    RPN_calculator_interface(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("↵");
        delButton=new JButton("Delete");
        clrButton=new JButton("Clear");
        negButton=new JButton("(-)");

        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        functionButtons[8]=negButton;

        for (int i=0;i<9;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i=0;i<10;i++) {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        RPN_calculator_interface calc=new RPN_calculator_interface();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
//                input.add(numberButtons[i].getText());
//                String str=String.join(" ",input);
//                textField.setText(textField.getText().concat(str));
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
//            input.add(decButton.getText());
//            String str=String.join(" ",input);
//            textField.setText(textField.getText().concat(str));
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
//            input.add(addButton.getText());
//            String str=String.join(" ",input);
//            textField.setText(textField.getText().concat(str));
            //num1=Integer.parseInt(textField.getText());
            //operator='+';
            //textField.setText("");


            x = Double.parseDouble(stack.pop());
            y = Double.parseDouble(stack.pop());
            value = x + y;
            result = p + value;
            stack.push(result);

            textField.setText(stack.pop());


        }

        if (e.getSource() == subButton) {
//            input.add(subButton.getText());
//            String str=String.join(" ",input);
//            textField.setText(textField.getText().concat(str));
//            num1=Integer.parseInt(textField.getText());
//            operator='-';
//            textField.setText("");

            x = Double.parseDouble(stack.pop());
            y = Double.parseDouble(stack.pop());
            value = y - x;
            result = p + value;
            stack.push(result);

            textField.setText(stack.pop());
        }

        if (e.getSource() == mulButton) {
//            input.add(mulButton.getText());
//            String str=String.join(" ",input);
//            textField.setText(textField.getText().concat(str));
//            num1=Integer.parseInt(textField.getText());
//            operator='*';
//            textField.setText("");

            x = Double.parseDouble(stack.pop());
            y = Double.parseDouble(stack.pop());
            value = x * y;
            result = p + value;
            stack.push(result);

            textField.setText(stack.pop());
        }

        if (e.getSource() == divButton) {
//            input.add(divButton.getText());
//            String str=String.join(" ",input);
//            textField.setText(textField.getText().concat(str));
//            num1=Integer.parseInt(textField.getText());
//            operator='/';
//            textField.setText("");

            x = Double.parseDouble(stack.pop());
            y = Double.parseDouble(stack.pop());
            value = y / x;
            result = p + value;
            stack.push(result);

            textField.setText(stack.pop());
        }

        if (e.getSource() == equButton) {
            stack.push(textField.getText());
            textField.setText("");

//            int x, y;
//            String result = "";
//            String choice;
//            int value = 0;
//            String p = "";
//
//            // Iterating to each character
//            // in the array of the string
//            for (int i = 0; i < input.size(); i++) {
//
//                // If the character is not the special character
//                // ('+', '-' ,'*' , '/')
//                // then push the character to the stack
//                if (!input.get(i).equals("+") && !input.get(i).equals("-")
//                        && !input.get(i).equals("*") && !input.get(i).equals("/")) {
//                    stack.push(input.get(i));
//                    continue;
//                }
//                else {
//                    // else if the character is the special
//                    // character then use the switch method to
//                    // perform the action
//                    choice = input.get(i);
//
//                    // Switch-Case
//                    switch (choice) {
//                        case "+":
//
//                            // Performing the "+" operation by popping
//                            // put the first two character
//                            // and then again store back to the stack
//
//                            x = Integer.parseInt(stack.pop());
//                            y = Integer.parseInt(stack.pop());
//                            value = x + y;
//                            result = p + value;
//                            stack.push(result);
//                            break;
//
//                        case "-":
//
//                            // Performing the "-" operation by popping
//                            // put the first two character
//                            // and then again store back to the stack
//                            x = Integer.parseInt(stack.pop());
//                            y = Integer.parseInt(stack.pop());
//                            value = y - x;
//                            result = p + value;
//                            stack.push(result);
//                            break;
//
//                        case "*":
//
//                            // Performing the "*" operation
//                            // by popping put the first two character
//                            // and then again store back to the stack
//
//                            x = Integer.parseInt(stack.pop());
//                            y = Integer.parseInt(stack.pop());
//                            value = x * y;
//                            result = p + value;
//                            stack.push(result);
//                            break;
//
//                        case "/":
//
//                            // Performing the "/" operation by popping
//                            // put the first two character
//                            // and then again store back to the stack
//
//                            x = Integer.parseInt(stack.pop());
//                            y = Integer.parseInt(stack.pop());
//                            value = y / x;
//                            result = p + value;
//                            stack.push(result);
//                            break;
//
//                        default:
//                            continue;
//                    }
//                }
//            }
//
//            // Method to convert the String to integer
//            textField.setText(stack.pop());
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
            stack.clear();
//            input.clear();
        }

        if (e.getSource() == delButton) {
//            input.remove(input.size());
//            String str=String.join(" ",input);
//            textField.setText(textField.getText().concat(str));

            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }

}


