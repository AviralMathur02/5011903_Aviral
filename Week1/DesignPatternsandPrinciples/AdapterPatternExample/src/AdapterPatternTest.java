public class AdapterPatternTest {
    public static void main(String[] args) {
        // Using Stripe for payment
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(100.00);

        // Using PayPal for payment
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        payPalProcessor.processPayment(200.00);
    }
}
