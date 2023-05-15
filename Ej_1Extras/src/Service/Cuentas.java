
package Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Cuentas {
    Scanner leer = new Scanner(System.in);
    ArrayList<Integer> Numeros = new ArrayList();
    
    private ArrayList<Integer> crearLista(){
        Integer N;
        System.out.println("Ingrese números(cuantos quiera)");
        System.out.println(" introduzca -99 para finalizar.");
        do{
            N = leer.nextInt();
            if(N != -99){
                Numeros.add(N);
            }
        }while(N != -99);
        return Numeros;
    }
    private void lectura(){
        System.out.println("Se introdujeron "+Numeros.size()+" números");
    }
    private int suma(){
        Iterator<Integer> S = Numeros.iterator();
        int Suma=0;
        while(S.hasNext()){
            int num = S.next();
            Suma = Suma + num;
        }
        return Suma;
    }
    private double promedio(){
        return (double)suma() / Numeros.size();
    }
    public void menu(){
        crearLista();
        lectura();
        System.out.println("La suma de todos esos números es "+suma());
        System.out.println("El promedio de todos esos números es "+promedio());
    }
}
