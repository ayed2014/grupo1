package usefullClasses;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 11/04/14
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 */
public interface ListaDinamicaInterface {
    public void insertA(Object o);
    public void insertD(Object o);
    public void next();
    public void last();
    public void goTo(int position);
    public void delete();
    public Object see();
    public void vaciar();
    public Boolean isEmpty();
    public int length();
    public void modify(Object o);
}
