package com.findmyguetto.findMyGuetto.controller;

import com.findmyguetto.findMyGuetto.model.Error;
import com.findmyguetto.findMyGuetto.model.User;
import com.findmyguetto.findMyGuetto.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/user/")
public class UserController {

    @Autowired
    private IUserService userService;


    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user){

           ResponseEntity<Object> response = null;

           try {
               response = ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
           }catch (Exception e){

               response = ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(true,e.getMessage()));
           }

        return response;
    }
    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user){

           ResponseEntity<Object> response = null;

           try{
               response = ResponseEntity.status(HttpStatus.OK).body(userService.signIn(user));
           } catch (Exception e) {
               response = ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(true,e.getMessage()));
           }

           return  response;
    }

    @PutMapping("make-admin/{nomUtilisateur}")
    public ResponseEntity<?> makeAdmin(@PathVariable("nomUtilisateur") String nomUtilisateur){

          ResponseEntity<Object> response = null;

          try {
              userService.makeAdmin(nomUtilisateur);
              response = ResponseEntity.status(HttpStatus.OK).body(new Error(false,"Opération effectuée."));
          } catch (Exception e) {
              response = ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(true,e.getMessage()));
          }

        return  response;
    }
}
