package com.poker.cardsservice.model;

import lombok.AllArgsConstructor;

public record Card(Spade spade, Color color) {
    @AllArgsConstructor
    enum Spade {
        S2("2"),
        S3("3"),
        S4("4"),
        S5("5"),
        S6("6"),
        S7("7"),
        S8("8"),
        S9("9"),
        S10("10"),
        JACK("jack"),
        QUEEN("queen"),
        KING("king"),
        AS("as");

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
        return "Card{" + spade.symbol + " " + color.symbol + '}';
    }
}
