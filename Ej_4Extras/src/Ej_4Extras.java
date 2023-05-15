
import Service.CiudadService;

/**
 * Almacena en un HashMap los códigos postales de 10 ciudades a elección de ésta
 * página: https://mapanet.eu/index.htm. Nota: Poner el código póstal sin la
 * letra, sólo el número. - Pedirle al usuario que ingrese 10 códigos postales y
 * sus ciudades. - Muestra por pantalla los datos introducidos. - Pide un código
 * postal y muestra la ciudad asociada si existe, sino avisa al usuario. -
 * Muestra por pantalla los datos. - Agrega una ciudad con su código postal
 * correspondiente más al HashMap. - Elimina 3 ciudades existentes dentro del H.
 */
public class Ej_4Extras {

    public static void main(String[] args) {
        CiudadService C = new CiudadService();
        C.menu();
    }
}
