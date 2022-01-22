package com.poker.cardsservice.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class Card implements Serializable {
    private Spade spade;
    private Color color;

    @Getter
    @AllArgsConstructor
    enum Spade {
        _2("2"),
        _3("3"),
        _4("4"),
        _5("5"),
        _6("6"),
        _7("7"),
        _8("8"),
        _9("9"),
        _10("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K"),
        AS("A");

        private final String symbol;
    }

    @AllArgsConstructor
    enum Color {
        SPADES("♠️"),
        HEARTH("♥️"),
        CLOVER("♣️"),
        DIAMOND("♦️");

        private final String symbol;
    }

    @Override
    public String toString() {
        return " " + spade.symbol + color.symbol + " ";
    }
}
