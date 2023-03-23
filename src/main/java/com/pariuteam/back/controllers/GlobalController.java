package com.pariuteam.back.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GlobalController {

    @PostMapping("error")
    public ResponseEntity<String> badRequest(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
    }

}
