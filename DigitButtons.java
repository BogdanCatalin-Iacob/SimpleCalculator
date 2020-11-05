package bogdan.iacob;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtons extends Button implements ActionListener {

    SimpleCalculator calculator;
    DigitButtons(int x, int y, int width, int height, String letters, SimpleCalculator calculator){
        super(letters);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }
    static boolean isInString(String s, char ch){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ch) {
                return true;
            }
        }return false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String tempText = ((DigitButtons) e.getSource()).getLabel();
        if (tempText.equals(".")) {
            if (calculator.setClear) {
                calculator.displayLabel.setText("0");
                calculator.setClear = false;
            } else if (!isInString(calculator.displayLabel.getText(), '.')) {
                calculator.displayLabel.setText(calculator.displayLabel.getText() + ".");
            }
            return;
        }

        int index = 0;
        try{
            index = Integer.parseInt(tempText);
        }catch (NumberFormatException er){
            return;
        }
        if(index == 0 && calculator.displayLabel.getText().equals("0")){
            return;
        }
        if(calculator.setClear){
            calculator.displayLabel.setText("" + index);
            calculator.setClear = false;
        }else{
            calculator.displayLabel.setText(calculator.displayLabel.getText() + index);
        }
    }
}
