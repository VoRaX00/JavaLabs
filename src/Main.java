//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double [] scanned = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1};

        SkyView view = new SkyView(2, 3, scanned);
        view.print();
    }
}