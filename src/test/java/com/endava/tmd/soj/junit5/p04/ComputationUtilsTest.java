package com.endava.tmd.soj.junit5.p04;

import com.endava.tmd.soj.junit5.p05.s1.ComputationUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.substraction;
import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
class ComputationUtilsTest {
    @Test
    @DisplayName("Primul test facut")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        Assertions.assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
        //gresit
        //Assertions.assertEquals(1, ComputationUtils.sum(0, 0));

    }

    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangePositive() {
        Assertions.assertEquals(3, sum(0, 3));
    }

    @Test
    @DisplayName("-33 + 0 = -33")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-33, 0)).isEqualTo(-33);
    }

    @Test
    @DisplayName("2 + 3 = 5")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("-2 + -3 = -5")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-2, -3)).isEqualTo(-5);
    }

    @Test
    @DisplayName("-2 + 3 = 1")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("2 + -3 = -5")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2, -3)).isEqualTo(-1);
    }

    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(sum(Integer.MAX_VALUE, 0)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void maxIntAndANegativeNumber() {
        assertThat(sum(Integer.MAX_VALUE, -15)).isEqualTo(Integer.MAX_VALUE - 15);
    }

    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(Integer.MIN_VALUE, 0)).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void minIntAndAPositiveNumber() {
        assertThat(sum(Integer.MIN_VALUE, 15)).isEqualTo(Integer.MIN_VALUE + 15);
    }

    @Test
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MIN_VALUE, Integer.MAX_VALUE)).isEqualTo(Integer.MIN_VALUE + Integer.MAX_VALUE);
    }

    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(Integer.MAX_VALUE, Integer.MAX_VALUE)).isEqualTo(-2);
    }

}
