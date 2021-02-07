package bogdan.iacob;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedButtons extends JButton implements ActionListener {

    SimpleCalculatorUI calculator;

    public AdvancedButtons(int x, int y, int width, int height, String letters, SimpleCalculatorUI calculator) {
        super(letters);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String advancedButtons = ((AdvancedButtons) e.getSource()).getText();
        double tempNumber = Double.parseDouble(calculator.displayLabel.getText());

        switch (advancedButtons) {
            case "sin":
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(Math.sin(Math.toRadians(tempNumber))));
                break;

            case "cos":
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(Math.cos(Math.toRadians(tempNumber))));
                break;

            case "tan":
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(Math.tan(Math.toRadians(tempNumber))));
                break;

            case "log":
                if (tempNumber <= 0) {
                    calculator.displayLabel.setText("Invalid number");
                }
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(Math.log10(tempNumber)));
                break;

            case "π":
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(Math.PI * tempNumber));
                break;
        }
    }
}
