package com.findmyguetto.findMyGuetto.service;

import com.findmyguetto.findMyGuetto.model.Marker;
import com.findmyguetto.findMyGuetto.model.Role;
import com.findmyguetto.findMyGuetto.respository.IMarkerRepository;
import com.findmyguetto.findMyGuetto.respository.ITypeMarkerRepository;
import com.findmyguetto.findMyGuetto.respository.IUserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MarkerSerice implements IMarkerService{

       @Autowired
       private IMarkerRepository markerRepository;

       @Autowired
       private ITypeMarkerRepository typeMarkerRepository;

       @Autowired
       private IUserRespository userRespository;

       @Override
       public Marker saveMarker(Marker marker) throws Exception {
              if (!typeMarkerRepository.findById(marker.getIdTypeMarker()).isPresent()){
                     throw new Exception("Ce marker n'appartient à aucun type.");
              }
              if (!userRespository.findById(marker.getIdUser()).isPresent()){
                  throw new Exception("Cet utilisateur n'existe pas.");
              }
              if (marker.getLongitude()==null || marker.getLatitude()==null){
                     throw new Exception("Ce marker ne peut etre ajouté.");
              }
              marker.setDateTime(LocalDateTime.now());
              marker.setTypeMarker(typeMarkerRepository.findById(marker.getIdTypeMarker()).get());
              marker.setUser(userRespository.findById(marker.getIdUser()).get());
              marker.setStatus(Boolean.FALSE);
              return markerRepository.save(marker);
       }

       @Override
       public List<Marker> getAllMarkerByType(String typeMarker) throws Exception {
              if (!typeMarkerRepository.findByTypeIntitule(typeMarker).isPresent()){
                     throw new Exception("Ce type de marker n'existe pas.");
              }

              return markerRepository.findAllMarkerByType(typeMarker,Boolean.TRUE);
       }
       @Override
       public void updateMarkerStatus(Long idMarker, Long idUser) throws Exception {
              if (!markerRepository.findById(idMarker).isPresent()){
                     throw new Exception("Ce marker n'existe pas.");
              }
              if (!userRespository.findById(idUser).isPresent()){
                     throw new Exception("Cet utilisateur n'existe pas.");
              }
              if (userRespository.findById(idUser).get().getRole().equals(Role.ADMIN)){
                     markerRepository.updateMarkerStatus(idMarker,Boolean.TRUE);
              }else {
                     throw new Exception("Opération echouée.");
              }

       }



}
