package tp_Cola.ejercicio_2.opcionB;


import tp_Cola.QueueD;

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
    private QueueD clientQueue = new QueueD();

    public int queueSize(){
        return clientQueue.length();
    }

    public boolean theQueueIsEmpty(){

        return clientQueue.length()==0;
    }

    public Client getClient() {
        return (Client)clientQueue.dequeue();
    }

    public void addClientToTheQueue(Client client) {
        clientQueue.enqueue(client);
    }

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
