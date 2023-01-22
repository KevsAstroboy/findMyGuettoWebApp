package com.findmyguetto.findMyGuetto.controller;

import com.findmyguetto.findMyGuetto.model.Error;
import com.findmyguetto.findMyGuetto.model.TypeMarker;
import com.findmyguetto.findMyGuetto.service.ITypeMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("api/type-marker")
public class TypeMarkerController {

       @Autowired
       private ITypeMarkerService typeMarkerService;


       @PostMapping("add")
        public ResponseEntity<?> saveTypeMarker(@RequestBody TypeMarker typeMarker){

               ResponseEntity<Object> response = null;

               try {
                   response = ResponseEntity.status(HttpStatus.CREATED).body(typeMarkerService.saveTypeMarker(typeMarker));
               } catch (Exception e) {
                    response = ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(true,e.getMessage()));
               }

               return response;
        }

        @GetMapping("getAll")
        public ResponseEntity<?> getAllTypeMarker(){

            ResponseEntity<Object> response = null;

            try {
                response = ResponseEntity.status(HttpStatus.CREATED).body(typeMarkerService.getAllTypeOfMarker());
            } catch (Exception e) {
                response = ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(true,e.getMessage()));
            }

            return response;
        }
}
