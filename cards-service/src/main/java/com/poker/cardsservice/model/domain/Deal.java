package com.poker.cardsservice.model.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@RedisHash("Deal")
public class Deal {
    @Id
    private UUID dealId;
    private Set<Slot> cardsOnSlot;
    private Set<Card> tableCards;
}
