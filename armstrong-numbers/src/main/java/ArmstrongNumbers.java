public class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {

		String num = String.valueOf(numberToCheck);
		
		int len = num.length();
		
		int sum = num
				  .chars()
				  .map(Character::getNumericValue)
				  .map(x -> (int) Math.pow(x, len))
				  .sum();

		return sum == numberToCheck;
	}
}

