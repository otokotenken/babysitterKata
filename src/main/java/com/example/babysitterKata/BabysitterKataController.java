package com.example.babysitterKata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BabysitterKataController {

    @Autowired
    BabysitterKataService babysitterKataService;

    @RequestMapping(value = "/startTime", method = RequestMethod.POST)
    public ResponseEntity<String> validateStartTime() {
        return new ResponseEntity<>("Start Time Entered.", HttpStatus.ACCEPTED);
    }


}
