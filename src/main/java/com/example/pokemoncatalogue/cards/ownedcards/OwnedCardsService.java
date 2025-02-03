package com.example.pokemoncatalogue.cards.ownedcards;

import com.example.pokemoncatalogue.cards.allcards.AllCardsDTO;
import com.example.pokemoncatalogue.cards.allcards.AllCardsRepository;
import com.example.pokemoncatalogue.cards.allcards.AllCardsService;
import com.example.pokemoncatalogue.util.enums.CardCondition;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnedCardsService {

    private final OwnedCardsRepository ownedCardsRepository;
    private final AllCardsRepository  allCardsRepository;

    private OwnedCardsService(OwnedCardsRepository ownedCardsRepository, AllCardsRepository allCardsRepository){
        this.ownedCardsRepository = ownedCardsRepository;
        this.allCardsRepository = allCardsRepository;

    }
    private OwnedCardsDTO mapToDTO(OwnedCards card, AllCardsRepository allCardsRepository) {
        AllCardsDTO cardDetails = new AllCardsService(allCardsRepository).getCardById(card.getCardId());
        return new OwnedCardsDTO(
                card.getCardId(),
                card.getCondition(),
                card.isGraded(),
                card.getRating(),
                cardDetails

        );
    }

    public List<OwnedCardsDTO> getAllCardsByOwner(long id){
        return ownedCardsRepository.findAllCardsByOwner(id)
                .stream()
                .map(card -> mapToDTO(card, allCardsRepository))
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersCardsByName(String cardName, long id){
        return ownedCardsRepository.findCardsByName(cardName, id)
                .stream()
                .map(card -> mapToDTO(card, allCardsRepository))
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersCardsBySet(String set, long id){
        return ownedCardsRepository.findCardsBySet(set, id)
                .stream()
                .map(card -> mapToDTO(card, allCardsRepository))
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersCardsByCondition(CardCondition condition, long id){
        return ownedCardsRepository.findCardsByCondition(condition, id)
                .stream()
                .map(card -> mapToDTO(card, allCardsRepository))
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersGradedCards(boolean graded, long id){
        return ownedCardsRepository.findGradedCards(graded, id)
                .stream()
                .map(card -> mapToDTO(card, allCardsRepository))
                .collect(Collectors.toList());
    }

    public List<OwnedCardsDTO> getOwnersCardsByRating(int rating, long id){
        return ownedCardsRepository.findCardByRating(rating, id)
                .stream()
                .map(card -> mapToDTO(card, allCardsRepository))
                .collect(Collectors.toList());

    }

}
