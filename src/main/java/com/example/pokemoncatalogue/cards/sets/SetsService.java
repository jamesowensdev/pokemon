package com.example.pokemoncatalogue.cards.sets;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetsService {
    private final SetsRepository repository;

    public SetsService(SetsRepository repository){
        this.repository = repository;
    }

    private SetsDTO mapToDTO(Sets set){
        return new SetsDTO(
          set.getName(),
          set.getSeries(),
          set.getCardTotal(),
          set.getReleaseDate(),
          set.getSymbolImage()
        );
    }

    public List<SetsDTO> getAllSets(){
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
