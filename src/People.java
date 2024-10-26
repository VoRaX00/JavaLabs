import java.io.Serializable;
import java.util.Date;

public class People implements Serializable {
    private final String _name;
    private final String _surname;
    private final int _birthYear;
    private final String _address;

    public People(String name, String surname, int birthYear, String address) {
        _name = name;
        _surname = surname;
        _birthYear = birthYear;
        _address = address;
    }

    @Override
    public String toString() {
        return _name + " " + _surname + " " + _birthYear + " " + _address;
    }
}
