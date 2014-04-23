package tp_ArBinBus_Rudolph;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 23/04/14
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class Lampara implements Comparable {
    private String lampCode;
    private int watts;
    private String type;
    private int amount;
    public Lampara(String lampCode){
        this.lampCode=lampCode;
    }
    public Lampara(String lampCode, String type){
        this. lampCode=lampCode;
        this.type=type;
        watts=0;

    }
    public Lampara(String lampCode, int watts, String type, int amount){
        try{
            if (lampCode.length()>5)
                throw new CodeLengthException();
            if (type.length()>10)
                throw new TypeLengthException();
        } catch (CodeLengthException e) {
            e.printStackTrace();
        } catch (TypeLengthException e) {
            e.printStackTrace();
        }
        this.lampCode=lampCode;
        this.watts=watts;
        this.type=type;
        this.amount=amount;
    }

    public String getLampCode() {
        return lampCode;
    }
    public void setLampCode(String lampCode) {
        this.lampCode = lampCode;
    }
    public int getWatts() {
        return watts;
    }
    public void setWatts(int watts) {
        this.watts = watts;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void reduceAmount(){
        amount--;
    }
    public void increaseAmount(){
        amount++;
    }

    @Override
    public int compareTo(Object o) {
        Lampara aux = (Lampara)o;
        if (lampCode.compareTo(aux.getLampCode())==0)
            return 0;
        else if (lampCode.compareTo(aux.getLampCode())<0)
            return -1;
        else return 1;
    }


    private class CodeLengthException extends Throwable {
    }
    private class TypeLengthException extends Throwable {
    }
}
