package com.snaulx;

import javax.swing.*;
import java.awt.*;

import static com.snaulx.CalcLogic.*;

public class NumberButton extends JButton {
    public NumberButton(Character ch) {
        super(ch.toString());
        setBackground(Color.LIGHT_GRAY);
        setFont(new Font("Arial Black", Font.PLAIN, Form.SIGN_SIZE));
        addActionListener(e -> addToNumber(ch));
    }
}
