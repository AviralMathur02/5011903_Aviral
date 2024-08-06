public class FinancialForecasting2 {

    // Iterative method to calculate future value
    public static double calculateFutureValueIterative(double initialValue, double growthRate, int years) {
        double futureValue = initialValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial amount
        double growthRate = 0.05; // 5% growth rate
        int years = 5; // Forecast for 5 years

        // Calculate the future value using iterative method
        double futureValue = calculateFutureValueIterative(initialValue, growthRate, years);

        // Output the result
        System.out.printf("The future value after %d years is: %.2f\n", years, futureValue);
    }
}
