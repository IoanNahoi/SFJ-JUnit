package com.endava.tmd.soj.junit5.p02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.substraction;
import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"
@DisplayName("Tests for my sum method")
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
        assertThat(sum(2,3)).isEqualTo(5);
    }

    @Test
    @DisplayName("-2 + -3 = -5")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-2,-3)).isEqualTo(-5);
    }

    @Test
    @DisplayName("-2 + 3 = 1")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2,3)).isEqualTo(1);
    }

    @Test
    @DisplayName("2 + -3 = -5")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2,-3)).isEqualTo(-1);

    }

}
