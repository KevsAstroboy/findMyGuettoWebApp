package com.findmyguetto.findMyGuetto.service;

import com.findmyguetto.findMyGuetto.model.TypeMarker;
import com.findmyguetto.findMyGuetto.respository.ITypeMarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeMarkerService implements ITypeMarkerService{

       @Autowired
       private ITypeMarkerRepository typeMarkerRepository;

       @Override
       public TypeMarker saveTypeMarker(TypeMarker typeMarker) throws Exception {

              if (typeMarkerRepository.findByTypeIntitule(typeMarker.getTypeIntitule()).isPresent()){
                  throw new Exception("Ce type de marker existe déja.");
              }
              return typeMarkerRepository.save(typeMarker);
       }
       @Override
       public List<TypeMarker> getAllTypeOfMarker(){
           return typeMarkerRepository.findAll();
       }
}
