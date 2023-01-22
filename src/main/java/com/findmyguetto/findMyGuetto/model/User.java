package com.findmyguetto.findMyGuetto.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "user")
@Data
public class User {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name = "id_user")
       private Long id;

       @Column(name = "nom",length = 100,nullable = false)
       private String nom;

       @Column(name = "nom_utilisateur",length = 100,nullable = false)
       private String nomUtilisateur;

       @Column(name = "password",length = 100,nullable = false)
       private String password;

       @Enumerated(value = EnumType.STRING)
       private Role role;

       @Column(name = "phone_number",length = 10)
       private String phoneNumber;
}
