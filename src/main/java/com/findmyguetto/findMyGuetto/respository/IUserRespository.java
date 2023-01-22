package com.findmyguetto.findMyGuetto.respository;

import com.findmyguetto.findMyGuetto.model.Role;
import com.findmyguetto.findMyGuetto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRespository extends JpaRepository<User,Long> {

       Optional<User> findByNomUtilisateur(String prenom);

       @Modifying
       @Query("update User set role= :role where nomUtilisateur= :nomUtilisateur")
       void makeAdmin(@Param("nomUtilisateur") String nomUtilisateur , @Param("role") Role role);

       @Query(value = "select id_user , password, nom, nom_utilisateur , role, phone_number from user where nom_utilisateur = :prenom",nativeQuery = true)
       Optional<User> signIn(@Param("prenom") String prenom);
}
