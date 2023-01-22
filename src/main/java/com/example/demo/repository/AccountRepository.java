package com.example.demo.repository;

import com.example.demo.model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a")
    List<Account> getAllAccounts();

    @Query("SELECT a FROM Account a WHERE a.idpers = :idpers")
    List<Account> getAccountByUserId(@Param(value = "idpers") int idpers);

    @Query("SELECT a from Account a WHERE a.nrcont = :nr")
    Account getAccountByNumber(@Param(value = "nr") Long nr);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Conturi(nrcont, sold, idpers) VALUES(:nrcont, :sold, :idpers)",
            nativeQuery = true)
    void addAccount(@Param("nrcont") Long nrcont,
                    @Param("sold") double sold,
                    @Param("idpers") int idpers);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Conturi WHERE nrcont = :nrcont",
            nativeQuery = true)
    void deleteAccountByNumber(@Param("nrcont") Long nrcont);
}
