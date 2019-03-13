package babysitterKata;

public class babysitterKata {
	
//	WORKING_START_TIME = 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calculate total pay, based on babysitter start and end time, and a family.
		}
	
	public int calculatePay() {
		return 1;
	}
	
	public Boolean determineIfWIthinWorkingHours() {
		return true;
	}
	
	public int convertTimeToAPostiveRange(int workingTime) {
		if (workingTime <= 12 && workingTime >= 5) {
			return workingTime - 5;
		} else
			return workingTime + 7;
	}
	
	public boolean validateStartTimeWithInRange(int startTime) {
		if (convertTimeToAPostiveRange(startTime) < 11) {
			return true;
		} else
			return false;
	}

}
