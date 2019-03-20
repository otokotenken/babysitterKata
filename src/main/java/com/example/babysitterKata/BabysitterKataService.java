package com.example.babysitterKata;


import org.springframework.stereotype.Service;

@Service
public class BabysitterKataService {

    public int calculatePay(Family[] family) {
        int paymentTotal = 0;
        int previousTime = 0;
        for (Family session : family) {
            int convertedTIme = convertTimeToAPostiveRange(session.payShiftEndTime) - previousTime;
            paymentTotal += session.payRate * convertedTIme;
            previousTime += convertedTIme;
        }
        return paymentTotal;
    }

    public int convertTimeToAPostiveRange(int workingTime) {
        if (workingTime <= 12 && workingTime >= 5) {
            return workingTime - 5;
        } else {
            return workingTime + 7;
        }
    }

    public boolean validateStartTimeWithInRange(int startTime) {
        if (convertTimeToAPostiveRange(startTime) < 11) {
            return true;
        } else
            return false;
    }

    public boolean validateEndTimeWithInRange(int endTime, int startTime) {
        if (convertTimeToAPostiveRange(endTime) > convertTimeToAPostiveRange(startTime)) {
            return true;
        } else
            return false;
    }

}
