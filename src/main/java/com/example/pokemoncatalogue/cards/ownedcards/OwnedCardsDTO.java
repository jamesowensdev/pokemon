package com.example.pokemoncatalogue.cards.ownedcards;

import com.example.pokemoncatalogue.util.enums.CardCondition;
import lombok.*;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class OwnedCardsDTO {
    private String cardId;
    private String cardName;
    private String set;
    private CardCondition condition;
    private boolean graded;
    private int rating;

}
