package arboles;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/04/14
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public interface ArbolBinInterface {
    public void ArBin() ;
    public void ArBin(Object x);
    public void ArBin(Object x, ArBin t1, ArBin t2);
    public boolean esVacio();
    public Object esRaiz();
    public  ArBin hijoIzq();
    public  ArBin hijoDer();
}
