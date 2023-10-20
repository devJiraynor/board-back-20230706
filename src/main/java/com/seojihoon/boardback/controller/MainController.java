package com.seojihoon.boardback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MainController {
    
    @GetMapping("")
    public ResponseEntity<String> serverCheck() {
        return ResponseEntity.status(HttpStatus.OK).body("Server On...");
    }

}
