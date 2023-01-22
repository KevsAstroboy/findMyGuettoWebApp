package com.findmyguetto.findMyGuetto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "marker")
@Data
public class Marker {

       @Id
       @Column(name = "id_marker")
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       @Column(name = "description",length = 255)
       private String description;

       @Column(name = "longitude")
       private Double longitude;

       @Column(name = "latitude")
       private Double latitude;

       @Column(name = "dateTime")
       private LocalDateTime dateTime;

       @Column(name = "statut")
       private Boolean status;

       @ManyToOne
       @JoinColumn(name = "user_id",referencedColumnName = "id_user")
       private User user;

       @ManyToOne
       @JoinColumn(name = "type_marker_id",referencedColumnName = "id_type_marker")
       private TypeMarker typeMarker;

       @Transient
       private Long idTypeMarker;

       @Transient
       private Long idUser;
}
