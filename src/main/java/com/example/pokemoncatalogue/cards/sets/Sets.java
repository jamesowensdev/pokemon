package com.example.pokemoncatalogue.cards.sets;

import com.example.pokemoncatalogue.util.ConditionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


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
    private String setName;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "card_total", nullable = false)
    private String cardTotal;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "symbol_image_link", nullable = false)
    private String symbolImage;

}
