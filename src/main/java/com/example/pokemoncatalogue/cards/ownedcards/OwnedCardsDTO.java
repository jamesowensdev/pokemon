package com.example.pokemoncatalogue.cards.ownedcards;

import com.example.pokemoncatalogue.cards.allcards.AllCardsDTO;
import com.example.pokemoncatalogue.util.enums.CardCondition;
import lombok.*;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class OwnedCardsDTO {
    private String cardId;
    private CardCondition condition;
    private boolean graded;
    private int rating;

    private AllCardsDTO card;

}
