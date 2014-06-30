package hashTableOpenDispersion;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 31/05/14
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class Primo {

    public static boolean isPrimo(int n){

        if(n == 1 || n == 2|| n == 3 ) {
            return true;
        }
        if (n % 2 == 0){
            return false;
        }

        else {

            int k = 3;

            while ( k <= Math.sqrt(n)){

                if(n % k == 0)  return false;

                else k = k + 2;

            }
        }
        return true;
    }

    public static int proxPrimo (int n){

        if (n % 2 == 0){
            n++;
        }

        while (!isPrimo(n)){
            n = n + 2;
        }
        return n;
    }
}
