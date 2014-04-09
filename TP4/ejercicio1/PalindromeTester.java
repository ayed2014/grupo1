package ejercicio1;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 04/04/14
 * Time: 01:34
 * To change this template use File | Settings | File Templates.
 */
public class PalindromeTester {

    public static void main(String[] args) {

        Palindromo palindromo = new Palindromo();

        //Array of String representing palindromePhrase.
        String [] palindromePhrase = new String[4];
        palindromePhrase[0] ="Acaso";
        palindromePhrase[1] = "hubo";
        palindromePhrase[2] = "buhos";
        palindromePhrase[3] = "aca";

        //String representing palindromePhrase palindrome word.
        String palindromeWord = "neuquen";

        //Test the palindrome phrase.
        System.out.println(palindromo.isAPalindrome(palindromePhrase));
        //Test the palindrome word.
        System.out.println(palindromo.isAPalindrome(palindromeWord));



    }
}
