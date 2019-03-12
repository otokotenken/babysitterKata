package babysitterKata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class babysitterKataTest {
	
	private babysitterKata testObject;
	
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
		assertEquals(0, testObject.convertTimeToAPostiveRange(5));
	}

	@Test
	public void shouldConvertTimeToAPositiveRangeShouldReturnElevenIfInputFour() {
		assertEquals(11, testObject.convertTimeToAPostiveRange(4));
	}
	
}
