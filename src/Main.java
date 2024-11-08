
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        int n = 5;

        for (int i=1; i <= n; i++) {
            Philosopher philosopher = new Philosopher(table, i);
            philosopher.start();
        }
    }
}