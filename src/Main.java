import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        People people = new People("Nikita", "Kerzhakov", 2004, "Пермь");
        PeopleToFile.OutputFile(people, "../test.txt");
        System.out.println(PeopleToFile.ReadFile("../test.txt"));
    }
}