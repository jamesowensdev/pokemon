package com.example.pokemoncatalogue.cards.ownedcards;

import com.example.pokemoncatalogue.util.enums.CardCondition;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnedCardsService {

    private final OwnedCardsRepository repository;

    private OwnedCardsService(OwnedCardsRepository repository){
        this.repository = repository;

    }
    private OwnedCardsDTO mapToDTO(OwnedCards card) {
        return new OwnedCardsDTO(
                card.getCardId(),
                card.getCondition(),
                card.isGraded(),
                card.getRating()
        );
    }

    public List<OwnedCardsDTO> getAllCardsByOwner(long id){
        return repository.findAllCardsByOwner(id)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersCardsByName(String cardName, long id){
        return repository.findCardsByName(cardName, id)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersCardsBySet(String set, long id){
        return repository.findCardsBySet(set, id)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersCardsByCondition(CardCondition condition, long id){
        return repository.findCardsByCondition(condition, id)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersGradedCards(boolean graded, long id){
        return repository.findGradedCards(graded, id)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersCardsByRating(int rating, long id){
        return repository.findCardByRating(rating, id)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

    }

}
