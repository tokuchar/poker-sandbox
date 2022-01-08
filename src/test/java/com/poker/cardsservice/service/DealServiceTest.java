package com.poker.cardsservice.service;

import com.poker.cardsservice.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DealServiceTest {
    DealService dealService = new DealService();

    @Test
    void dealTexasStyle() {
        Set<Set<Card>> deal = dealService.dealTexasStyle(2);
        assertEquals(2, deal.size());
    }
}
