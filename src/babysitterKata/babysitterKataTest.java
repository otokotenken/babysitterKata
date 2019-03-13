package babysitterKata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class babysitterKataTest {
	
	private babysitterKata testObject;
	static final int START_TIME = 5;
	static final int END_TIME = 4;
	
//	@Before
//	public void executedBeforeEachTest() {
//		testObject = new babysitterKata();
//	}
	
	@BeforeEach
	public void setUp() {
		testObject = new babysitterKata();
	}
	
	@Test
	public void calculateTotalPayShouldReturnOne() {
		assertEquals(1, testObject.calculatePay());
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
	public void shouldConvertTimeToAPositiveRangeShouldReturnElevenIfInputSix() {
		assertEquals(1, testObject.convertTimeToAPostiveRange(6));
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
	
}
