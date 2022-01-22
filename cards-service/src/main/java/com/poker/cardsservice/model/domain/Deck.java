package com.poker.cardsservice.model.domain;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.Value;

import java.util.*;
import java.util.stream.Collectors;

@Value
public class Deck {
    Set<Card> cards;

    public Deck() {
        this.cards = Arrays.stream(Card.Color.values())
                .map(color -> Arrays.stream(Card.Spade.values())
                        .map(spade -> new Card(spade, color))
                        .collect(Collectors.toSet()))
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public Deck(final Set<Card> cards) {
        this.cards = cards;
    }

    public Tuple2<Set<Card>, Deck> getTopCards(int count) {
        List<Card> cardsList = new ArrayList<>(cards);
        Collections.shuffle(cardsList);
        return Tuple.of(
                new HashSet<>(cardsList.subList(0, count)),
                new Deck(Set.copyOf(cardsList.subList(count, cardsList.size())))
        );
    }
}
