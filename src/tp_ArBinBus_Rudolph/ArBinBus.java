package tp_ArBinBus_Rudolph;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 09/04/14
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public class ArBinBus {
    private DoubleNodeComp root;

    public ArBinBus(){
        root=null;
    }
    public boolean isEmpty(){
        return (root==null);
    }
    public Object getRoot(){
        if (root!=null)
            return root.elem;
        else return null;
    }
    public ArBinBus getLeft(){
        ArBinBus t= new ArBinBus();
        t.root= root.leftSon;
        return t;
    }
    public ArBinBus getRight(){
        ArBinBus t= new ArBinBus();
        t.root= root.rightSon;
        return t;
    }

    public void insert(Comparable object){
        if (exists(object)) try {
            throw new ExistException();
        } catch (ExistException e) {
            e.printStackTrace();
        }
        else root=insert(root,object);
    }
    public Object getMinimum(){
        return getMinimum(root).elem;
    }
    public Object getMaximum(){
        return  getMaximum(root).elem;
    }
    public boolean exists(Comparable object){
        return exists(root, object);
    }
    public void remove(Comparable object){
        if (exists(object)) root=remove(root, object);
        else try {
            throw new NotExistException();
        } catch (NotExistException e) {
            e.printStackTrace();
        }
    }
    public Object search(Comparable object){
        return search(root, object).elem;
    }


    private DoubleNodeComp insert(DoubleNodeComp root, Comparable object){
        if (root == null){
            root = new DoubleNodeComp();
            root.elem = object;
        }else if (object.compareTo(root.elem) < 0)
            root.leftSon = insert(root.leftSon, object);
        else
            root.rightSon = insert(root.rightSon, object);
        return root;
    }
    private DoubleNodeComp getMinimum(DoubleNodeComp root){
        if (root== null)
            return null;
        else if (root.leftSon==null)
            return root;
        else return getMinimum(root.leftSon);
    }
    private DoubleNodeComp getMaximum(DoubleNodeComp root){
        if (root== null)
            return null;
        else if (root.rightSon==null)
            return root;
        else return getMaximum(root.rightSon);
    }
    private boolean exists(DoubleNodeComp root, Comparable object){
        if (root==null)
            return false;
        else if (object.compareTo(root.elem)==0)
            return true;
        else if (object.compareTo(root.elem)<0)
            return exists(root.leftSon, object);
        else return exists(root.rightSon, object);
    }
    private DoubleNodeComp remove(DoubleNodeComp root, Comparable object){
        if (object.compareTo(root.elem) < 0)
        root.leftSon = remove(root.leftSon, object);
        else if (object.compareTo(root.elem) > 0)
            root.rightSon = remove(root.rightSon, object);
        else
        if (root.leftSon != null && root.rightSon != null ) {
            root.elem = getMinimum(root.rightSon).elem;
            root.rightSon = removeMin(root.rightSon);
        }
        else if (root.leftSon != null)
            root = root.leftSon;
        else
            root =root.rightSon;
        return root;
    }
    private DoubleNodeComp removeMin(DoubleNodeComp root){
        if (root.leftSon != null)
            root.leftSon = removeMin(root.leftSon);
        else
            root = root.rightSon;
        return root;
    }
    private DoubleNodeComp search(DoubleNodeComp root, Comparable object){
        if (object.compareTo( root.elem)== 0)
            return root;
        else if (object.compareTo( root.elem)< 0)
            return search(root.leftSon, object);
        else
            return search(root.rightSon, object);
    }

    private class ExistException extends Throwable {
    }
    private class NotExistException extends Throwable {
    }
}
