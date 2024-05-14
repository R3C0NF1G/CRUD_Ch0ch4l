package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.User;
import com.edu.unbosque.ch0ch4l.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        existingUser.setUsername(user.getUsername());
        existingUser.setPwd(user.getPwd());
        existingUser.setEmpleado(user.isEmpleado());
        existingUser.setAdmin(user.isAdmin());
        // Actualizar otros campos según sea necesario
        return userRepo.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
