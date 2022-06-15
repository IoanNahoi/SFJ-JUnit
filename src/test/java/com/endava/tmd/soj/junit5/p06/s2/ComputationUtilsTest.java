package com.endava.tmd.soj.junit5.p06.s2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s2.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Provocare: Rescrieti testul care verifica valoarea sumei a doua numere din tema precedenta
// folosind un fisier (Comma-Separated Value) care sa stocheze datele necesare pentru test
// Fisierul se va numi "sumCheckArguments.csv" si va fi creat in folderul src/test/resources
// Se va utiliza adnotarea @CsvFileSource.
// 
// Testul care verifica exceptiile generate se va copia din tema precedenta

class ComputationUtilsTest {
    @ParameterizedTest(name = "Calculates the sum of {0} \u002B {1} \u21D2 {2}")
    @CsvFileSource(resources = "/sumCheckArguments.csv")
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
