package soundex;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 01/06/14
 * Time: 00:32
 * To change this template use File | Settings | File Templates.
 */
public class Soundex {

    /**
     * Method use to get the first letter code.
     * @param c
     * @return String (code)
     */
    private static String getCode(char c){

        switch(c){
            case 'B': case 'F': case 'P': case 'V':
                return "1";
            case 'C': case 'G': case 'J': case 'K':
            case 'Q': case 'S': case 'X': case 'Z':
                return "2";
            case 'D': case 'T':
                return "3";
            case 'L':
                return "4";
            case 'M': case 'N':
                return "5";
            case 'R':
                return "6";
            default:
                return "";
        }

    }

    /**
     * Method that gives a code based in a string given.
     * @param s
     * @return
     */
    public static String soundex(String s){
        String code, previous, soundex;
        code = s.toUpperCase().charAt(0) + "";
        previous = "7";

        for(int i = 1;i < s.length();i++){
            String current = getCode(s.toUpperCase().charAt(i));
            if(current.length() > 0 && !current.equals(previous)){
                code = code + current;
            }
            previous = current;
        }

        soundex = (code + "0000").substring(0, 4);
        return soundex;
    }

    /**
     public static int soundex(String s){

     String code = "";
     String previous;
     String soundex;

     s=s.toUpperCase();

     previous = "10";

     for (int i = 0 ; i < s.length(); i++){
     String current = getCode(s.charAt(i));

     if (current.length()>0 && !current.equalsIgnoreCase(previous)){
     code = code + current;
     }
     previous = current;
     }

     if(code.length()>4){
     soundex = code.substring(0,4);
     }
     else {
     soundex = code;
     }

     int codeToReturn = Integer.parseInt(soundex);

     return codeToReturn;
     }
     **/
}


