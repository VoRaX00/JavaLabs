public class Table {
    public synchronized void eat(int philosopherNumber) {
        System.out.println(philosopherNumber + " ест рис.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(philosopherNumber + " закончил есть.");
    }
}
