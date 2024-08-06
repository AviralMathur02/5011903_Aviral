public class InventoryManagerTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Adding products
        manager.addProduct(new Product(1, "Laptop", 10, 999.99));
        manager.addProduct(new Product(2, "Smartphone", 20, 499.99));

        // Display all products
        manager.displayAllProducts();

        // Update a product
        manager.updateProduct(1, new Product(1, "Laptop", 15, 949.99));

        // Get and display updated product
        System.out.println(manager.getProduct(1));

        // Delete a product
        manager.deleteProduct(2);

        // Display all products after deletion
        manager.displayAllProducts();
    }
}
