package com.findmyguetto.findMyGuetto.respository;

import com.findmyguetto.findMyGuetto.model.TypeMarker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITypeMarkerRepository extends JpaRepository<TypeMarker,Long> {

      Optional<TypeMarker> findByTypeIntitule(String typeMarker);
}
