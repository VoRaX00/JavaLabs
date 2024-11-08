import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleRepo {
    public static List<People> getPeoples(String query) {
        List<People> peoples = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String patronymic = resultSet.getString("patronymic");
                int age = resultSet.getInt("age");
                peoples.add(new People(id, surname, name, patronymic, age));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;
    }

    public static List<People> addPeople(People people) {
        List<People> peoples = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO peoples (surname, name, ) VALUES (?, ?, ?, ?)")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String patronymic = resultSet.getString("patronymic");
                int age = resultSet.getInt("age");
                peoples.add(new People(id, surname, name, patronymic, age));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;
    }
}
