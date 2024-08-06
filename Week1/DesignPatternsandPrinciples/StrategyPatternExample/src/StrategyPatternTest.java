public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(150.0);

        // Pay using PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("user@example.com");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200.0);
    }
}
