package com.example.pokemoncatalogue.cards.allcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllCardsService {

    private final AllCardsRepository repository;

    @Autowired
    public AllCardsService(AllCardsRepository repository) {
        this.repository = repository;
    }

    public List<AllCardsDTO> getAllCards() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AllCardsDTO getCardById(String id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public List<AllCardsDTO> getCardsByType(String cardType) {
        return repository.findByCardType(cardType)
                .stream()
                .map(this::mapToDTO)
                .collect((Collectors.toList()));
    }

    public List<AllCardsDTO> getCardsByName(String cardName){
        return repository.findByCardName(cardName)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AllCardsDTO> getCardsBySet(String setName){
        return  repository.findBySetName(setName)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AllCardsDTO> getCardsByRarity(String rarity){
        return  repository.findByRarity(rarity)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private AllCardsDTO mapToDTO(AllCards card) {
        return new AllCardsDTO(
                card.getId(),
                card.getCardName(),
                card.getCardType(),
                card.getSetId(),
                card.getRarity(),
                card.getImageLink()
        );
    }

}
