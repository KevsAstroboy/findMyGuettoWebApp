package com.findmyguetto.findMyGuetto.respository;

import com.findmyguetto.findMyGuetto.model.Marker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMarkerRepository extends JpaRepository<Marker,Long> {

       @Query(value = "Select * from marker a left join type_marker b on a.type_marker_id = b.id_type_marker where b.type_intitule = :typeIntitule AND a.statut = :status",nativeQuery = true)
       List<Marker> findAllMarkerByType(@Param("typeIntitule") String intituleTypeMarker,@Param("status") Boolean status);

       @Query("Update Marker set status = :status where id = :idMarker")
       void updateMarkerStatus(@Param("idMarker") Long idMarker, @Param("status") Boolean status);

}
