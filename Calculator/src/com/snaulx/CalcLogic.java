package com.snaulx;

import javax.swing.*;

public class CalcLogic {
    private static final Expression currentExpression = new Expression();

    private static StringBuilder numberBuilder = new StringBuilder();
    private static float lastResult = 0.0f;

    public static void addToNumber(Character ch) {
        if (Character.isDigit(ch) || ch == '.') {
            numberBuilder.append(ch);
            Form.updateText();
        }
    }

    public static void removeLast() {
        if (numberBuilder.isEmpty()) {
            float lastNumber = currentExpression.removeLast();
            if (!Float.isNaN(lastNumber)) {
                numberBuilder.append(lastNumber);
            }
        }
        else {
            numberBuilder.deleteCharAt(numberBuilder.length() - 1);
        }
        Form.updateText();
    }

    public static void addLastResult() {
        if (numberBuilder.isEmpty()) {
            currentExpression.addNumber(lastResult);
            Form.updateText();
        }
    }

    public static void addBinaryOperation(BinaryOperation binaryOperation) {
        if (!numberBuilder.isEmpty()) {
            currentExpression.addNumber(parseNumber());
        }
        else if (currentExpression.isNumbersEmpty())
            currentExpression.addNumber(lastResult);
        currentExpression.addBinaryOperation(binaryOperation);
        Form.updateText();
    }

    public static void addUnaryOperation(UnaryOperation unaryOperation) {
        if (numberBuilder.isEmpty()) {
            currentExpression.addUnaryOperation(unaryOperation);
        }
        else {
            currentExpression.addNumber(unaryOperation.logic().apply(parseNumber()));
        }
        Form.updateText();
    }

    public static String getString() {
        if (currentExpression.isNumbersEmpty() && numberBuilder.isEmpty()) {
            return "0";
        }
        StringBuilder stb = currentExpression.getString();
        stb.append(numberBuilder);
        return stb.toString();
    }

    public static Float calculate() {
        if (!numberBuilder.isEmpty()) currentExpression.addNumber(parseNumber());
        float result = currentExpression.calculate();
        if (Float.isNaN(result))
            return lastResult;
        lastResult = result;
        return lastResult;
    }

    public static void clear() {
        currentExpression.clear();
    }

    private static float parseNumber() {
        try {
            float numb = Float.parseFloat(numberBuilder.toString());
            numberBuilder = new StringBuilder();
            return numb;
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Wrong number input", "Invalid number format", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
