package com.findmyguetto.findMyGuetto.service;

import com.findmyguetto.findMyGuetto.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user) throws Exception;

    Optional<User> signIn(User user) throws Exception;

    void makeAdmin(String prenom) throws Exception;
}
