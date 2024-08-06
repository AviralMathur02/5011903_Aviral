public class BuilderPatternTest {
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern

        // Basic Computer with CPU and RAM
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
        System.out.println(basicComputer);

        // Gaming Computer with GPU and WiFi
        Computer gamingComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setHasGraphicsCard(true)
                .setHasWiFi(true)
                .build();
        System.out.println(gamingComputer);

        // Office Computer without GPU and with WiFi
        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setHasWiFi(true)
                .build();
        System.out.println(officeComputer);
    }
}
