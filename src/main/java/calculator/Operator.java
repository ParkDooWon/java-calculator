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

    private static Map<String, Operator> operatorMapper = new HashMap<>();
    private String operation;
    static {
        operatorMapper.put("+", Operator.PLUS);
        operatorMapper.put("-", Operator.MINUS);
        operatorMapper.put("*", Operator.MULTIPLY);
        operatorMapper.put("/", Operator.DIVIDE);
    }

    Operator(String operation) {
        this.operation = operation;
    }

    public static void isValidOperator(String oper) throws IllegalArgumentException {
        if (!Arrays.stream(Operator.values())
                .map(o -> o.operation)
                .anyMatch(o -> o.equals(oper))) {
            throw new IllegalArgumentException();
        }
    }

    public abstract int calculate(int a, int b);

    public static Operator getOperatorMapper(String oper) {
        return operatorMapper.get(oper);
    }
}
