/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
los servicios en la clase correspondiente)
Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
cómo se ordena un conjunto.
Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
al usuario.
 */
package Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class PaisService {

    private HashSet<String> paises = new HashSet();
    Scanner scn = new Scanner(System.in).useDelimiter("\n");

    public void cargarPaises() {

        boolean otro = true;

        while (otro) {
            System.out.println("Ingrese el nombre de un pais");
            String pais = scn.next();
            if (contiene(pais)) {
                System.out.println("El pais ingresado ya esta en la lista");
            } else {
                paises.add(pais);
            }
            System.out.println("Desea agregar otro pais? (S/N)");
            String resp = scn.next();
            if (resp.equalsIgnoreCase("n")) {
                otro = false;
                System.out.println("saliendo...");
            } else if (!resp.equalsIgnoreCase("s")) {
                System.out.println("era S o N, saliendo..");
                otro = false;
            }
        }

    }

    public void mostrarPaises() {
        System.out.println("Los paises ingresados son:");
        TreeSet<String> paisesSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        paisesSet.addAll(paises);
        paisesSet.forEach((pais) -> {
            System.out.println(pais);
        });
    }

    public void eliminarPais() {
        System.out.println("Ingrese un país a eliminar");
        String eliminar = scn.next().toLowerCase();
        if (contiene(eliminar)) {
            Iterator it = paises.iterator();
            while (it.hasNext()) {
                if (it.next().equals(eliminar)) {
                    System.out.println("El pais "+eliminar+" sera eliminado");
                    it.remove();
                }
            }
        } else {
            System.out.println("El pais ingresado no se encuentra en la lista");
        }
        mostrarPaises();
    }

    private boolean contiene(String ingresar) {
        boolean tiene = false;
        for (String pais : paises) {
            if (pais.equalsIgnoreCase(ingresar)) {
                tiene = true;
            }
        }
        return tiene;
    }

}
