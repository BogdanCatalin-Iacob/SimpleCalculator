package bogdan.iacob;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialButtons extends JButton implements ActionListener{

    SimpleCalculatorUI calculator;

    SpecialButtons(int x, int y, int width, int height, String letter, SimpleCalculatorUI calculator){
        super(letter);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }

    static String delete(String s){
        return s.substring(0, s.length() - 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opText = ((SpecialButtons)e.getSource()).getText();
        if(opText.equals("Del")){
            String tempText = delete(calculator.displayLabel.getText());
            if(tempText.equals("")){
                calculator.displayLabel.setText("0");
            }else{
                calculator.displayLabel.setText(tempText);
            }
            return;
        }
        if(opText.equals("C")){
            calculator.number = 0.0;
            calculator.operator = ' ';
            calculator.memValue = 0.0;
            calculator.memoryLabel.setText(" ");
        }
        calculator.displayLabel.setText("0");
        calculator.setClear = true;
    }
}
