import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static boolean isCorrect(String str) {
        String regex = "^[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+,\\s\\d{2}\\.\\d{2}\\.\\d{4},\\s[А-ЯЁ][а-яё]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if (!matcher.matches()) {
            return false;
        }

        String[] parts = str.split(",\\s");
        if (parts.length < 3) {
            return false;
        }

        String datePart = parts[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate parsedDate = LocalDate.parse(datePart, formatter);
            String formattedDate = parsedDate.format(formatter);
            return formattedDate.equals(datePart);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fio, date and place of birth");
        System.out.println("Example: Иванов Иван Иванович, 29.02.2020, Москва");
        String str = scanner.nextLine();
        System.out.println("Result: " + isCorrect(str));
    }
}