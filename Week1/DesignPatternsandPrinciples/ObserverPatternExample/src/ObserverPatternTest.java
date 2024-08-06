public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("StockTracker");
        Observer webApp = new WebApp("StockViewer");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Simulate stock price changes
        System.out.println("Setting stock price to 100.00");
        stockMarket.setStockPrice(100.00);

        System.out.println("Setting stock price to 105.50");
        stockMarket.setStockPrice(105.50);

        // Deregister one observer and simulate another change
        stockMarket.deregisterObserver(webApp);
        System.out.println("Setting stock price to 102.75");
        stockMarket.setStockPrice(102.75);
    }
}
