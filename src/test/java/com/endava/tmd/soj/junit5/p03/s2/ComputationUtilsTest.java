package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.substraction;
import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {
    @Test
    @DisplayName("Primul test facut")
    @Order(7)
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
    @Order(5)
    void zeroShouldNotChangePositive() {
        Assertions.assertEquals(3, sum(0, 3));
    }

    @Test
    @DisplayName("-33 + 0 = -33")
    @Order(6)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-33, 0)).isEqualTo(-33);
    }

    @Test
    @DisplayName("2 + 3 = 5")
    @Order(4)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("-2 + -3 = -5")
    @Order(3)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-2, -3)).isEqualTo(-5);
    }

    @Test
    @DisplayName("-2 + 3 = 1")
    @Order(2)
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("2 + -3 = -5")
    @Order(1)
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2, -3)).isEqualTo(-1);

    }
}
