package com.snaulx;

import javax.swing.*;
import java.awt.*;

import static com.snaulx.CalcLogic.*;

public class Form extends JFrame {

    public static final int FORM_HEIGHT = 600;
    public static final int LABEL_WIDTH = 400;
    public static final int LABEL_HEIGHT = 110;
    public static final int BUTTON_TEXT_SIZE = 13;
    public static final int SIGN_SIZE = 20;

    public static Theme theme = Theme.LIGHT_THEME;

    private final JPanel bottomPanel = new JPanel();
    private final JPanel topPanel = new JPanel();

    private static final JLabel text = new JLabel("0");

    // Numbers
    private final NumberButton one = new NumberButton('1');
    private final NumberButton two = new NumberButton('2');
    private final NumberButton three = new NumberButton('3');
    private final NumberButton four = new NumberButton('4');
    private final NumberButton five = new NumberButton('5');
    private final NumberButton six = new NumberButton('6');
    private final NumberButton seven = new NumberButton('7');
    private final NumberButton eight = new NumberButton('8');
    private final NumberButton nine = new NumberButton('9');
    private final NumberButton zero = new NumberButton('0');

    // Operations
    private final BinaryOperationButton plus = new BinaryOperationButton(BinaryOperation.PLUS);
    private final BinaryOperationButton minus = new BinaryOperationButton(BinaryOperation.MINUS);
    private final BinaryOperationButton star = new BinaryOperationButton(BinaryOperation.STAR);
    private final BinaryOperationButton slash = new BinaryOperationButton(BinaryOperation.SLASH);
    private final BinaryOperationButton percent = new BinaryOperationButton(BinaryOperation.PERCENT);
    private final BinaryOperationButton power = new BinaryOperationButton(BinaryOperation.POWER);
    private final UnaryOperationButton sqr = new UnaryOperationButton(UnaryOperation.SQR);
    private final UnaryOperationButton sqrt = new UnaryOperationButton(UnaryOperation.SQRT);
    private final JButton assign = new JButton("=");
    private final JButton clear = new JButton("Clean");
    private final JButton remove = new JButton("Remove");
    private final JButton lastResult = new JButton("LR");
    private final NumberButton dot = new NumberButton('.');

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menu = new JMenu("Options");
    private final JMenuItem changeTheme = new JMenuItem("Change Theme");

    public Form() {
        super("Calculator");
        addKeyListener(new KeyHandler());
        setVisible(true);
        setBounds(100, 100, LABEL_WIDTH, FORM_HEIGHT);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text.setFont(new Font("Arial", Font.PLAIN, 20));
        text.setBounds(0, 0, LABEL_WIDTH, LABEL_HEIGHT);

        changeTheme.addActionListener(e -> {
            if (theme == Theme.LIGHT_THEME)
                setTheme(Theme.DARK_THEME);
            else
                setTheme(Theme.LIGHT_THEME);
        });
        menu.add(changeTheme);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        topPanel.setBounds(0, 0, LABEL_WIDTH, LABEL_HEIGHT);
        topPanel.setBackground(Color.WHITE);
        topPanel.add(text);

        assign.setBackground(Color.LIGHT_GRAY);
        assign.setFont(new Font("Arial Black", Font.PLAIN, SIGN_SIZE));
        assign.addActionListener(e -> calculate());

        clear.setBackground(Color.LIGHT_GRAY);
        clear.setFont(new Font("Arial Black", Font.PLAIN, BUTTON_TEXT_SIZE));
        clear.addActionListener(e -> {
            clear();
            Form.updateText();
        });

        remove.setBackground(Color.LIGHT_GRAY);
        remove.setFont(new Font("Arial Black", Font.PLAIN, BUTTON_TEXT_SIZE));
        remove.addActionListener(e -> removeLast());

        lastResult.setBackground(Color.LIGHT_GRAY);
        lastResult.setFont(new Font("Arial Black", Font.PLAIN, SIGN_SIZE));
        lastResult.addActionListener(e -> addLastResult());

        bottomPanel.setBounds(0, LABEL_HEIGHT, LABEL_WIDTH, FORM_HEIGHT - LABEL_HEIGHT);
        bottomPanel.setLayout(new GridLayout(6, 4));

        setTheme(theme);

        // Add numbers and operations to lowPanel
        bottomPanel.add(seven);
        bottomPanel.add(eight);
        bottomPanel.add(nine);
        bottomPanel.add(star); // end of first row
        bottomPanel.add(four);
        bottomPanel.add(five);
        bottomPanel.add(six);
        bottomPanel.add(minus); // end of second row
        bottomPanel.add(one);
        bottomPanel.add(two);
        bottomPanel.add(three);
        bottomPanel.add(plus); // end of third row
        bottomPanel.add(slash);
        bottomPanel.add(zero);
        bottomPanel.add(dot);
        bottomPanel.add(assign); // end of fourth row
        bottomPanel.add(percent);
        bottomPanel.add(remove);
        bottomPanel.add(power);
        bottomPanel.add(clear); // end of fifth row
        bottomPanel.add(sqr);
        bottomPanel.add(sqrt);
        bottomPanel.add(lastResult); // end of six row

        add(topPanel);
        add(bottomPanel);
    }

    public static void updateText() {
        text.setText(getString());
    }

    public static void calculate() {
        text.setText(text.getText() + " = " + CalcLogic.calculate().toString());
        clear();
    }

    private void setTheme(Theme theme) {
        // Numbers
        one.setBackground(theme.numbColor());
        //one.setForeground(theme.textColor());
        two.setBackground(theme.numbColor());
        //two.setForeground(theme.textColor());
        three.setBackground(theme.numbColor());
        //three.setForeground(theme.textColor());
        four.setBackground(theme.numbColor());
        //four.setForeground(theme.textColor());
        five.setBackground(theme.numbColor());
        //five.setForeground(theme.textColor());
        six.setBackground(theme.numbColor());
        //six.setForeground(theme.textColor());
        seven.setBackground(theme.numbColor());
        //seven.setForeground(theme.textColor());
        eight.setBackground(theme.numbColor());
        //eight.setForeground(theme.textColor());
        nine.setBackground(theme.numbColor());
        //nine.setForeground(theme.textColor());
        zero.setBackground(theme.numbColor());
        //zero.setForeground(theme.textColor());

        // Binary operations
        plus.setBackground(theme.binOpColor());
        //plus.setForeground(theme.textColor());
        minus.setBackground(theme.binOpColor());
        //minus.setForeground(theme.textColor());
        star.setBackground(theme.binOpColor());
        //star.setForeground(theme.textColor());
        slash.setBackground(theme.binOpColor());
        //slash.setForeground(theme.textColor());
        percent.setBackground(theme.binOpColor());
        //percent.setForeground(theme.textColor());
        power.setBackground(theme.binOpColor());
        //power.setForeground(theme.textColor());

        // Unary operations
        sqrt.setBackground(theme.unOpColor());
        //sqrt.setForeground(theme.textColor());
        sqr.setBackground(theme.unOpColor());
        //sqr.setForeground(theme.textColor());

        clear.setBackground(theme.numbColor());
        //clear.setForeground(theme.textColor());
        lastResult.setBackground(theme.numbColor());
        //lastResult.setForeground(theme.textColor());
        assign.setBackground(theme.binOpColor());
        //assign.setForeground(theme.textColor());
        remove.setBackground(theme.unOpColor());
        //remove.setForeground(theme.textColor());
        dot.setBackground(theme.numbColor());
        //dot.setForeground(theme.textColor());

        Form.theme = theme;
    }
}
