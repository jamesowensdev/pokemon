package com.example.pokemoncatalogue.cards.allcards;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "all_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AllCards {

    @Id
    @Column(name = "card_id", nullable = false)
    private String id;

    @Column(name = "card_name", nullable = false)
    private String cardName;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "set_name", nullable = false)
    private String setName;

    @Column(name = "rarity", nullable = false)
    private String rarity;

    @Column(name = "card_image_link", nullable = false)
    private String imageLink;




}
