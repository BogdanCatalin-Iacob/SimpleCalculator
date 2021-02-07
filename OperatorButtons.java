package bogdan.iacob;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButtons extends JButton implements ActionListener{

    SimpleCalculatorUI calculator;

    OperatorButtons(int x, int y, int width, int height, String letter, SimpleCalculatorUI calculator){
        super(letter);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operatorText = ((OperatorButtons)e.getSource()).getText();
        calculator.setClear = true;
        double temp = Double.parseDouble(calculator.displayLabel.getText());
        if(operatorText.equals("1/x")){
            try{
                double tempD = 1 / temp;
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(tempD));
            }catch(ArithmeticException ae){
                calculator.displayLabel.setText("Divide by 0.");
            }
            return;
        }
        if(operatorText.equals("√")){
            try{
                double temp1 = Math.sqrt(temp);
                calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(temp1));
            }catch(ArithmeticException e1){
                calculator.displayLabel.setText("Divide by 0.");
            }
            return;
        }
        if(!operatorText.equals("=")){
            calculator.number = temp;
            calculator.operator = operatorText.charAt(0);
            return;
        }

        switch (calculator.operator){
            case '+':
                temp += calculator.number;
                break;
            case '-':
                temp = calculator.number - temp;
                break;
            case '*':
                temp *= calculator.number;
                break;
            case '/':
                try{
                    temp /= calculator.number;
                }catch (ArithmeticException e1){
                    calculator.displayLabel.setText("Divide by 0.");
                    return;
                }
                break;
            case '%':
                try{
                    temp = calculator.number % temp;
                }catch (ArithmeticException e1){
                    calculator.displayLabel.setText("Divide by 0.");
                    return;
                }
                break;
        }
        calculator.displayLabel.setText(SimpleCalculatorUI.getFormattedText(temp));
    }
}
