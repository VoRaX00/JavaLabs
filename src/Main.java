//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Checker bChecker = new SubstringChecker("beets");
        Checker cChecker = new SubstringChecker("carrots");
        Checker bothChecker = new AndChecker(bChecker, cChecker);

        Checker aChecker = new SubstringChecker("artichokes");
        Checker veggies = new AndChecker(bothChecker, aChecker);

        System.out.println(bothChecker.accept("I love beets and carrots"));
        System.out.println(bothChecker.accept("beets and great"));
        System.out.println(veggies.accept("artichokes, beets, and carrots"));
    }
}