package bogdan.iacob;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedButtons extends JButton implements ActionListener {

    SimpleCalculator calculator;

    public AdvancedButtons(int x, int y, int width, int height, String letters,SimpleCalculator calculator) {
        super(letters);
        setBounds(x, y, width, height);
        this.calculator = calculator;
        this.calculator.add(this);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String advancedButtons = ((AdvancedButtons) e.getSource()).getText();
        switch (advancedButtons){
            case "sin" :

                break;
            case "cos" :

                break;
            case "tan" :

                break;
            case "√¯" :

                break;
                case "log" :
                    break;
        }
    }
}
