package com.example.pokemoncatalogue.cards.sets;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "sets")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sets {
    @Id
    @Column(name = "set_id")
    private String id;

    @Column(name = "set_name", nullable = false)
    private String name;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "card_total", nullable = false)
    private int cardTotal;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "symbol_image_link", nullable = false)
    private String symbolImage;

}
