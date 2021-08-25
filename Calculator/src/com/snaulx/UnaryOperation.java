package com.snaulx;

public record UnaryOperation(String name, UnaryOperationLogic logic) {

    public static final UnaryOperation SQRT = new UnaryOperation("sqrt", (x) -> (float)Math.sqrt(x));
    public static final UnaryOperation SQR = new UnaryOperation("** 2", (x) -> x * x);
}
