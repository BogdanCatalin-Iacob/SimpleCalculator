package bogdan.iacob;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DigitButtons extends JButton implements ActionListener {

    SimpleCalculatorUI calculator;

    DigitButtons(int x, int y, int width, int height, String letters, SimpleCalculatorUI calculator) {
        super(letters);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }

    static boolean isInString(String s, char ch) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tempText = ((DigitButtons) e.getSource()).getText();
        if (tempText.equals(".")) {
            if (calculator.setClear) {
                calculator.displayLabel.setText("0");
                calculator.setClear = false;
            } else if (!isInString(calculator.displayLabel.getText(), '.')) {
                calculator.displayLabel.setText(calculator.displayLabel.getText() + ".");
            }
            return;
        }
        double num;
        DecimalFormat df = new DecimalFormat("0.##");
        if (tempText.equals("+/-")) {
            try {
                num = Double.parseDouble(calculator.displayLabel.getText());
            } catch (NumberFormatException e2) {
                return;
            }
            num *= -1;
            calculator.displayLabel.setText("" + df.format(num));
        }

        int index;
        try {
            index = Integer.parseInt(tempText);
        } catch (NumberFormatException er) {
            return;
        }
        if (index == 0 && calculator.displayLabel.getText().equals("0")) {
            return;
        }
        if (calculator.setClear) {
            calculator.displayLabel.setText("" + index);
            calculator.setClear = false;
        } else {
            calculator.displayLabel.setText(calculator.displayLabel.getText() + index);
//            calculator.history.append(index);
        }
    }
}



