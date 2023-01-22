package com.findmyguetto.findMyGuetto.service;

import com.findmyguetto.findMyGuetto.model.Role;
import com.findmyguetto.findMyGuetto.model.User;
import com.findmyguetto.findMyGuetto.respository.IUserRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

       @Autowired
       private IUserRespository userRespository;


       @Override
       public User saveUser(User user) throws Exception {
              if (userRespository.findByNomUtilisateur(user.getNomUtilisateur()).isPresent()){
                     throw new Exception("Utilisateur existe déja.");
              }
              user.setRole(Role.USER);
              return userRespository.save(user);
       }

       @Override
       public Optional<User> signIn(User user) throws Exception {
              if (!userRespository.findByNomUtilisateur(user.getNomUtilisateur()).isPresent() || !userRespository.findByNomUtilisateur(user.getNomUtilisateur()).get().getPassword().equals(user.getPassword())){
                     throw new Exception("Nom d'utilisateur ou mot de passe incorrect.");
              }

              return userRespository.signIn(user.getNomUtilisateur());
       }

       @Override
       @Transactional
       public void makeAdmin(String nomUtilisateur) throws Exception {

              if (!userRespository.findByNomUtilisateur(nomUtilisateur).isPresent()){
                     throw new Exception("Cet utilisateur n'existe pas.");
              }

              userRespository.makeAdmin(nomUtilisateur,Role.ADMIN);
       }


}
