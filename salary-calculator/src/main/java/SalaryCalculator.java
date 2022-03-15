public class SalaryCalculator {
    private static final double regularSalary = 1.0;
    private static final double daysSkippedPenalty = 0.85;
    private static final double baseSalary = 1000.0;
    private static final double maxSalary = 2000.0;
    private static final int maxAllowedSkippedDays = 5;
    private static final int bonusActivator = 20;
    private static final int extraBonus = 13;
    private static final int regularBonus = 10;
    
    public double multiplierPerDaysSkipped(int daysSkipped) {
        return daysSkipped > maxAllowedSkippedDays
               ? daysSkippedPenalty
               : regularSalary;
    }

    public int multiplierPerProductsSold(int productsSold) {
        return productsSold > bonusActivator
               ? extraBonus
               : regularBonus;
    }

    public double bonusForProductSold(int productsSold) {
        return productsSold * multiplierPerProductsSold(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double finalSalary = 
            baseSalary * multiplierPerDaysSkipped(daysSkipped) + 
            bonusForProductSold(productsSold);
        return Math.min(finalSalary, maxSalary);
    } 
}
