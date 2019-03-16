
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class babysitterKataTest {
	
	private babysitterKata testObject;
	static final int START_TIME = 5;
	static final int END_TIME = 4;
	Family[] familyA;
	Family[] familyB;
	Family[] familyC;
	Family[] familyX;

	@BeforeEach
	public void setUp() {
		testObject = new babysitterKata();
		familyA = new Family[]{new Family(11, 15), new Family(4, 20)};
		familyB = new Family[] {new Family(10, 12), new Family(12, 8), new Family(4, 16)};
		familyC = new Family [] {new Family(9, 21), new Family(4, 15)};
		familyX = new Family[]{new Family(100, 95), new Family(23, 20)};
	}

	@Test
	public void shouldConvertTimeToAPostiveRangeShouldReturnZeroIfInputFive() {
		assertEquals(0, testObject.convertTimeToAPostiveRange(START_TIME));
	}

	@Test
	public void shouldConvertTimeToAPositiveRangeShouldReturnElevenIfInputFour() {
		assertEquals(11, testObject.convertTimeToAPostiveRange(END_TIME));
	}
	
	@Test 
	public void shouldConvertTImeToAPositiveRangeShouldReturnFiftyTwoIfInputFortyFive() {
		assertEquals(52, testObject.convertTimeToAPostiveRange(45));
	}
	
	@Test
	public void shouldReturnTrueStartTimeFivePmIsLessThanEleven() {
		assertTrue(testObject.validateStartTimeWithInRange(START_TIME));
	}
	

	@Test
	public void shouldReturnFalseStartTimeFourAmIsLessThanEleven() {
		assertFalse(testObject.validateStartTimeWithInRange(END_TIME));
	}
	
	@Test
	public void shouldReturnTrueIfEndTimeFourAmIsAfterStartTimeOfFivePm() {
		assertTrue(testObject.validateEndTimeWithInRange(END_TIME, START_TIME));
	}
	
	@Test
	public void shouldReturnFalseIfEndTimeSixPmIsAfterStartTimeOfFivePm() {
		assertFalse(testObject.validateEndTimeWithInRange(1, END_TIME));
	}
	
	@Test
	public void shouldReturnOneHundredAndNinetyWhenGivenFamilyAInput() {
		assertEquals(190, testObject.calculatePay(familyA));
	}
	
	@Test
	public void shouldReturnOneHundredAndFortyWhenGivenFamilyBInput() {
		assertEquals(140, testObject.calculatePay(familyB));
	}
	
	@Test
	public void shouldReturnOneHundredAndEightyNineWhenGivenFamilyCInput() {
		assertEquals(189, testObject.calculatePay(familyC));
	}
	
	
}
