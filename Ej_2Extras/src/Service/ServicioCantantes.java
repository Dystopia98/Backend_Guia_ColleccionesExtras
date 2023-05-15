package Service;

import Objeto.Cantante;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ServicioCantantes {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Cantante> Lista = new ArrayList();

    private ArrayList<Cantante> crearLista() {
        String[] N = new String[5];
        String[] D = new String[5];
        System.out.println("Escriba los nombres de 5 cantantes.");
        for (int i = 0; i < 5; i++) {
            N[i] = leer.next();
        }
        System.out.println("Nombre 1 disco de cada uno de ellos.");
        for (int i = 0; i < 5; i++) {
            System.out.print(N[i] + " : ");
            D[i] = leer.next();
        }
        for (int i = 0; i < 5; i++) {
            Cantante C = new Cantante(N[i], D[i]);
            Lista.add(C);
        }
        Iterator<Cantante> I = Lista.iterator();
        while (I.hasNext()) {
            Cantante Can = I.next();
            System.out.println(Can.getDisco() + " - " + Can.getNombre());
        }
        return Lista;
    }

    private void agregarArtista() {
        String N, D;
        System.out.print("Nombre : ");
        N = leer.next();
        System.out.print("Disco de " + N + " : ");
        D = leer.next();
        Cantante C = new Cantante(N, D);
        Lista.add(C);
    }

    private void mostrarLista() {
        
        Iterator<Cantante> I = Lista.iterator();
        System.out.println(" Artista                      Disco");
        System.out.println("________________________________________");
        while (I.hasNext()) {
            int Lon = 30;
            String C = "";
            Cantante Can = I.next();
            for (int i = 0; i < Lon - Can.getNombre().length(); i++) {
                C = C + " ";
            }
            System.out.println(Can.getNombre() +C+" * "+ Can.getDisco());
        }
    }

    private void eliminarArtista(String A) {
        Iterator<Cantante> I = Lista.iterator();
        while (I.hasNext()) {
            Cantante Can = I.next();
            if (Can.getNombre().toUpperCase().equals(A.toUpperCase())) {
                I.remove();
            }
        }
    }

    public void menu() {
        int R;
        crearLista();
        do {
            System.out.println("        MENÚ");
            System.out.println("    1)Agregar artista.");
            System.out.println("    2)Eliminar artista.");
            System.out.println("    3)Mostrar lista con artistas.");
            System.out.println("    4)Salir del programa.");
            R = leer.nextInt();
            switch (R) {
                case 1:
                    agregarArtista();
                    break;
                case 2:
                    String NA;
                    System.out.println("Nombre del artista a eliminar : ");
                    NA = leer.next();
                    eliminarArtista(NA);
                    break;
                case 3:
                    mostrarLista();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no encontrada.");
                    break;
            }
            System.out.println("________________________________________");
        } while (R != 4);
    }
}
