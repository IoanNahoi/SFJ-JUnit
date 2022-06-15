package com.endava.tmd.soj.junit5.p05.s2;

import com.endava.tmd.soj.junit5.p01.ComputationUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s2.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta
class ComputationUtilsTest {
    @Test
    @DisplayName("Primul test facut")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        Assertions.assertEquals(0, ComputationUtils.sum(0, 0));

        // AssertJ Assertion
        assertThat(ComputationUtils.sum(0, 0)).isZero();
        //gresit
        //Assertions.assertEquals(1, ComputationUtils.sum(0, 0));

    }

    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangePositive() {
        Assertions.assertEquals(3, ComputationUtils.sum(0, 3));
    }

    @Test
    @DisplayName("-33 + 0 = -33")
    void zeroShouldNotChangeNegative() {
        assertThat(ComputationUtils.sum(-33, 0)).isEqualTo(-33);
    }

    @Test
    @DisplayName("2 + 3 = 5")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(ComputationUtils.sum(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("-2 + -3 = -5")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(ComputationUtils.sum(-2, -3)).isEqualTo(-5);
    }

    @Test
    @DisplayName("-2 + 3 = 1")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(ComputationUtils.sum(-2, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("2 + -3 = -5")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(ComputationUtils.sum(2, -3)).isEqualTo(-1);
    }

    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE, 0)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void maxIntAndANegativeNumber() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE, -15)).isEqualTo(Integer.MAX_VALUE - 15);
    }

    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE, 0)).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void minIntAndAPositiveNumber() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE, 15)).isEqualTo(Integer.MIN_VALUE + 15);
    }

    @Test
    void minIntAndMaxInt() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE, Integer.MAX_VALUE)).isEqualTo(Integer.MIN_VALUE + Integer.MAX_VALUE);
    }

    @Test
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE, Integer.MAX_VALUE)).isEqualTo(-2);
    }

    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        assertThatThrownBy(() -> sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
