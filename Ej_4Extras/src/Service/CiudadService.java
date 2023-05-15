package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CiudadService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    HashMap<Integer, String> Ciudad = new HashMap();

    private HashMap<Integer, String> crearHashMap() {
        String N, E = "";
        int C, diez = 0;
        System.out.println("Escriba 10 ciudades con sus respectivos códigos postales.");
        do {
            System.out.print("Nombre : ");
            N = leer.next();
            System.out.print("Código postal : ");
            C = leer.nextInt();
            if (Ciudad.containsKey(C)) {
                System.out.println("Otra ciudad ya posee ese código postal.");
                diez = diez;
            } else {
                Ciudad.put(C, N);
                diez = diez + 1;
            }
        } while (diez < 10);
        System.out.println("Se introdujeron estas 10 ciudades con sus códigos.");
        for (Map.Entry<Integer, String> entry : Ciudad.entrySet()) {
            for (int i = 0; i < 20 - entry.getValue().length(); i++) {
                E = E + " ";
            }
            System.out.println(entry.getValue() + E + entry.getKey());
            E = "";
        }
        System.out.println("______________________________");
        return Ciudad;
    }

    private boolean aparece(int A) {
        return Ciudad.containsKey(A);
    }

    private boolean apareceNombre(String A) {
        return Ciudad.containsValue(A);
    }

    private void mostrarCiudad() {
        int R;
        System.out.println("Ingrese un código postal mostrar a que ciudad corresponde.");
        R = leer.nextInt();
        if (aparece(R)) {
            for (Map.Entry<Integer, String> entry : Ciudad.entrySet()) {
                if (entry.getKey() == R) {
                    System.out.println("El código postal " + entry.getKey() + " pertenece a la ciudad de " + entry.getValue());
                }
            }
        } else {
            System.out.println("No hay datos para ese código postal.");
        }
        System.out.println("______________________________");
    }

    private void mostrarDatos() {
        System.out.println("Ciudad              Código postal");
        for (Map.Entry<Integer, String> entry : Ciudad.entrySet()) {
            String E = "";
            for (int i = 0; i < 20 - entry.getValue().length(); i++) {
                E = E + " ";
            }
            System.out.println(" -" + entry.getValue() + E + entry.getKey());
            E = "";
        }
        System.out.println("______________________________");
    }

    private void agregar() {
        System.out.print("Nombre : ");
        String N = leer.next();
        System.out.print("Código postal : ");
        int C = leer.nextInt();
        if (Ciudad.containsKey(C)) {
            System.out.println("Otra ciudad ya posee ese código postal.");
        } else {
            Ciudad.put(C, N);
        }
        System.out.println("______________________________");
    }

    private void eliminar() {
        System.out.println("Nombre de la ciudad ");
        String R = leer.next();
        if (apareceNombre(R)) {
            ArrayList<Integer> repetidos = new ArrayList();
            for (Map.Entry<Integer, String> entry : Ciudad.entrySet()) {
                if (entry.getValue().equals(R)) {
                    repetidos.add(entry.getKey());
                }
            }
            if (repetidos.size() >= 2) {
                System.out.println("Se encontraron " + repetidos.size() + " ciudades con ese nombre");
                System.out.println("Escriba el código postal de la ciudad que quiera eliminar.");
                Iterator<Integer> I = repetidos.iterator();
                while (I.hasNext()) {
                    int N = I.next();
                    System.out.println(" - " + N);
                }
                int Respuesta = leer.nextInt();
                Ciudad.remove(Respuesta);
            } else {
                Ciudad.remove(repetidos.get(0));
            }
            System.out.println("¡Ciudad eliminada correctamente!");
        } else {
            System.out.println("La ciudad " + R + " no se encuentra registrada.");
        }
        System.out.println("______________________________");
    }

    public void menu() {
        int R;
        crearHashMap();
        do {
            System.out.println("          MENU");
            System.out.println("     1)Mostrar ciudad de codigo a ingresar.");
            System.out.println("     2)Mostrar datos.");
            System.out.println("     3)Agregar ciudad y código postal correspondiente.");
            System.out.println("     4)Eliminar ciudad.");
            System.out.println("     5)Terminar programa.");
            R = leer.nextInt();
            switch (R) {
                case 1:
                    mostrarCiudad();
                    break;
                case 2:
                    mostrarDatos();
                    break;
                case 3:
                    agregar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    System.out.println("                    Programa terminado...");
                    break;
                default:
                    System.out.println(" Opción no encontrada.");
            }
        } while (R != 5);
    }
}
