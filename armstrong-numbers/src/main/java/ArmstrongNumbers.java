class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {

		int num = numberToCheck;
		int len = String.valueOf(num).length();
		int sum = 0;
		while (num > 0) {
			sum += Math.pow(num % 10, len);
			num /= 10; 
		}
		return sum == numberToCheck;
	}
}

