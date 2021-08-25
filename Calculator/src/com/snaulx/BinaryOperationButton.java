package com.snaulx;

import javax.swing.*;

import java.awt.*;

import static com.snaulx.CalcLogic.addBinaryOperation;

public class BinaryOperationButton extends JButton {
    public BinaryOperationButton(BinaryOperation op) {
        super(op.name());
        setBackground(Color.CYAN);
        setFont(new Font("Arial Black", Font.PLAIN, Form.SIGN_SIZE));
        addActionListener(e -> addBinaryOperation(op));
    }
}
