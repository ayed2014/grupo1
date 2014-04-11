package tp_Cola;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 28/03/14
 * Time: 09:49
 * To change this template use File | Settings | File Templates.
 */
public interface Queue {
    public void enqueue(Object o);
    public Object dequeue();
    public boolean isEmpty();
    public int length();
    public Object seeFront();

}
