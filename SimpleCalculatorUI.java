package bogdan.iacob;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculatorUI extends JFrame {

    public boolean setClear = true;
    double number;
    double memValue;
    char operator;
    final int FRAME_WIDTH = 400;
    final int FRAME_HEIGHT = 650;
    final int HEIGHT = 65;
    final int WIDTH = 72;
    final int H_SPACE = 1;
    final int V_SPACE = 1;
    final int TOP_X = 10;
    final int TOP_Y = 50;

    String[] digitButtonText = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "+/-", "0", "."};
    String[] operatorButtonText = {"%", "√", "/", "*", "-", "1/x", "+", "="};
    String[] memoryButtonText = {"MC", "MR", "MS", "M+", "M-"};
    String[] specialButtonText = {"CE", "C", "<<"};
    String[] advancedButtonText = {"sin", "cos", "tan", "log", "π"};

    DigitButtons[] digitButtons = new DigitButtons[digitButtonText.length];
    OperatorButtons[] operatorButtons = new OperatorButtons[operatorButtonText.length];
    MemoryButtons[] memoryButtons = new MemoryButtons[memoryButtonText.length];
    SpecialButtons[] specialButtons = new SpecialButtons[specialButtonText.length];
    AdvancedButtons[] advancedButtons = new AdvancedButtons[advancedButtonText.length];

    JLabel displayLabel = new JLabel("0");
    JLabel memoryLabel = new JLabel(" ");

    Font font = new Font("Arial", Font.BOLD, 26);
    Font font2 = new Font("Arial", Font.PLAIN, 20);

    SimpleCalculatorUI(String frameText) {
        super(frameText);
        int tempX = TOP_X;
        int y = TOP_Y;

        displayLabel.setBounds(tempX, y, (FRAME_WIDTH - 40), (HEIGHT - 20));
        displayLabel.setBackground(Color.WHITE);
        displayLabel.setOpaque(true);
        displayLabel.setForeground(Color.BLACK);
        displayLabel.setFont(font);
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(displayLabel);

        memoryLabel.setBounds(TOP_X, TOP_Y + 20, WIDTH, HEIGHT);
        add(memoryLabel);

        // set memory buttons coordinates
        tempX = TOP_X;
        y = TOP_Y + 2 * (HEIGHT + V_SPACE);
        for (int i = 0; i < memoryButtonText.length; i++) {
            memoryButtons[i] = new MemoryButtons(tempX, y, WIDTH, HEIGHT, memoryButtonText[i], this);
            memoryButtons[i].setFont(font2);
            memoryButtons[i].setForeground(Color.RED);
            memoryButtons[i].setMargin(new Insets(0, 0, 0, 0));
            memoryButtons[i].setContentAreaFilled(false);
            tempX += WIDTH + H_SPACE;
        }

        //set special buttons coordinates
        tempX = TOP_X + 40;
        y = TOP_Y + (HEIGHT + V_SPACE);
        for (int i = 0; i < specialButtonText.length; i++) {
            specialButtons[i] = new SpecialButtons(tempX, y, WIDTH + 20, HEIGHT, specialButtonText[i], this);
            specialButtons[i].setForeground(Color.RED);
            specialButtons[i].setFont(font2);
            specialButtons[i].setMargin(new Insets(0, 0, 0, 0));
            tempX = tempX + WIDTH + 20 + H_SPACE;
        }

        //set digits buttons coordinates
        tempX = TOP_X;
        y = TOP_Y + 4 * (HEIGHT + V_SPACE);

        for (int i = 0; i < digitButtonText.length; i++) {
            digitButtons[i] = new DigitButtons(tempX, y, WIDTH, HEIGHT, digitButtonText[i], this);
            digitButtons[i].setForeground(Color.BLACK);
            digitButtons[i].setFont(font);
            digitButtons[i].setMargin(new Insets(0, 0, 0, 0));

            tempX += WIDTH + H_SPACE;
            if ((i + 1) % 3 == 0) {
                tempX = TOP_X;
                y += HEIGHT + V_SPACE;
            }
        }

        //set operator buttons coordinates
        tempX = TOP_X + 3 * (WIDTH + H_SPACE);
        y = TOP_Y + 4 * (HEIGHT + V_SPACE);
        for (int i = 0; i < operatorButtonText.length; i++) {
            operatorButtons[i] = new OperatorButtons(tempX, y, WIDTH, HEIGHT, operatorButtonText[i], this);
            operatorButtons[i].setForeground(Color.RED);
            operatorButtons[i].setFont(font2);
            operatorButtons[i].setMargin(new Insets(0, 0, 0, 0));

            tempX += WIDTH + H_SPACE;

            if ((i + 1) % 2 == 0) {
                tempX = TOP_X + 3 * (WIDTH + H_SPACE);
                y += HEIGHT + V_SPACE;
            }
        }

        //set advanced buttons coordinates
        tempX = TOP_X;
        y = TOP_Y + 3 * (HEIGHT + V_SPACE);
        for (int i = 0; i < advancedButtonText.length; i++) {
            advancedButtons[i] = new AdvancedButtons(tempX, y, WIDTH, HEIGHT, advancedButtonText[i], this);
            advancedButtons[i].setFont(font2);
            advancedButtons[i].setForeground(Color.BLACK);
            advancedButtons[i].setMargin(new Insets(0, 0, 0, 0));
            advancedButtons[i].setContentAreaFilled(false);
            tempX += WIDTH + H_SPACE;
        }

        ImageIcon logoIcon = new ImageIcon("Calculator-icon4.png");
        Image logo = logoIcon.getImage();
        setIconImage(logo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    static String getFormattedText(double temp) {
        String resultText = "" + temp;
        if (resultText.lastIndexOf(".0") > 0) {
            resultText = resultText.substring(0, resultText.length() - 2);
        }
        return resultText;
    }
}
