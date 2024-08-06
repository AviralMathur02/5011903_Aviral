public class CustomerService {
    private CustomerRepository repository;

    // Constructor injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomerDetails(int id) {
        return repository.findCustomerById(id);
    }
}
