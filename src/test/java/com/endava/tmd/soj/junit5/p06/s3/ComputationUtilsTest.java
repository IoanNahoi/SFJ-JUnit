package com.endava.tmd.soj.junit5.p06.s3;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {

    private static Stream<Arguments> getElements() {
        return Stream.of(
                Arguments.of(0, 15, 15),
                Arguments.of(7, 8, 15),
                Arguments.of(10, 31, 41)
        );
    }

    private static Stream<Arguments> getMaxAndMin() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, -1)
        );
    }


    @ParameterizedTest(name = "Calculates the sum of {0} \u002B {1} \u21D2 {2}")
    @MethodSource("getElements")
    void getSum(int a, int b, int expected) {
        assertEquals(expected, sum(a, b));
    }

    @ParameterizedTest(name = "Checking for errors for the sum of {0} \u002B {1}")
    @MethodSource("getMaxAndMin")
    void testOverflow(int a, int b) {
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }


}
