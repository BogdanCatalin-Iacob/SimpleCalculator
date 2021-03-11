package bogdan.iacob;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButtons extends JButton implements ActionListener {

    SimpleCalculatorUI calculator;

    OperatorButtons(int x, int y, int width, int height, String letter, SimpleCalculatorUI calculator) {
        super(letter);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operatorText = ((OperatorButtons) e.getSource()).getText();
        calculator.setClear = true;
        double tempDisplayNumber = Double.parseDouble(calculator.displayLabel.getText());
        if (operatorText.equals("1/x")) {
            try {
                double tempD = 1 / tempDisplayNumber;
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(tempD));
            } catch (ArithmeticException ae) {
                calculator.displayLabel.setText("Divide by 0.");
            }
            return;
        }
        if (operatorText.equals("√")) {
            try {
                double sqrtResult = Math.sqrt(tempDisplayNumber);
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(sqrtResult));
            } catch (ArithmeticException e1) {
                calculator.displayLabel.setText("Divide by 0.");
            }
            return;
        }


        if (!operatorText.equals("=")) {

            calculator.number = tempDisplayNumber;
            calculator.operator = operatorText.charAt(0);
            calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(tempDisplayNumber));
            return;
        }

            switch (calculator.operator) {
            case '+':
                tempDisplayNumber += calculator.number;
                break;
            case '-':
                tempDisplayNumber = calculator.number - tempDisplayNumber;
                break;
            case '*':
                tempDisplayNumber *= calculator.number;
                break;
            case '/':
                try {
                    tempDisplayNumber = calculator.number / tempDisplayNumber;
                } catch (ArithmeticException e1) {
                    calculator.displayLabel.setText("Divide by 0.");
                    return;
                }
                break;
            case '%':
                try {
                    tempDisplayNumber = (calculator.number * tempDisplayNumber) / 100;
                } catch (ArithmeticException e1) {
                    calculator.displayLabel.setText("Divide by 0.");
                    return;
                }
                break;
        }
        calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(tempDisplayNumber));
}
}
