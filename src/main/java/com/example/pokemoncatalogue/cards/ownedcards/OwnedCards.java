package com.example.pokemoncatalogue.cards.ownedcards;

import com.example.pokemoncatalogue.util.enums.CardCondition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "owned_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OwnedCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owned_card_id", nullable = false, unique = true)
    private long id;

    @Column(name = "card_id", nullable = false)
    private String cardId;

    @Column(name = "owner", nullable = false)
    private long ownerId;

    @Column(name = "condition")
    private CardCondition condition;

    @Column(name = "graded", nullable = false)
    private boolean graded;

    @Column(name = "rating")
    private int rating;

}
