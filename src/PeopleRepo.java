import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleRepo {
    private static final String INSERT_QUERY = "INSERT INTO peoples (surname, name, patronymic, age) VALUES (?, ?, ?, ?)";
    private static final String GET_QUERY = "SELECT * FROM peoples";

    public static List<People> getPeoples(String query) {
        List<People> peoples = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_QUERY)){
            exec(peoples, statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;
    }

    private static void exec(List<People> peoples, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String surname = resultSet.getString("surname");
            String name = resultSet.getString("name");
            String patronymic = resultSet.getString("patronymic");
            int age = resultSet.getInt("age");
            peoples.add(new People(id, surname, name, patronymic, age));
        }
    }

    public static List<People> addPeople(People people) {
        List<People> peoples = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            statement.setString(1, people.getSurname());
            statement.setString(2, people.getName());
            statement.setString(3, people.getPatronymic());
            statement.setInt(4, people.getAge());
            statement.executeUpdate();

            PreparedStatement allStudents = connection.prepareStatement(GET_QUERY);
            exec(peoples, allStudents);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;
    }
}
