package calculator;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    };

    private static Map<String, Operator> cal = new HashMap<>();
    private String operation;
    static {
        cal.put("+", Operator.PLUS);
        cal.put("-", Operator.MINUS);
        cal.put("*", Operator.MULTIPLY);
        cal.put("/", Operator.DIVIDE);
    }

    Operator(String operation) {
        this.operation = operation;
    }

    public static boolean isValidOperator(String oper) {
        return Arrays.stream(Operator.values())
                .map(o -> o.operation)
                .anyMatch(o -> o.equals(oper));
    }

    public abstract int calculate(int a, int b);

    public static Operator startCalculate(String oper) {
        return cal.get(oper);
    }
}
