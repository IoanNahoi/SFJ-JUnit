package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
class ComputationUtilsTest {
    @ParameterizedTest(name = "Calculates the sum of {0} \u002B {1}, \u21D2 {2}" )
    @CsvSource({"1,2,3", "5,10,15", "7,8,15"})
    void sumTest(int a, int b, int result) {
        Assertions.assertEquals(result, sum(a, b));
    }

    @ParameterizedTest(name = "Checking for errors for the sum of {0} \u002B {1}" )
    @CsvSource("2147483647,1")
    void zeroShouldNotChangePositive(int a, int b) {
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
