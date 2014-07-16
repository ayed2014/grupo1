import spellingChecker.SpellingChecker;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/07/14
 * Time: 00:41
 * To change this template use File | Settings | File Templates.
 */
public class SpellingCheckerTester {

    public static void main(String[] args) {

        SpellingChecker checker = new SpellingChecker();

        //  IMPORTANT: If it is execute in another machine the  path MUST be change.

        checker.checkSpelling("C:\\Users\\Gustavo\\Desktop\\Programas intellij\\Tabla Hash\\src\\usefullClasses\\SpellingCheckerTest2.txt");
    }
}
