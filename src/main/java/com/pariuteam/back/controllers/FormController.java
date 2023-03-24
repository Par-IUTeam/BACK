package com.pariuteam.back.controllers;

import com.pariuteam.back.requestBodies.FormBody;
import com.pariuteam.back.services.FormService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/forms")
public class FormController {
    @Autowired
    private FormService formService;
    @PostMapping
    private ResponseEntity<FormBody> registerForm(@Valid FormBody formBody){
        return ResponseEntity.ok().body(formService.registerForm(formBody));
    }
}
