public class SortingAlgorithms {

    // Bubble Sort implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Stop if the array is already sorted
        }
    }

    // Quick Sort implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            // Recursively sort elements before and after partition
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    // Partition method used by Quick Sort
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1; // Index of smaller element
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Sample orders
        Order[] orders = {
                new Order(1, "Alice", 250.75),
                new Order(2, "Bob", 100.50),
                new Order(3, "Charlie", 325.00),
                new Order(4, "Diana", 150.25),
                new Order(5, "Eve", 210.00)
        };

        // Test Bubble Sort
        bubbleSort(orders);
        System.out.println("Orders sorted by Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Test Quick Sort
        // Sorting again using Quick Sort on the same orders array
        quickSort(orders, 0, orders.length - 1);
        System.out.println("Orders sorted by Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
