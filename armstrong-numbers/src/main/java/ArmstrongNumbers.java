class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {

		String numberString = String.valueOf(numberToCheck);
		
		int sumDigitPowers = 
			numberString.chars()
			.map(Character::getNumericValue)
			.map(x -> (int) Math.pow(x, numberString.length()))
			.sum();

		return sumDigitPowers == numberToCheck;
	}
}

