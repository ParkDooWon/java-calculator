package exceptionhandler;

import calculator.Operator;

import java.util.List;
import java.util.regex.Pattern;

public class ExceptionHandler {
    private static final String NUMBER_PATTERN = "(^[0-9]*$)";

    public static boolean isNumber(List<String> nums) {
        boolean check = true;
        for (String num : nums) {
            check = check && isMatchNumber(num);
        }
        return check;
    }

    public static void isValidOperator(List<String> opers) throws IllegalArgumentException {
        opers.stream()
                .forEach(Operator::isValidOperator);
    }

    public static boolean isMatchNumber(String target) {
        return Pattern.matches(NUMBER_PATTERN, target);
    }
}
