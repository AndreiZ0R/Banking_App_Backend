package com.example.demo.controller;


import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("account_number={accNr}")
    List<Card> getCardsByAccountNr(@PathVariable(value = "accNr") Long accNr) {
        return cardService.getCardsByAccountNr(accNr);
    }

    @GetMapping("/{nrcard}")
    Card getCardByNumber(@PathVariable(value = "nrcard") Long nrCard) {
        return cardService.getCardByNr(nrCard);
    }

    @PostMapping(consumes = "application/json")
    void addCard(@RequestBody Card card) {
        cardService.addCard(card);
    }

    @DeleteMapping("/{nr}")
    void deleteCardByNr(@PathVariable("nr") Long nr) {
        cardService.deleteCardByNr(nr);
    }
}