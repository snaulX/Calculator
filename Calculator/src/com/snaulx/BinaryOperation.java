package com.snaulx;

import javax.swing.*;

public record BinaryOperation(String name, int priority, BinaryOperationLogic logic) {

    public static final BinaryOperation PLUS = new BinaryOperation("+", 0, Float::sum);
    public static final BinaryOperation MINUS = new BinaryOperation("-", 0, (l, r) -> l - r);
    public static final BinaryOperation STAR = new BinaryOperation("*", 1, (l, r) -> l * r);
    public static final BinaryOperation SLASH = new BinaryOperation("/", 1, (l, r) -> {
        if (r == 0) {
            JOptionPane.showMessageDialog(null,
                    "You can't divide on zero", "Division on zero", JOptionPane.ERROR_MESSAGE);
            return 0.0f;
        }
        return l / r;
    });
    public static final BinaryOperation PERCENT = new BinaryOperation("%", 1, (l, r) -> l % r);
    public static final BinaryOperation POWER = new BinaryOperation("**", 2, (l, r) ->
            (float)Math.pow(l, r));
}
