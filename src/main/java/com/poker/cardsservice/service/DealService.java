package com.poker.cardsservice.service;

import com.poker.cardsservice.model.Card;
import com.poker.cardsservice.model.Deck;
import io.vavr.Tuple2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class DealService {

    public Set<Set<Card>> dealTexasStyle(int players) {
        Deck deck = new Deck();
        Set<Set<Card>> deal = new HashSet<>();

        for (int i = 0; i < players; i++) {
            Tuple2<Set<Card>, Deck> topAndDeck = deck.getTopCards(2);
            deal.add(topAndDeck._1());
            deck = topAndDeck._2();
        }

        return deal;
    }
}
