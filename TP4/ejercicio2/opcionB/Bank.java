package ejercicio2.opcionB;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 09/04/14
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class Bank {

    private BankTeller [] bankTellers = new BankTeller[3];
    private ArrayList<Client> attendedClients = new ArrayList<Client>();
    private ArrayList<Client> clients = new ArrayList<Client>();

    public Bank(){
        bankTellers[0] = new BankTeller();
        bankTellers[1] = new BankTeller();
        bankTellers[2] = new BankTeller();

        bankTellers[0].setMinAttentionTime(30);
        bankTellers[0].setMaxAttentionTime(90);
        bankTellers[0].setFree(true);

        bankTellers[1].setMinAttentionTime(30);
        bankTellers[1].setMaxAttentionTime(120);
        bankTellers[1].setFree(true);

        bankTellers[2].setMinAttentionTime(30);
        bankTellers[2].setMaxAttentionTime(150);
        bankTellers[2].setFree(true);

    }

    private int generateARandomNumberBetween(int min, int max){

        return min +(int)(Math.random()*((max-min)+1));
    }

    private int  generateARandomNumberBetweenWithoutANumber(int min, int max, int without){
        int randomNumber = generateARandomNumberBetween(min,max);

        if(randomNumber == without){

            generateARandomNumberBetweenWithoutANumber(min,max,without);
        }

        return randomNumber;
    }

    public int chooseBankTeller(){

        int randomBankTeller = 1;

        boolean allBankTellersOccupied = !bankTellers[0].isFree() && !bankTellers[1].isFree() && !bankTellers[2].isFree();
        boolean allBankTellersFree = bankTellers[0].isFree() && bankTellers[1].isFree() && bankTellers[2].isFree();
        boolean bankTellers0And1free = bankTellers[0].isFree() && bankTellers[1].isFree();
        boolean bankTellers0And2free = bankTellers[0].isFree() && bankTellers[2].isFree();
        boolean bankTellers1And2free = bankTellers[1].isFree() && bankTellers[2].isFree();
        boolean only2BankTellersFree = bankTellers0And1free || bankTellers0And2free || bankTellers1And2free;

        if (allBankTellersFree){

            randomBankTeller = generateARandomNumberBetween(0,2);
        }

        else if(only2BankTellersFree){

            if(bankTellers0And1free){
                randomBankTeller = generateARandomNumberBetween(0,1);
            }
            else if(bankTellers0And2free){
                randomBankTeller = generateARandomNumberBetweenWithoutANumber(0,2,1);
            }
            else if(bankTellers1And2free){
                randomBankTeller = generateARandomNumberBetween(1,2);
            }
        }
        //If all the queue are occupied, it search the shortest.
        else if(allBankTellersOccupied){

            if(bankTellers[0].queueSize()<bankTellers[1].queueSize()){

                if(bankTellers[0].queueSize()<bankTellers[2].queueSize()){
                    randomBankTeller = 0;
                }
                else if(bankTellers[2].queueSize()<bankTellers[0].queueSize()) {
                    randomBankTeller = 2;
                }
                else if(bankTellers[0].queueSize()==bankTellers[2].queueSize()){
                    randomBankTeller = generateARandomNumberBetweenWithoutANumber(0,2,1);
                }
            }

            else if(bankTellers[0].queueSize()>bankTellers[1].queueSize()) {


                if(bankTellers[1].queueSize()<bankTellers[2].queueSize()){
                    randomBankTeller = 1;
                }
                else if(bankTellers[1].queueSize()>bankTellers[2].queueSize()) {
                    randomBankTeller = 2;
                }
                else if(bankTellers[1].queueSize()==bankTellers[2].queueSize()){
                    randomBankTeller = generateARandomNumberBetween(1,2);
                }
            }

            else if(bankTellers[0].queueSize()==bankTellers[1].queueSize()){

                if(bankTellers[0].queueSize()<bankTellers[2].queueSize()){
                    randomBankTeller = generateARandomNumberBetween(0,1);
                }
                else if(bankTellers[2].queueSize()<bankTellers[0].queueSize()){
                    randomBankTeller = 2;
                }
                else if(bankTellers[2].queueSize()==bankTellers[0].queueSize()){

                    randomBankTeller = generateARandomNumberBetween(0,2);
                }
            }

        }
        else  {

            if(bankTellers[0].isFree()){

                randomBankTeller = 0;
            }

            else if(bankTellers[1].isFree()){

                randomBankTeller = 1;
            }
            else if(bankTellers[2].isFree()){

                randomBankTeller = 2;
            }

        }

        return randomBankTeller;

    }

    public void start(){


        //Creates all the clients in a regular day.
        for (int i = 0; i < 215; i++){

            clients.add(new Client());
        }

        //Set the arrive time of the first 15 clients.
        for (int i = 0; i<15; i++){

            clients.get(0).setArriveTime(36000);
            //clientsQueue.enqueue(clients.remove(0));
            bankTellers[chooseBankTeller()].addClientToTheQueue(clients.remove(0));

        }

        attendMethod();

       //If at the time of closing the bank there are still people inside waiting for being attended.
        if(!bankTellers[0].theQueueIsEmpty() ||!bankTellers[1].theQueueIsEmpty()||!bankTellers[2].theQueueIsEmpty()){

            attendClientQueue();
        }
    }

    public void attendMethod(){

        int count = 0;

        for (int time = 36000; time <=54000; time++){

            count++;


            //Look if any bank teller has finish.
            for (int i = 0 ; i < 3; i++){

                if(bankTellers[i].getFinalizationTimeOfTheLastClient()==time){

                    bankTellers[i].setFree(true);
                }
            }

            //Each 90 seconds a new client arrive to bank.

            if(count == 90){

                Client a = clients.remove(0);
                a.setArriveTime(time);
                bankTellers[chooseBankTeller()].addClientToTheQueue(a);
                count = 0;
            }

            if(bankTellers[0].isFree()){

                if(!bankTellers[0].theQueueIsEmpty()){

                    Client a = bankTellers[0].getClient();
                    a.setCheckOutTime( time + bankTellers[0].attend(time));
                    attendedClients.add(a);

                }

            }

            if (bankTellers[1].isFree()){

                if (!bankTellers[1].theQueueIsEmpty()){

                    Client a = bankTellers[1].getClient();
                    a.setCheckOutTime( time + bankTellers[1].attend(time));
                    attendedClients.add(a);
                }
            }

            if (bankTellers[2].isFree()){

                if (!bankTellers[2].theQueueIsEmpty()){

                    Client a = bankTellers[2].getClient();
                    a.setCheckOutTime(time + bankTellers[2].attend(time));
                    attendedClients.add(a);
                }
            }

        }

    }

    public void attendClientQueue(){

        int time = 54000;

       for (int i = 0; i< bankTellers.length; i++){

           while (!bankTellers[i].theQueueIsEmpty()){

               if(bankTellers[i].getFinalizationTimeOfTheLastClient()== time){
                   bankTellers[i].setFree(true);
               }

               if (bankTellers[i].isFree()){

                   Client a = bankTellers[i].getClient();
                   a.setCheckOutTime(time + bankTellers[i].attend(time));
                   attendedClients.add(a);

               }
           }
       }
    }

    public void printResult(){

        System.out.println("***The Bank Simulation Result***");
        System.out.println("\n");
        System.out.println("Clients attended: " + attendedClients.size());

        int totalWaitingTime = 0;

        for (int i=0; i < attendedClients.size();i++){

            int clientWaiting = attendedClients.get(i).getCheckOutTime() - attendedClients.get(i).getArriveTime();

            totalWaitingTime = totalWaitingTime + clientWaiting;

        }

        float waitingAverage = totalWaitingTime/attendedClients.size();

        System.out.println("Average waiting of each client: " + waitingAverage + " Seconds");

        float waitingAverageInMinutes = waitingAverage/60;
        System.out.println("Average waiting of each client: " + waitingAverageInMinutes + " min");


        System.out.println("\n");

        System.out.println("***End of the Simulation***");
    }


}
