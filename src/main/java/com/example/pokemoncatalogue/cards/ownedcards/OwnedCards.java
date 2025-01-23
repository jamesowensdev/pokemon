package com.example.pokemoncatalogue.cards.ownedcards;

import com.example.pokemoncatalogue.util.ConditionEnum;
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
    private Long id;

    @Column(name = "owner", nullable = false)
    private Long ownerId;

    @Column(name = "card_name", nullable = false)
    private String cardText;

    @Column(name = "set", nullable = false)
    private String set;

    @Column(name = "card_no", nullable = false)
    private int cardNumber;

    @Column(name = "condition")
    private ConditionEnum condition;

    @Column(name = "graded", nullable = false)
    private boolean graded;

    @Column(name = "rating")
    private int rating;

}
