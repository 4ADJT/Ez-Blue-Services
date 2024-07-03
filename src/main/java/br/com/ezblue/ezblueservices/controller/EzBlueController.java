package br.com.ezblue.ezblueservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class EzBlueController {

    @GetMapping
    public ResponseEntity<String> location() {
        return ResponseEntity.ok("EzBlueServices");
    }

}
