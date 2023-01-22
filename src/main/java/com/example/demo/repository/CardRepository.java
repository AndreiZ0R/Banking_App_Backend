package com.example.demo.repository;

import com.example.demo.model.Card;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT c FROM Card c")
    List<Card> getAllCards();

    @Query("SELECT c FROM Card c WHERE c.nrcont = :nrcont")
    List<Card> getCardsByAccountNr(@Param(value = "nrcont") Long nrcont);

    @Query("SELECT c FROM Card c WHERE c.nrcard = :nrcard")
    Card getCardByNr(@Param(value = "nrcard") Long nrcard);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Carduri(nrcard, data_de_la, data_la, limita, nrcont, tip, categorie) " +
            "VALUES(:nrcard, :data_de_la, :data_la, :limita, :nrcont, :tip, :categorie)",
            nativeQuery = true)
    void addCard(@Param("nrcard") Long nrcard,
                 @Param("data_de_la") Date data_de_la,
                 @Param("data_la") Date data_la,
                 @Param("limita") double limita,
                 @Param("nrcont") Long nrcont,
                 @Param("tip") String tip,
                 @Param("categorie") String categorie);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Carduri WHERE nrcard = :nrcard", nativeQuery = true)
    void deleteCardByNr(@Param("nrcard") Long nrcard);
}
