package test;

import spellingChecker.SpellingChecker;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 30/06/14
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class TestMinAndMax {

    public static void main(String[] args) {

        SpellingChecker spelling = new SpellingChecker();

        System.out.println(spelling.getTheMinOfTheDictionary("C:\\Users\\Gustavo\\Desktop\\Programas intellij\\Tabla Hash\\src\\usefullClasses\\EnglishBasicDictionary.txt"));
        System.out.println(spelling.getTheMaxOfTheDictionary("C:\\Users\\Gustavo\\Desktop\\Programas intellij\\Tabla Hash\\src\\usefullClasses\\EnglishBasicDictionary.txt"));
    }
}
