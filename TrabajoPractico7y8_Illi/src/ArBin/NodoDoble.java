package ArBin;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: alumnosfi
 * Date: 26/03/14
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class NodoDoble implements Serializable {
    Object element;
    NodoDoble izq, der;

    @Override
    public boolean equals(Object obj) {
        return this.element.equals(obj);
    }
}
