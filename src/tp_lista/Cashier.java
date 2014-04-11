package tp_lista;

import tp_Cola.QueueD;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 06/04/14
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
public class Cashier {
    private QueueD clients;
    private double income;
    private int idleTime;
    private int clientsServed;
    private double waitingTime;

    public Cashier(){
        idleTime=0;
        income=0;
        clientsServed=0;
        waitingTime=0;
        clients= new QueueD();
    }

    public void addClient(int arrivalTime){
        clients.enqueue(new Customer(arrivalTime));
    }
    public void removeClient(int departureTime){
        Customer aux=(Customer)clients.seeFront();
        income+=0.7;
        clientsServed++;
        waitingTime+=(departureTime-aux.getEntryTime());
        clients.dequeue();
    }
    public void setIdleTime(){
        idleTime+=10;
    }

    public double getIncome() {
        return income;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public double getWaitingTime() {
        return (waitingTime)/clientsServed;
    }
     public boolean isEmpty(){
         return clients.isEmpty();
     }
    public int clientsRemaining(){
        return clients.length();
    }
}
