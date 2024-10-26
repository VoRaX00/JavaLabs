//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Storage<Integer> str = new Storage<>(10);
        str.Add(1);
        str.Add(1);
        str.Add(1);

        str.Remove();
        str.Print();
        System.out.println();
        str.Sort();
        str.Print();
    }
}