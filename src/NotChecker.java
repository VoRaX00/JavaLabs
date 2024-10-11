public class NotChecker implements Checker {
    private final Checker _checker1;
    private final Checker _checker2;

    NotChecker(Checker checker1, Checker checker2) {
        _checker1 = checker1;
        _checker2 = checker2;
    }

    public boolean accept(String text) {
        return !(_checker1.accept(text) && _checker2.accept(text));
    }
}
