package com.example.pokemoncatalogue.cards.sets;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class SetsDTO {
    private String setName;
    private String series;
    private int cardTotal;
    private LocalDate releaseDate;
    private String symbolImage;
}
