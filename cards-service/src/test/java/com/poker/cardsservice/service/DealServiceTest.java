package com.poker.cardsservice.service;

import com.poker.cardsservice.model.domain.Deal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DealServiceTest {
    @Autowired
    DealService dealService;

    @Test
    void dealTexasStyle() {
        UUID dealId = dealService.dealTexasStyle(2);
        Optional<Deal> optionalDeal = dealService.getDeal(dealId);

        assertTrue(optionalDeal.isPresent());
        assertEquals(2, optionalDeal
                .map(Deal::getCardsOnSlot)
                .orElse(Set.of())
                .size());

        assertEquals(5, optionalDeal
                .map(Deal::getTableCards)
                .orElse(Set.of())
                .size());
    }
}
