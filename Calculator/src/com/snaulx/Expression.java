package com.snaulx;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final List<BinaryOperation> binaryOperations;
    private final List<Float> numbers;

    public Expression() {
        binaryOperations = new ArrayList<>();
        numbers = new ArrayList<>();
    }

    public Float calculate() {
        if (numbers.size() == 0) return Float.NaN;
        float result = 0.0f;
        while (!binaryOperations.isEmpty()) {
            result = calcMaxPriority();
        }
        return result;
    }

    public StringBuilder getString() {
        StringBuilder stb = new StringBuilder();
        int opSize = binaryOperations.size();
        for (int i = 0; i < numbers.size(); i++) {
            stb.append(numbers.get(i));
            stb.append(' ');
            if (i < opSize) {
                stb.append(binaryOperations.get(i).name());
                stb.append(' ');
            }
        }
        return stb;
    }

    public void addNumber(Float numb) {
        numbers.add(numb);
    }

    public void addBinaryOperation(BinaryOperation binaryOperation) {
        binaryOperations.add(binaryOperation);
    }

    public boolean isNumbersEmpty() {
        return numbers.isEmpty();
    }

    public void clear() {
        numbers.clear();
        binaryOperations.clear();
    }

    public void addUnaryOperation(UnaryOperation unaryOperation) {
        if (!numbers.isEmpty()) {
            int lastIndex = numbers.size() - 1;
            float after = unaryOperation.logic().apply(numbers.get(lastIndex));
            numbers.remove(lastIndex);
            addNumber(after);
        }
    }

    public Float removeLast() {
        if (binaryOperations.isEmpty()) return Float.NaN; // so there's nothing for remove
        binaryOperations.remove(binaryOperations.size() - 1);
        int lastNumbIndex = numbers.size() - 1;
        return numbers.remove(lastNumbIndex);
    }

    private Float calcMaxPriority() {
        int index = 0;
        BinaryOperation operation = binaryOperations.get(0);
        for (int i = 0; i < binaryOperations.size(); i++) {
            if (binaryOperations.get(i).priority() > operation.priority()) {
                index = i;
                operation = binaryOperations.get(i);
            }
        }
        // In first time we remove 'index' after that 'index+1'
        // will be 'index' so we remove again at 'index'
        float left = numbers.remove(index), right = numbers.remove(index);
        float result = operation.logic().apply(left, right);
        binaryOperations.remove(index);
        numbers.add(index, result);
        return result;
    }
}
