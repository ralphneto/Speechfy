package com.speechify;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;


public class UserService {
    private static final String DB_FILE = "db.json";
    private final ObjectMapper objectMapper;
    private ClientRepository clientRepository;

    public UserService() {
        this.objectMapper = new ObjectMapper();
    }

    public CompletableFuture<Boolean> addUser(
            String firstname,
            String surname,
            String email,
            LocalDate dateOfBirth,
            String clientId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                userRepository = new UserRepository();
                return userRepository.addUser(firstname,surname,email,dateOfBirth,clientId);
            } catch (IOException e) {
                return false;
            }
        });
    }

    public CompletableFuture<Boolean> updateUser(User user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                userRepository = new UserRepository();
                return userRepository.updateUser(user);
            } catch (IOException e) {
                return false;
            }
        });
    }

    public CompletableFuture<List<User>> getAllUsers() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                userRepository = new UserRepository();
                return userRepository.getAllUsers();
            } catch (IOException e) {
                return new ArrayList<>();
            }
        });
    }

    public CompletableFuture<User> getUserByEmail(String email) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                userRepository = new UserRepository();
                return userRepository.getUserByEmail(email);
            } catch (IOException e) {
                return new ArrayList<>();
            }
        });
    }
} 