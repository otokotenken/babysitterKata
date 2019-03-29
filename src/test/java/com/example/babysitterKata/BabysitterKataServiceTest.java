package com.example.babysitterKata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BabysitterKataServiceTest {

    @InjectMocks
    BabysitterKataService babysitterKataService;

    private static final int START_TIME = 5;
    private static final int END_TIME = 4;
    Family[] familyA;
    Family[] familyB;
    Family[] familyC;

    @Before
    public void setUp() {
        familyA = new Family[]{new Family(5, 11, 15), new Family(5, 4, 20)};
        familyB = new Family[] {new Family(5, 10, 12), new Family(5,12, 8), new Family(5, 4, 16)};
        familyC = new Family[] {new Family(5, 9, 21), new Family(5, 4, 15)};
    }

    @Test
    public void shouldConvertTimeToAPostiveRangeShouldReturnZeroIfInputFive() {
        assertEquals(0, babysitterKataService.convertTimeToAPostiveRange(familyA[0].payShiftStartTime));
    }

    @Test
    public void shouldConvertTimeToAPositiveRangeShouldReturnElevenIfInputFour() {
        assertEquals(11, babysitterKataService.convertTimeToAPostiveRange(END_TIME));
    }

    @Test
    public void shouldReturnTrueStartTimeFivePmIsWithInAvailabilityRAngeOfShiftStarting() {
        assertTrue(babysitterKataService.validateStartTimeWithInRange(START_TIME));
    }

    @Test
    public void shouldReturnFalseStartTimeFourAmIsAfterAvailabilityRangeOfShiftStarting() {
        assertFalse(babysitterKataService.validateStartTimeWithInRange(END_TIME));
    }

    @Test
    public void shouldReturnTrueIfEndTimeFourAmIsAfterStartTimeOfFivePm() {
        assertTrue(babysitterKataService.validateEndTimeWithInRange(END_TIME, START_TIME));
    }

    @Test
    public void shouldReturnFalseIfEndTimeSixPmIsAfterStartTimeOfFivePm() {
        assertFalse(babysitterKataService.validateEndTimeWithInRange(1, END_TIME));
    }

    @Test
    public void shouldReturnOneHundredAndNinetyWhenGivenFamilyAInput() {
        assertEquals(190, babysitterKataService.calculatePay(familyA));
    }

    @Test
    public void shouldReturnOneHundredAndFortyWhenGivenFamilyBInput() {
        assertEquals(140, babysitterKataService.calculatePay(familyB));
    }

    @Test
    public void shouldReturnOneHundredAndEightyNineWhenGivenFamilyCInput() {
        assertEquals(189, babysitterKataService.calculatePay(familyC));
    }

}