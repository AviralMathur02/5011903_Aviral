import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithms {

    // Linear search implementation
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }

    // Binary search implementation
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        // Sample products
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Smartphone", "Electronics"),
                new Product(3, "Tablet", "Electronics"),
                new Product(4, "Headphones", "Accessories"),
                new Product(5, "Camera", "Electronics")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        // Test linear search
        Product foundProduct = linearSearch(products, 3);
        System.out.println(foundProduct != null ? foundProduct : "Product not found");

        // Test binary search
        foundProduct = binarySearch(products, 3);
        System.out.println(foundProduct != null ? foundProduct : "Product not found");
    }
}
