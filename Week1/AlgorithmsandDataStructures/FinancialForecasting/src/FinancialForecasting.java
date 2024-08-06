public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        // Base case: If years is 0, the future value is the initial value
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: Calculate the value for the previous year and apply growth rate
        return (1 + growthRate) * calculateFutureValue(initialValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial amount
        double growthRate = 0.05; // 5% growth rate
        int years = 5; // Forecast for 5 years

        // Calculate the future value
        double futureValue = calculateFutureValue(initialValue, growthRate, years);

        // Output the result
        System.out.printf("The future value after %d years is: %.2f\n", years, futureValue);
    }
}
