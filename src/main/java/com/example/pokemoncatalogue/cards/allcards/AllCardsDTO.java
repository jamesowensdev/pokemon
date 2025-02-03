package com.example.pokemoncatalogue.cards.allcards;

import lombok.*;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class AllCardsDTO {
    private final String id;
    private final String cardName;
    private final String cardType;
    private final String setId;
    private final String rarity;
    private final String imageLink;
}