package ejercicio2.opcionA;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 04/04/14
 * Time: 23:45
 * To change this template use File | Settings | File Templates.
 */
public class BankTeller {

    private int minAttentionTime;
    private int maxAttentionTime;
    private boolean isFree;
    private int finalizationTimeOfTheLastClient = 36000;



    public void setMaxAttentionTime(int maxAttentionTime) {
        this.maxAttentionTime = maxAttentionTime;
    }

    public void setMinAttentionTime(int minAttentionTime) {
        this.minAttentionTime = minAttentionTime;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    private int randomAttentionNumber(){

        return minAttentionTime + (int)(Math.random()*((maxAttentionTime-minAttentionTime)+1));
    }

    public int attend(int time){

        setFree(false);
        int timeAttention = randomAttentionNumber();
        finalizationTimeOfTheLastClient = time + timeAttention;

        return timeAttention;

    }

    public int getFinalizationTimeOfTheLastClient() {
        return finalizationTimeOfTheLastClient;
    }

}
