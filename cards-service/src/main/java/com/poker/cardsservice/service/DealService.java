package com.poker.cardsservice.service;

import com.poker.cardsservice.model.domain.Card;
import com.poker.cardsservice.model.domain.Deal;
import com.poker.cardsservice.model.domain.Deck;
import com.poker.cardsservice.model.domain.Slot;
import com.poker.cardsservice.repo.DealRepo;
import io.vavr.Tuple2;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
public class DealService {
    private final DealRepo dealRepo;

    public Optional<Deal> getDeal(UUID dealId) {
        return dealRepo.findById(dealId);
    }

    public UUID dealTexasStyle(Integer players) {
        UUID dealId = UUID.randomUUID();
        MDC.put("myGameId", dealId.toString());

        Deck deck = new Deck();
        Set<Slot> slotsCards = new HashSet<>();

        for (int i = 0; i < players; i++) {
            Tuple2<Set<Card>, Deck> topAndDeck = deck.getTopCards(2);
            slotsCards.add(
                    Slot.builder()
                            .slotId(UUID.randomUUID())
                            .cards(topAndDeck._1())
                            .build());
            deck = topAndDeck._2();
        }

        Set<Card> tableCards = deck.getTopCards(5)._1();
        log.info("table: " + tableCards);
        slotsCards.forEach(slot -> log.info(slot.getCards().toString()));


        dealRepo.save(Deal.builder()
                .dealId(dealId)
                .tableCards(tableCards)
                .cardsOnSlot(slotsCards)
                .build());

        return dealId;
    }
}
