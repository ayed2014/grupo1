package test;

import spellingChecker.SpellingChecker;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 01/06/14
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public class SpellingCheckerTest {

    public static void main(String[] args) {

        SpellingChecker checker = new SpellingChecker();
        //int i =checker.getMinCapacityNumber("C:\\Users\\Gustavo\\Desktop\\Programas intellij\\Tabla Hash\\src\\usefullClasses\\toDelete.txt");
        //int i = checker.getKey("buy",5);
        //System.out.println(i);
        checker.checkSpelling("C:\\Users\\Gustavo\\Desktop\\Programas intellij\\Tabla Hash\\src\\usefullClasses\\SpellingCheckerTest2.txt");
    }
}
