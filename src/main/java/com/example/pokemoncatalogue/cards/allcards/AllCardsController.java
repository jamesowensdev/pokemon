package com.example.pokemoncatalogue.cards.allcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class AllCardsController {

    private final AllCardsService service;

    @Autowired
    public AllCardsController(AllCardsService service) {
        this.service = service;
    }

    @GetMapping
    public List<AllCardsDTO> getAllCards() {
        return service.getAllCards();
    }

    @GetMapping("/{id}")
    public AllCardsDTO getCardById(@PathVariable String id) {
        return service.getCardById(id);
    }

    @GetMapping("/type/{cardType}")
    public List<AllCardsDTO> getCardsByType(@PathVariable String cardType) {
        return service.getCardsByType(cardType);
    }

    @GetMapping("/set/{setName}")
    public List<AllCardsDTO> getCardsBySet(@PathVariable String setName){
        return service.getCardsBySet(setName);
    }

    @GetMapping("/name/{cardName}")
    public List<AllCardsDTO> getCardsByName(@PathVariable String cardName){
        return service.getCardsByName(cardName);
    }

    @GetMapping("/rarity/{rarity}")
    public List<AllCardsDTO> getCardsByRarity(@PathVariable String rarity){
        return service.getCardsByRarity(rarity);
    }


}
