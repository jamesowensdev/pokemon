package com.example.pokemoncatalogue.cards.allcards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllCardsRepository extends JpaRepository<AllCards, String> {
    List<AllCards> findByCardName(String cardName);

    List<AllCards> findByCardType(String cardType);

    List<AllCards> findBySetName(String setName);

    List<AllCards> findByRarity(String rarity);
}