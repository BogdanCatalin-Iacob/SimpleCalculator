package bogdan.iacob;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryButtons extends Button implements ActionListener {
    SimpleCalculator calculator;

    MemoryButtons(int x, int y, int width, int height,String letters, SimpleCalculator calculator){
        super(letters);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e){
        char memoryOperation = ((MemoryButtons)e.getSource()).getLabel().charAt(1);
        calculator.setClear = true;
        double temp = Double.parseDouble(calculator.displayLabel.getText());

        switch(memoryOperation){
            case 'C':
                calculator.memoryLabel.setText(" ");
                calculator.memValue = 0.0;
                break;
            case 'R':
                calculator.displayLabel.setText(SimpleCalculator.getFormattedText(calculator.memValue));
                break;
            case 'S':
                calculator.memValue = 0.0;
            case '+':
                calculator.memValue += Double.parseDouble(calculator.displayLabel.getText());
                if(calculator.displayLabel.getText().equals("0") || calculator.displayLabel.getText().equals("0.0")){
                    calculator.memoryLabel.setText(" ");
                }else{
                    calculator.memoryLabel.setText("M");
                }
                break;
        }
    }
}
