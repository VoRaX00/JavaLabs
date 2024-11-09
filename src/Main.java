import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        while (true) {
            String[] params = getParams();
            if (params == null) {
                System.out.println("Параметры введены неверно");
                break;
            } else {
                People people = new People(params[0], params[1], params[2], Integer.parseInt(params[3]));
                List<People> peoples = PeopleRepo.addPeople(people);
                System.out.println(peoples);
            }
        }
    }

    private static String[] getParams() {
        System.out.println("Введите ваше ФИО и ваш возраст: (пример: Кержаков Никита Алексеевич 20)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isCorrect(input)) {
            return input.split(" ");
        }
        return null;
    }

    private static boolean isCorrect(String input) {
        String regex = "^[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ (1[0-4][0-9]|[1-9]?[0-9]|150)$";
        return input.matches(regex);
    }
}