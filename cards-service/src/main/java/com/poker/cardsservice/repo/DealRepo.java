package com.poker.cardsservice.repo;

import com.poker.cardsservice.model.domain.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DealRepo extends CrudRepository<Deal, UUID> {
}
