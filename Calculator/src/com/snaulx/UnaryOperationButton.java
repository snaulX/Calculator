package com.snaulx;

import javax.swing.*;
import java.awt.*;

import static com.snaulx.CalcLogic.addUnaryOperation;

public class UnaryOperationButton extends JButton {
    public UnaryOperationButton(UnaryOperation op) {
        super(op.name());
        setBackground(Color.GREEN);
        setFont(new Font("Arial Black", Font.PLAIN, Form.BUTTON_TEXT_SIZE));
        addActionListener(e -> addUnaryOperation(op));
    }
}
