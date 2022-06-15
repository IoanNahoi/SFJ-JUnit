package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
class ScoreTest {
    private Score score;
    private static NumberFormat format;

    @BeforeAll
    static void setupLocale() {
//        Locale.setDefault(Locale.US);
        Locale.setDefault(Locale.FRANCE);
        format = NumberFormat.getInstance(Locale.getDefault());
        format.setMinimumFractionDigits(1);
    }

    @BeforeEach
    void initializeScore() {
        score = new Score();
    }

    @Test
    void noScore() {
        assertThat(score.getPercent()).isEqualTo(format.format(100.0));
    }

    @Test
    void OneCORECT() {
        score.addCorrectAnswer();
        assertThat(score.getPercent()).isEqualTo(format.format(100.0));
    }

    @Test
    void OneIncorrect() {
        score.addIncorrectAnswer();
        assertThat(score.getPercent()).isEqualTo(format.format(0.0));
    }

    @Test
    void oneCorrectTwoIncorrect() {
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        assertThat(score.getPercent()).isEqualTo(format.format(33.3));

    }
}
