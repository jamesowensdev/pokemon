package com.example.pokemoncatalogue.cards;

import com.example.pokemoncatalogue.cards.allcards.AllCards;
import com.example.pokemoncatalogue.cards.allcards.AllCardsRepository;
import com.example.pokemoncatalogue.cards.sets.Sets;
import com.example.pokemoncatalogue.cards.sets.SetsRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DataImportService {

    private final SetsRepository setRepository;
    private final AllCardsRepository cardRepository;

    @Autowired
    public DataImportService(SetsRepository setRepository, AllCardsRepository cardRepository) {
        this.setRepository = setRepository;
        this.cardRepository = cardRepository;
    }

    public void importSetData(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);

        String setId = rootNode.get("id").asText();
        String setName = rootNode.get("name").asText();
        String series = rootNode.get("series").asText();
        int cardTotal = rootNode.get("total").asInt();
        String releaseDate = rootNode.get("releaseDate").asText();
        String symbolImageLink = rootNode.get("images").get("symbol").asText();


        Sets set = new Sets();
        set.setId(setId);
        set.setName(setName);
        set.setSeries(series);
        set.setCardTotal(cardTotal);
        set.setReleaseDate(LocalDate.parse(releaseDate));
        set.setSymbolImage(symbolImageLink);


        setRepository.save(set);
    }

    public void importCardData(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);


        String cardId = rootNode.get("id").asText();
        String cardName = rootNode.get("name").asText();
        String cardType = rootNode.get("supertype").asText();
        String rarity = rootNode.get("rarity").asText();
        String cardImageLink = rootNode.get("images").get("large").asText();


        String setId = cardId.split("-")[0];


        Sets set = setRepository.findById(setId)
                .orElseThrow(() -> new RuntimeException("Set not found for ID: " + setId));


        AllCards card = new AllCards();
        card.setId(cardId);
        card.setSetId(setId);
        card.setRarity(rarity);
        card.setImageLink(cardImageLink);

        cardRepository.save(card);
    }
}