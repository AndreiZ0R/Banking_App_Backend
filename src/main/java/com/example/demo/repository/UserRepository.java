package com.example.demo.repository;

import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u")
    List<User> getAllUsers();

    @Query("SELECT u FROM User u WHERE u.idpers= :id")
    User getUserById(@Param(value = "id") int id);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Persoane(nume, adresa, gen, data_nasterii, email) " +
            "VALUES(:nume,:adresa,:gen, :data_nasterii, :email)",
            nativeQuery = true)
    void addNewUser(@Param("nume") String nume,
                    @Param("adresa") String adresa,
                    @Param("gen") char gen,
                    @Param("data_nasterii") Date data_nasterii,
                    @Param("email") String email);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Persoane WHERE idpers = :idpers",
            nativeQuery = true)
    void deleteUserById(@Param("idpers") int idpers);
}