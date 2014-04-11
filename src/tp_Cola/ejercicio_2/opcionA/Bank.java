package tp_Cola.ejercicio_2.opcionA;

import tp_Cola.QueueD;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 04/04/14
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public class Bank {

    private BankTeller [] bankTellers = new BankTeller[3];
    private QueueD clientsQueue = new QueueD();
    private ArrayList<Client> attendedClients = new ArrayList<Client>();
    private ArrayList<Client> clients = new ArrayList<Client>();


   public Bank(){

       //Create the bankTellers with it attention times and set each one Free.
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

    private int randomBankTeller(){

        int randomBankTeller = -1;

        boolean allBankTellersFree = bankTellers[0].isFree() && bankTellers[1].isFree() && bankTellers[2].isFree();
        boolean bankTellers0And1free = bankTellers[0].isFree() && bankTellers[1].isFree();
        boolean bankTellers0And2free = bankTellers[0].isFree() && bankTellers[2].isFree();
        boolean bankTellers1And2free = bankTellers[1].isFree() && bankTellers[2].isFree();
        boolean only2BankTellersFree = bankTellers0And1free || bankTellers0And2free || bankTellers1And2free;


        if(allBankTellersFree){

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
            clientsQueue.enqueue(clients.remove(0));

        }

        attendMethod();


        if(clientsQueue.length()>0){

            attendClientQueue();

        }


    }

    private void attendMethod(){

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
                    clientsQueue.enqueue(a);
                    count = 0;
                }



            if(!clientsQueue.isEmpty()){


                boolean onlyOneClient = clientsQueue.length() == 1;
                boolean onlyTwoClient = clientsQueue.length() == 2;
                boolean threeOrMoreClients = clientsQueue.length() >= 3;

                boolean allBankTellersFree = bankTellers[0].isFree() && bankTellers[1].isFree() && bankTellers[2].isFree();
                boolean bankTellers0And1free = bankTellers[0].isFree() && bankTellers[1].isFree();
                boolean bankTellers0And2free = bankTellers[0].isFree() && bankTellers[2].isFree();
                boolean bankTellers1And2free = bankTellers[1].isFree() && bankTellers[2].isFree();
                boolean only2BankTellersFree = bankTellers0And1free || bankTellers0And2free || bankTellers1And2free;
                boolean onlyOneBankTellerFree = bankTellers[0].isFree() || bankTellers[1].isFree() || bankTellers[2].isFree();


                if(allBankTellersFree){


                    if(onlyOneClient){

                        Client a = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();

                        a.setCheckOutTime(time + bankTellers[bankTeller].attend(time));

                        attendedClients.add(a);

                    }
                    else if(onlyTwoClient){

                        Client a = (Client) clientsQueue.dequeue();
                        Client b = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time + bankTellers[bankTeller].attend(time));

                        int bankTeller2 = randomBankTeller();
                        b.setCheckOutTime(time + bankTellers[bankTeller2].attend(time));

                        attendedClients.add(a);
                        attendedClients.add(b);

                    }
                    else if(threeOrMoreClients){

                        Client a = (Client) clientsQueue.dequeue();
                        Client b = (Client) clientsQueue.dequeue();
                        Client c = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                        int bankTeller2 = randomBankTeller();
                        b.setCheckOutTime(time +bankTellers[bankTeller2].attend(time));

                        int bankTeller3 = randomBankTeller();
                        c.setCheckOutTime(time +bankTellers[bankTeller3].attend(time));


                        attendedClients.add(a);
                        attendedClients.add(b);
                        attendedClients.add(c);

                    }

                }

                else if(only2BankTellersFree){


                    if (onlyOneClient){

                        Client a = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                        attendedClients.add(a);


                    }

                    else {


                        Client a = (Client) clientsQueue.dequeue();
                        Client b = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                        int bankTeller2 = randomBankTeller();
                        b.setCheckOutTime(time +bankTellers[bankTeller2].attend(time));

                        attendedClients.add(a);
                        attendedClients.add(b);

                    }


                }

                else if(onlyOneBankTellerFree){

                    Client a = (Client) clientsQueue.dequeue();

                    int bankTeller = randomBankTeller();
                    a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                    attendedClients.add(a);
                }

            }




        }





    }

    private void attendClientQueue(){

     int time = 54000;

    while (clientsQueue.length()>=1){



            //Look if any bank teller has finish.
            for (int i = 0 ; i < 3; i++){

                if(bankTellers[i].getFinalizationTimeOfTheLastClient()==time){
                    bankTellers[i].setFree(true);
                }
            }




                boolean onlyOneClient = clientsQueue.length() == 1;
                boolean onlyTwoClient = clientsQueue.length() == 2;
                boolean threeOrMoreClients = clientsQueue.length() >= 3;

                boolean allBankTellersFree = bankTellers[0].isFree() && bankTellers[1].isFree() && bankTellers[2].isFree();
                boolean bankTellers0And1free = bankTellers[0].isFree() && bankTellers[1].isFree();
                boolean bankTellers0And2free = bankTellers[0].isFree() && bankTellers[2].isFree();
                boolean bankTellers1And2free = bankTellers[1].isFree() && bankTellers[2].isFree();
                boolean only2BankTellersFree = bankTellers0And1free || bankTellers0And2free || bankTellers1And2free;
                boolean onlyOneBankTellerFree = bankTellers[0].isFree() || bankTellers[1].isFree() || bankTellers[2].isFree();


                if(allBankTellersFree){

                    if(onlyOneClient){

                        Client a = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                        attendedClients.add(a);

                    }
                    else if(onlyTwoClient){
                        Client a = (Client) clientsQueue.dequeue();
                        Client b = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                        int bankTeller2 = randomBankTeller();
                        b.setCheckOutTime(time +bankTellers[bankTeller2].attend(time));

                        attendedClients.add(a);
                        attendedClients.add(b);

                    }
                    else if(threeOrMoreClients){
                        Client a = (Client) clientsQueue.dequeue();
                        Client b = (Client) clientsQueue.dequeue();
                        Client c = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                        int bankTeller2 = randomBankTeller();
                        b.setCheckOutTime(time +bankTellers[bankTeller2].attend(time));

                        int bankTeller3 = randomBankTeller();
                        b.setCheckOutTime(time +bankTellers[bankTeller3].attend(time));

                        attendedClients.add(a);
                        attendedClients.add(b);
                        attendedClients.add(c);

                    }



                }

                else if(only2BankTellersFree){

                    if (onlyOneClient){
                        Client a = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                        attendedClients.add(a);


                    }

                    else {


                        Client a = (Client) clientsQueue.dequeue();
                        Client b = (Client) clientsQueue.dequeue();

                        int bankTeller = randomBankTeller();
                        a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                        int bankTeller2 = randomBankTeller();
                        b.setCheckOutTime(time +bankTellers[bankTeller2].attend(time));

                        attendedClients.add(a);
                        attendedClients.add(b);

                    }


                }

                else if(onlyOneBankTellerFree){

                    Client a = (Client) clientsQueue.dequeue();

                    int bankTeller = randomBankTeller();
                    a.setCheckOutTime(time +bankTellers[bankTeller].attend(time));

                    attendedClients.add(a);
                }

        time++;
    }






    }

    public void printResults(){

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
