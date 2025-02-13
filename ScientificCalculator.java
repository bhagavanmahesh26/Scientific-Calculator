import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    String[] functionNames = {"+", "-", "*", "/", "sin", "cos", "tan", "log", "sqrt", "="};
    JButton addButton, subButton, mulButton, divButton;
    JButton sinButton, cosButton, tanButton, logButton, sqrtButton, eqButton;
    JButton delButton, clrButton;
    JPanel panel;

    Font font = new Font("Arial", Font.BOLD, 18);
    
    double num1, num2, result;
    char operator;

    public ScientificCalculator() {
        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 20, 340, 50);
        textField.setFont(font);
        textField.setEditable(false);
        frame.add(textField);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        sqrtButton = new JButton("sqrt");
        eqButton = new JButton("=");

        JButton[] functions = {addButton, subButton, mulButton, divButton, sinButton, cosButton, tanButton, logButton, sqrtButton, eqButton};
        
        for (int i = 0; i < functions.length; i++) {
            functions[i].setFont(font);
            functions[i].addActionListener(this);
        }

        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        delButton.setFont(font);
        clrButton.setFont(font);
        delButton.addActionListener(this);
        clrButton.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(20, 100, 340, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Adding buttons to the panel
        for (int i = 1; i <= 3; i++) panel.add(numberButtons[i]);
        panel.add(addButton);
        for (int i = 4; i <= 6; i++) panel.add(numberButtons[i]);
        panel.add(subButton);
        for (int i = 7; i <= 9; i++) panel.add(numberButtons[i]);
        panel.add(mulButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(eqButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);
        panel.add(sqrtButton);
        panel.add(delButton);
        panel.add(clrButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == sinButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.sin(Math.toRadians(num1))));
        }
        if (e.getSource() == cosButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.cos(Math.toRadians(num1))));
        }
        if (e.getSource() == tanButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.tan(Math.toRadians(num1))));
        }
        if (e.getSource() == logButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.log(num1)));
        }
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.sqrt(num1)));
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String text = textField.getText();
            textField.setText(text.substring(0, text.length() - 1));
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
