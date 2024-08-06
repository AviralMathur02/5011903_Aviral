public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create an instance of CustomerRepository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Create an instance of CustomerService with dependency injection
        CustomerService service = new CustomerService(repository);

        // Use the service to find a customer
        String customerDetails = service.getCustomerDetails(1);
        System.out.println(customerDetails);  // Output: Customer with ID 1
    }
}
