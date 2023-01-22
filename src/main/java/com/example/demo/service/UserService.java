package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }

    public void addNewUser(User user) {
        userRepo.addNewUser(user.getNume(),
                user.getAdresa(),
                user.getGen(),
                user.getData_nasterii(),
                user.getEmail());
    }

    public void deleteUserById(int idpers) {
        userRepo.deleteUserById(idpers);
    }
}
