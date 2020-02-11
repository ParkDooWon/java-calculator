package study;

import exceptionhandler.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionHandlerTest {
    @Test
    @DisplayName("Test isNumber method")
    public void isNumberTest() {
        List<String> nums = Arrays.asList("1", "2", "3");
        assertThat(ExceptionHandler.isNumber(nums)).isTrue();
        nums = Arrays.asList("102", "1356", "9813");
        assertThat(ExceptionHandler.isNumber(nums)).isTrue();
        nums = Arrays.asList("abc", "12", "34");
        assertThat(ExceptionHandler.isNumber(nums)).isFalse();
        nums = Arrays.asList("1a", "2a4", "3s");
        assertThat(ExceptionHandler.isNumber(nums)).isFalse();
    }

    @Test
    @DisplayName("Test isValidOperator method")
    public void 사칙연산_외의_다른_문자가_들어온_경우_예외처리1() {
        List<String> opers = Arrays.asList("++", "--", "**", "//");
        List<String> finalOpers = opers;
        assertThatThrownBy(() -> {
            ExceptionHandler.isValidOperator(finalOpers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Test isValidOperator method")
    public void 사칙연산_외의_다른_문자가_들어온_경우_예외처리2() {
        List<String> opers = Arrays.asList("a", "b", "c", "d");
        List<String> finalOpers = opers;
        assertThatThrownBy(() -> {
            ExceptionHandler.isValidOperator(finalOpers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Test isValidOperator method")
    public void 사칙연산_외의_다른_문자가_들어온_경우_예외처리3() {
        List<String> opers = Arrays.asList("1", "2", "3", "4");
        List<String> finalOpers = opers;
        assertThatThrownBy(() -> {
            ExceptionHandler.isValidOperator(finalOpers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Test isValidOperator method")
    public void 사칙연산_외의_다른_문자가_들어온_경우_예외처리4() {
        List<String> opers = Arrays.asList("+1", "2-", "*3", "/4/");
        List<String> finalOpers = opers;
        assertThatThrownBy(() -> {
            ExceptionHandler.isValidOperator(finalOpers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "9843"})
    @DisplayName("Test isMatch method")
    public void isMatchTest(String target) {
        assertThat(ExceptionHandler.isMatchNumber(target)).isTrue();
    }
}
