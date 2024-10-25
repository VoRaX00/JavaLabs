import java.io.*;

public class PeopleToFile {
    public static void OutputFile(People people, String path) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(people);
        objectOutputStream.close();
    }

    public static People ReadFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        People people = (People) objectInputStream.readObject();
        objectInputStream.close();
        return people;
    }
}
