package com.example.pokemoncatalogue.cards.ownedcards;


import com.example.pokemoncatalogue.util.enums.CardCondition;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mycards")
public class OwnedCardsController {
    private final OwnedCardsService service;

    public OwnedCardsController(OwnedCardsService service){
        this.service = service;
    }

    public List<OwnedCardsDTO> getAllOwnersCards(@PathVariable long id){
        return service.getAllCardsByOwner(id);
    }

    public List<OwnedCardsDTO> getOwnersCardsByName(@PathVariable String cardName, @PathVariable long id){
        return service.getOwnersCardsByName(cardName, id);
    }

    public List<OwnedCardsDTO> getOwnersCardsBySet(@PathVariable String set, @PathVariable long id){
        return service.getOwnersCardsBySet(set, id);
    }

    public List<OwnedCardsDTO> getOwnersCardsByCondition(@PathVariable CardCondition condition, @PathVariable long id){
        return service.getOwnersCardsByCondition(condition, id);
    }

    public List<OwnedCardsDTO> getOwnersGradedCards(@PathVariable boolean graded, @PathVariable long id){
        return service.getOwnersGradedCards(graded, id);
    }

    public List<OwnedCardsDTO> getOwnersCardsByRating(@PathVariable int rating, @PathVariable long id){
        return service.getOwnersCardsByRating(rating, id);
    }


}
