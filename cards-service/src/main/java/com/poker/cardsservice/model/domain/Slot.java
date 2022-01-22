package com.poker.cardsservice.model.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class Slot implements Serializable {
    private UUID slotId;
    private Set<Card>  cards;
}
