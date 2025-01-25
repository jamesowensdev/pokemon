package com.example.pokemoncatalogue.cards.ownedcards;

import com.example.pokemoncatalogue.util.enums.CardCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnedCardsRepository extends JpaRepository<OwnedCards, String> {

    List<OwnedCards> findAllCardsByOwner(long ownerId);

    List<OwnedCards> findCardsByName(String cardName, long ownerId);

    List<OwnedCards> findCardsBySet(String set, long ownerId);

    List<OwnedCards> findCardsByCondition(CardCondition condition, long ownerId);

    List<OwnedCards> findGradedCards(Boolean graded, long ownerId);

    List<OwnedCards> findCardByRating(int rating, long ownerId);


}
