package tp_lista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 06/04/14
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */
public class Metrovias {

    private ListE cashierList;
    private int cashierAmount;

    public Metrovias(){
        cashierList=new ListE();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        boolean continuar=true;
        try {
            while(continuar){
                System.out.print("Ingrese el numero de ventanillas: ");
                cashierAmount= Integer.parseInt(br.readLine()) ;
                if (cashierAmount>=3 && cashierAmount<=10){
                    continuar=false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0;i<cashierAmount;i++){
            cashierList.addNext(new Cashier());
        }
    }

    public void simulate(){

        for (int time=0; time<57570; time+=10){
           for (int i =0; i <5; i++){
               int randomCashier=(int) (Math.random()*(cashierAmount));
               cashierList.goTo(randomCashier);
               Cashier aux= (Cashier)cashierList.showWindow();
               aux.addClient(time);
           }
            for (int j=0;j<cashierAmount;j++){
                int random= (int) ((Math.random())*10+1);
                cashierList.goTo(j);
                Cashier aux=(Cashier) cashierList.showWindow();
                if (aux.clientsRemaining()>0){
                    if (random<=3)
                        aux.removeClient(time);
                    else
                        aux.setIdleTime();
                }
            }
        }
        for (int k=0;k<cashierAmount;k++) {
            cashierList.goTo(k);
            Cashier aux= (Cashier) cashierList.showWindow();
            while(!aux.isEmpty()){
                aux.removeClient(57570);
            }
        }
        DecimalFormat df= new DecimalFormat("0.00");
        for(int k=0;k<cashierAmount;k++){
            cashierList.goTo(k);
            Cashier aux= (Cashier) cashierList.showWindow();
            System.out.println("Ventanilla "+(k+1)+": ");
            System.out.println("-Tiempo medio de espera por cliente: " + df.format(aux.getWaitingTime()/60)+" minutos.");
            System.out.println("-Total recaudado en pesos: " + df.format(aux.getIncome()));
            System.out.println("-Tiempo ocioso de la ventanilla: " + df.format(aux.getIdleTime()/60)+" minutos.");
        }
    }
}
