package Service;

import Objeto.Libro;
import static Objeto.Libro.Ordenar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Libreria {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    HashSet<Libro> Libreria = new HashSet();

    private HashSet<Libro> crearLibreria() {
        String NL, NT, R;
        int ejem, ejempres;
        do {
            System.out.print("Nombre del libro : ");
            NL = leer.next();
            System.out.print("Nombre del autor de " + NL + " : ");
            NT = leer.next();
            ejem = 10;
            ejempres = 0;
            Libro book = new Libro(NL, NT, ejem, ejempres);
            if (Libreria.isEmpty()) {
                Libreria.add(book);
            } else {
                int c=0;
                Iterator<Libro> I = Libreria.iterator();
                while (I.hasNext()) {
                    Libro B = I.next();
                    if (B.getTitulo().toUpperCase().equals(book.getTitulo().toUpperCase()) && B.getAutor().toUpperCase().equals(book.getAutor().toUpperCase())) {
                        System.out.println("-Ese libro ya se encuentra registrado con ese autor-");
                        c = 1;
                    }
                }
                if(c == 0){
                    Libreria.add(book);
                }
            }
            System.out.println("______________________________");
            System.out.println("¿Desea agregar otro libro?");
            R = leer.next();
            if (!R.toUpperCase().equals("NO") && !R.toUpperCase().equals("SI")) {
                System.out.println("¡Tomaré eso como un si!");
            }
            System.out.println("______________________________");
        } while (!R.toUpperCase().equals("NO"));
        return Libreria;
    }

    private boolean agotados(Libro A) {
        return A.getEjemplaresPrestados() >= 1;
    }

    private boolean hayLibros(Libro A) {
        return A.getEjemplaresPrestados() < A.getEjemplares();
    }

    private void prestamo() {
        String TL;
        System.out.print("Título del libro : ");
        TL = leer.next();
        Iterator<Libro> I = Libreria.iterator();
        while (I.hasNext()) {
            Libro B = I.next();
            if (B.getTitulo().toUpperCase().equals(TL.toUpperCase()) && !hayLibros(B)) {
                System.out.println("Se agotaron los libros de " + B.getTitulo());
            }
            if (B.getTitulo().toUpperCase().equals(TL.toUpperCase()) && hayLibros(B)) {
                B.setEjemplaresPrestados(B.getEjemplaresPrestados() + 1);
            }
        }
        System.out.println("___________________________________");
    }

    private void devolucion() {
        String TL;
        System.out.println("Título del libro : ");
        TL = leer.next();
        Iterator<Libro> I = Libreria.iterator();
        while (I.hasNext()) {
            Libro B = I.next();
            if (B.getTitulo().toUpperCase().equals(TL.toUpperCase()) && agotados(B)) {
                B.setEjemplaresPrestados(B.getEjemplaresPrestados() - 1);
            }
            if (B.getTitulo().toUpperCase().equals(TL.toUpperCase()) && !agotados(B)) {
                System.out.println("No hay ejemplares prestados de " + B.getTitulo());
            }
        }
        System.out.println("___________________________________");
    }

    private void mostrar() {
        ArrayList<Libro> AL = new ArrayList(Libreria);
        Collections.sort(AL, Ordenar);
        Iterator<Libro> I = AL.iterator();
        while (I.hasNext()) {
            Libro B = I.next();
            System.out.println(B.toString());
        }
        System.out.println("___________________________________");
    }
//    private void mostrarT(){
//        TreeSet<Libro> TL = new TreeSet(Libro.Ordenar);
//        TL.addAll(Libreria);
//        Iterator<Libro> I = TL.iterator();
//        while(I.hasNext()){
//            Libro B = I.next();
//            System.out.println(B.toString());
//        }
//    }

    public void biblioteca() {
        int R;
        System.out.println("Crear libreria.");
        crearLibreria();
        do {
            System.out.println("¿Quiere pedir prestado o devolver un libro?");
            System.out.println("     1)Pedir prestado.");
            System.out.println("     2)Devolver un libro.");
            System.out.println("     3)Mostrar libros.");
            System.out.println("     4)Para terminar.");
            R = leer.nextInt();
            System.out.println("___________________________________");
            switch (R) {
                case 1:
                    prestamo();
                    break;
                case 2:
                    devolucion();
                    break;
                case 3:
                    mostrar();
//                System.out.println("---------------------");
//                mostrarT();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("¿...?");
                    break;
            }
        } while (R != 4);
    }
}
