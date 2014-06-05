package tp_Archivo_Texto;

import java.io.*;

/**
 * Created by rudolpha on 21/05/2014.
 */
public class ArchivoTextoApi {

    public static int ejercicio1(String option, String fileName) {

        int amount = 0;
        FileReader fr;
        try {
            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();

            while (str != null) {

                if (option.compareTo("c")==0)
                    amount = amount + str.length();
                else if (option.compareTo("l")==0)
                    amount++;
                else System.out.println("La opción elegida no es valida");
                str = br.readLine();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return amount;
    }

    public static int ejercicio2(String c,String fileName){
        int amount=0;
        FileReader fr;
        try {
            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            int unicodeChar=br.read();

            while (unicodeChar != -1) {
                String car = ""+(char)unicodeChar;
                if (car.compareTo(c)==0)
                    amount++;
                unicodeChar=br.read();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return amount;
    }

    public  static boolean ejercicio3(boolean option, String fileName, String newFileName){
        FileReader fr;
        FileWriter fw;
        try {
            fr = new FileReader(fileName);
            fw= new FileWriter(newFileName);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();

            while (str != null) {
                if (option)str=str.toUpperCase();
                else str=str.toLowerCase();
                fw.write(str+"\n");
                str = br.readLine();
            }
            fr.close();
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean ejercicio4(String fileName1, String fileName2, String fileName3){
        FileReader fr;
        FileWriter fw1;
        FileWriter fw2;
        try {
            fr = new FileReader(fileName1);
            fw1= new FileWriter(fileName2);
            fw2= new FileWriter(fileName3);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                String[] parts=line.split(";");
                double population=Double.parseDouble(parts[1]);
                if (population>30)
                    fw1.write(line+"\n");
                else fw2.write(line+"\n");

                line=br.readLine();
            }
            fr.close();
            fw1.close();
            fw2.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    public static boolean ejercicio5(String fileName1, String fileName2, String fileName3, int pob,String option){
        FileReader fr;
        FileWriter fw1;
        FileWriter fw2;
        try {
            fr = new FileReader(fileName1);
            fw1= new FileWriter(fileName2);
            fw2= new FileWriter(fileName3);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                String[] parts=line.split(";");
                double population=Double.parseDouble(parts[1]);
                if (option ==null) {
                    if (population > pob) {
                        fw1.write(line + "\n");
                    } else {
                        fw2.write(line + "\n");
                    }
                }else if (option.equals("POB")){
                    if (population > pob) {
                        fw1.write(parts[0]+";"+parts[1]+"\n");
                    } else {
                        fw2.write(parts[0]+";"+parts[1]+"\n");
                    }
                } else if (option.equals("PBI")){
                    if (population > pob) {
                        fw1.write(parts[0]+";"+parts[2]+"\n");
                    } else {
                        fw2.write(parts[0]+";"+parts[2]+"\n");
                    }
                }
                line=br.readLine();

            }
            fr.close();
            fw1.close();
            fw2.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
