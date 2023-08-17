/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:

• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
pantalla.
• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package Service;

import Entidad.Pelicula;
import static Entidad.Pelicula.compararDirector;
import static Entidad.Pelicula.compararDuracion;
import static Entidad.Pelicula.compararTitulo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PeliculaService {

    Scanner scn = new Scanner(System.in).useDelimiter("\n");

    ArrayList<Pelicula> peliculasList = new ArrayList();

    public void crarPelicula() {

        boolean crearOtra = true;

        while (crearOtra) {
            Pelicula pelicula = new Pelicula();
            System.out.println("Ingrese el nombre de la pelicula");
            pelicula.setTitulo(scn.next());
            System.out.println("Ingrese el nombre del director");
            pelicula.setDirector(scn.next());
            System.out.println("Ingrese la duracion en horas");
            pelicula.setDuracion(scn.nextDouble());
            peliculasList.add(pelicula);
            System.out.println("Desea agregar otra pelicula?");
            System.out.println("1= SI  2=NO");
            int resp = scn.nextInt();
            if (resp == 2) {
                crearOtra = false;
                System.out.println("SALIENDO...");
            }

        }

    }

    public void mostrarPeliculas() {
        peliculasList.forEach((pelicula) -> {
            System.out.println(pelicula.getTitulo() + " ----- Director: " + pelicula.getDirector() + " ----- Duracion: " + pelicula.getDuracion());
        });
    }

    public void mayores1() {
        System.out.println("PELICULAS DE MAS DE 1 HORA: ");
        mostrarPeliculas();
    }

    public void mayorAmenor() {
        Collections.sort(peliculasList, compararDuracion);
        System.out.println("PELICULAS DE MAYOR A MENOR:");
        mostrarPeliculas();
    }

    public void menorAmayor() {
        Collections.sort(peliculasList, compararDuracion.reversed());
        System.out.println("PELICULAS DE MENOR A MAYOR:");
        mostrarPeliculas();
    }

    public void ordenarTitulo() {
        Collections.sort(peliculasList, compararTitulo);
        System.out.println("PELICULAS POR TITULO: ");
        mostrarPeliculas();
    }

    public void ordenarDirector() {
        Collections.sort(peliculasList, compararDirector);
        System.out.println("PELICULAS POR DIRECTOR: ");
        mostrarPeliculas();
    }
}
