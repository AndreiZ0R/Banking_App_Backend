package com.example.demo.repository;

import com.example.demo.model.Moving;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MovingRepository extends JpaRepository<Moving, Long> {

    @Query("SELECT m FROM Moving m")
    List<Moving> getAllMovings();

    @Query("SELECT m FROM Moving m WHERE m.nrcard = :nrcard")
    List<Moving> getMovingsByCardNr(@Param("nrcard") Long nrcard);

    @Query("SELECT m FROM Moving m WHERE m.scop = :scop")
    List<Moving> getMovingsByPurpose(@Param("scop") String scop);

    @Query(value = "CALL between_vals(:lower, :upper)", nativeQuery = true)
    List<Moving> getMovingsBetweenValues(@Param("lower") double lower, @Param("upper") double upper);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Miscari(nrcard, data_ora, valoare, scop) " +
            "VALUES(:nrcard, :data_ora, :valoare, :scop)",
            nativeQuery = true)
    void addMoving(@Param("nrcard") Long nrcard,
                   @Param("data_ora") Timestamp data_ora,
                   @Param("valoare") double valoare,
                   @Param("scop") String scop);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Miscari WHERE nrcard = :nrcard AND valoare = :valoare AND scop = :scop", nativeQuery = true)
    void deleteMovingByCardNrValuePurpose(@Param("nrcard") Long nrcard,
                                          @Param("valoare") double valoare,
                                          @Param("scop") String scop);
}
