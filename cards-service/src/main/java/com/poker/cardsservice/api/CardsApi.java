package com.poker.cardsservice.api;

import com.poker.cardsservice.model.domain.Deal;
import com.poker.cardsservice.service.DealService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/deal")
@AllArgsConstructor
public class CardsApi {
    private final DealService dealService;

    @GetMapping("/{dealId}")
    public ResponseEntity<Deal> getDeal(@PathVariable UUID dealId) {
        return ResponseEntity
                .of(dealService.getDeal(dealId));
    }

    @ApiResponse(responseCode = "201")
    @PostMapping
    public ResponseEntity<UUID> deal(@RequestBody Slots slots) {
        return new ResponseEntity<>
                (dealService.dealTexasStyle(slots.getNumberOfSlots()), HttpStatus.CREATED);
    }

    @Data
    private static class Slots {
        Integer numberOfSlots;
    }
}
