package bogdan.iacob;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButtons extends Button implements ActionListener {

    SimpleCalculator calculator;

    OperatorButtons(int x, int y, int width, int height, String letter, SimpleCalculator calculator){
        super(letter);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opText = ((OperatorButtons)e.getSource()).getLabel();
        calculator.setClear = true;
        double temp = Double.parseDouble(calculator.displayLabel.getText());
        if(opText.equals("1/x")){
            try{
                double tempD = 1 / (double)temp;
                calculator.displayLabel.setText(SimpleCalculator.getFormattedText(tempD));
            }catch(ArithmeticException ae){
                calculator.displayLabel.setText("Divide by 0.");
            }
            return;
        }
        if(opText.equals("sqrt")){
            try{
                double temp1 = Math.sqrt(temp);
                calculator.displayLabel.setText(SimpleCalculator.getFormattedText(temp1));
            }catch(ArithmeticException e1){
                calculator.displayLabel.setText("Divide by 0.");
            }
            return;
        }
        if(!opText.equals("=")){
            calculator.number = temp;
            calculator.operator = opText.charAt(0);
            return;
        }

        //button pressed
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
        calculator.displayLabel.setText(SimpleCalculator.getFormattedText(temp));
    }
}
