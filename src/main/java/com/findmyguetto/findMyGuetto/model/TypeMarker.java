package com.findmyguetto.findMyGuetto.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "type_marker")
@Data
public class TypeMarker {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name = "id_type_marker")
       private Long id;

       @Column(name = "typeIntitule")
       private String typeIntitule;




}
