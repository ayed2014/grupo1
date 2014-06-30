package usefullClasses;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 04/04/14
 * Time: 09:59
 * To change this template use File | Settings | File Templates.
 */
public interface ListEInterface {
    public void addBefore(Object elem);
    public void addNext(Object elem);
    public void next();
    public void before();
    public void goTo(int x);
    public boolean isEmpty();
    public void empty();
    public Object showWindow();
    public void delete();
    public void modify(Object elem);
    public int length();
}
