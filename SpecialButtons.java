package bogdan.iacob;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialButtons extends Button implements ActionListener {

    SimpleCalculator calculator;

    SpecialButtons(int x, int y, int width, int height, String letter, SimpleCalculator calculator){
        super(letter);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }

    static String delete(String s){
        String res = s.substring(0, s.length() - 1);
//        for(int i = 0; i < s.length() - 1; i++){
//            res += s.charAt(i);
//        }
        return res;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opText = ((SpecialButtons)e.getSource()).getLabel();
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
