package com.example.babysitterKata;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;


@Controller
public class BabysitterKataController {

    @Autowired
    BabysitterKataService babysitterKataService;

    @RequestMapping(value = "job", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> validateJob(@RequestBody Family[] family) {
        for (Family session : family) {
           if(!babysitterKataService.validateStartTimeWithInRange(session.getPayShiftStartTime())) {
               throw new ResponseStatusException(
                       HttpStatus.BAD_REQUEST);
           }
        if(!babysitterKataService.validateEndTimeWithInRange(session.getPayShiftEndTime(), session.getPayShiftStartTime())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST);
        }
        }
        babysitterKataService.calculatePay(family);
        return new ResponseEntity<>("Job Accepted", HttpStatus.ACCEPTED) ;
    }


}
