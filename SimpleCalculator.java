package bogdan.iacob;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleCalculator extends Frame {

    public boolean setClear = true;
    double number;
    double memValue;
    char operator;

    String[] digitButtonText = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "+/-", "0", "."};
    String[] operatorButtonText = {"%", "sqrt", "/", "*", "-", "1/x", "+", "="};
    String[] memoryButtonText = {"MC", "MR", "MS", "M+", "M-"};
    String[] specialButtonText = {"Del", "C", "CE"};

    DigitButtons[] digitButtons = new DigitButtons[digitButtonText.length];
    OperatorButtons[] operatorButtons = new OperatorButtons[operatorButtonText.length];
    MemoryButtons[] memoryButtons = new MemoryButtons[memoryButtonText.length];
    SpecialButtons[] specialButtons = new SpecialButtons[specialButtonText.length];


    Label displayLabel = new Label("0", Label.RIGHT);
    Label memoryLabel = new Label(" ", Label.RIGHT);

    final int FRAME_WIDTH = 400;
    final int FRAME_HEIGHT = 650;
    final int HEIGHT = 60;
    final int WIDTH = 60;
    final int H_SPACE = 10;
    final int V_SPACE = 10;
    final int TOP_X = 30;
    final int TOP_Y = 50;

    Font font = new Font("Arial",Font.BOLD, 36);
    Font font2 = new Font("Arial", Font.ITALIC,28);

    SimpleCalculator(String frameText) {
        super(frameText);
        int tempX = TOP_X;
        int y = TOP_Y;

        displayLabel.setBounds(tempX, y, 340, HEIGHT);
        displayLabel.setBackground(Color.CYAN);
        displayLabel.setForeground(Color.BLACK);
        displayLabel.setFont(font);
        add(displayLabel);

        memoryLabel.setBounds(TOP_X, TOP_Y + HEIGHT + V_SPACE, WIDTH, HEIGHT);
        add(memoryLabel);

        // set memory buttons coordinates
        tempX = TOP_X;
        y = TOP_Y + 3 * (HEIGHT + V_SPACE);
        for (int i = 0; i < memoryButtonText.length; i++) {
            memoryButtons[i] = new MemoryButtons(tempX, y, WIDTH, HEIGHT, memoryButtonText[i], this);
            memoryButtons[i].setForeground(Color.RED);
            tempX += WIDTH + H_SPACE;
        }

        //set special buttons coordinates
        tempX = TOP_X;
        y = TOP_Y + 2*(HEIGHT + V_SPACE);
        for (int i = 0; i < specialButtonText.length; i++) {
            specialButtons[i] = new SpecialButtons(tempX, y, WIDTH + 20, HEIGHT, specialButtonText[i], this);
            specialButtons[i].setForeground(Color.RED);
            tempX = tempX + 2*WIDTH + H_SPACE;
        }

        //set digits buttons coordinates
        tempX = TOP_X;
        y = TOP_Y + 4 * (HEIGHT + V_SPACE);

        for (int i = 0; i < digitButtonText.length; i++) {
            digitButtons[i] = new DigitButtons(tempX, y, WIDTH, HEIGHT, digitButtonText[i], this);
            digitButtons[i].setForeground(Color.BLUE);
            digitButtons[i].setFont(font);
            tempX += WIDTH + H_SPACE;
            if ((i + 1) % 3 == 0) {
                tempX = TOP_X;
                y += HEIGHT + V_SPACE;
            }
        }

        //set operator buttons coordinates

        tempX = TOP_X + 3*(WIDTH + H_SPACE);
        y = TOP_Y + 4*(HEIGHT + V_SPACE);
        for (int i = 0; i < operatorButtonText.length; i++) {
            operatorButtons[i] = new OperatorButtons(tempX, y, WIDTH, HEIGHT, operatorButtonText[i], this);
            operatorButtons[i].setForeground(Color.RED);
            operatorButtons[i].setFont(font2);
            tempX += WIDTH + H_SPACE;

            if((i + 1) % 2 == 0){
                tempX = TOP_X + 3*(WIDTH + H_SPACE);
                y += HEIGHT + V_SPACE;
            }

        }


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }

    static String getFormattedText(double temp) {
        String resText = "" + temp;
        if (resText.lastIndexOf(".0") > 0) {
            resText = resText.substring(0, resText.length() - 2);
        }
        return resText;
    }
}
