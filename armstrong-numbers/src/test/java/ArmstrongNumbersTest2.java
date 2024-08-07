import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArmstrongNumbersTest2 {

    private ArmstrongNumbers2 armstrongNumbers;

    @Before
    public void setup() {
        armstrongNumbers = new ArmstrongNumbers2();
    }

    @Test
    public void singleDigitsAreArmstrongNumbers2() {
        int input = 5;

        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    // @Ignore("Remove to run test")
    @Test
    public void noTwoDigitArmstrongNumbers2() {
        int input = 10;

        assertFalse(armstrongNumbers.isArmstrongNumber(input));
    }

    // @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsArmstrongNumber2() {
        int input = 153;
        
        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    // @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsNotArmstrongNumber2() {
        int input = 100;
        
        assertFalse(armstrongNumbers.isArmstrongNumber(input));
    }

    // @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsArmstrongNumber2() {
        int input = 9474;
        
        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    // @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsNotArmstrongNumber2() {
        int input = 9475;
        
        assertFalse(armstrongNumbers.isArmstrongNumber(input));
    }

    // @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsArmstrongNumber2() {
        int input = 9926315;
        
        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    // @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsNotArmstrongNumber2() {
        int input = 9926314;
        
        assertFalse(armstrongNumbers.isArmstrongNumber(input));
    }
}
