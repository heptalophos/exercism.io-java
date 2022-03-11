public class SalaryCalculator {
    private static final double regularSalaryMultiplier = 1.0;
    private static final double daysSkippedPenaltyMultiplier = 0.85;
    private static final double baseSalary = 1000.0;
    private static final double maxSalary = 2000.0;
    private static final int maxAllowedSkippedDays = 5;
    private static final int productsSoldActivator = 20;
    private static final int extraBonus = 13;
    private static final int regularBonus = 10;
    
    public double multiplierPerDaysSkipped(int daysSkipped) {
        return daysSkipped > maxAllowedSkippedDays
               ? daysSkippedPenaltyMultiplier
               : regularSalaryMultiplier;
    }

    public int multiplierPerProductsSold(int productsSold) {
        return productsSold > productsSoldActivator
               ? extraBonus
               : regularBonus;
    }

    public double bonusForProductSold(int productsSold) {
        return productsSold * multiplierPerProductsSold(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        return Math.min( 
                baseSalary * multiplierPerDaysSkipped(daysSkipped) + 
                bonusForProductSold(productsSold),
                maxSalary
               );
    } 
}
