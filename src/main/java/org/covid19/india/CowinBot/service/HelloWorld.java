package org.covid19.india.CowinBot.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cowinbot")
public class HelloWorld {
    @GetMapping("/helloworld")
    public ResponseEntity<String> get() {
        return new ResponseEntity<>("Hello World!!", HttpStatus.OK);
    }

}
