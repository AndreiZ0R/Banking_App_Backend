package com.example.demo.service;

import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepo;

    @Autowired
    public CardService(CardRepository cardRepo) {
        this.cardRepo = cardRepo;
    }

    public List<Card> getAllCards() {
        return cardRepo.getAllCards();
    }

    public List<Card> getCardsByAccountNr(Long nr) {
        return cardRepo.getCardsByAccountNr(nr);
    }

    public Card getCardByNr(Long nr) {
        return cardRepo.getCardByNr(nr);
    }

    public void addCard(Card card) {
        cardRepo.addCard(card.getNrcard(),
                card.getData_de_la(),
                card.getData_la(),
                card.getLimita(),
                card.getNrcont(),
                card.getTip(),
                card.getCategorie());
    }

    public void deleteCardByNr(Long nr) {
        cardRepo.deleteCardByNr(nr);
    }
}
