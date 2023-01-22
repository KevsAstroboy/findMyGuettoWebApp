package com.findmyguetto.findMyGuetto.controller;

import com.findmyguetto.findMyGuetto.model.Error;
import com.findmyguetto.findMyGuetto.model.Marker;
import com.findmyguetto.findMyGuetto.service.IMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("api/marker")
public class MarkerController {

       @Autowired
       private IMarkerService markerService;

       @PostMapping("add-marker")
       public ResponseEntity<?> saveMarker(@RequestBody Marker marker){

              ResponseEntity<Object> response = null;

              try {
                  response = ResponseEntity.status(HttpStatus.CREATED).body(markerService.saveMarker(marker));
              } catch (Exception e) {
                  response = ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(true,e.getMessage()));
              }

              return response;
       }

       @GetMapping("{typeMarker}")
       public ResponseEntity<?> getAllMarkerByType(@PathVariable("typeMarker") String typeMarker){

        ResponseEntity<Object> response = null;

        try {
            response = ResponseEntity.status(HttpStatus.OK).body(markerService.getAllMarkerByType(typeMarker));
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(true,e.getMessage()));
        }

        return response;
       }


       @PutMapping("{idMarker}/{idUser}")
       public ResponseEntity<?> updateMarkerStatus(@PathVariable("idMarker") Long idMarker, @PathVariable("idUser") Long idUser){

        ResponseEntity<Object> response = null;

        try {
            markerService.updateMarkerStatus(idMarker,idUser);
            response = ResponseEntity.status(HttpStatus.CREATED).body(new Error(false,"Opérartion effectuée."));
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(true,e.getMessage()));
        }

        return response;
        }



}
