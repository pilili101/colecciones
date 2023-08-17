/*
Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
con sus 3 notas.
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 */
package Service;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlumnoService {

    Scanner scn = new Scanner(System.in);
    Alumno alumno = new Alumno();
    ArrayList<Alumno> alumnos = new ArrayList();

    public void crearAlumno() {
        boolean crearOtro = true;

        while (crearOtro) {
            ArrayList<Integer> notasService = new ArrayList<Integer>();
            System.out.println("Ingrese el nombre del alumno");
            String nombre = scn.next();
            System.out.println("Ingrese la nota 1");
            notasService.add(scn.nextInt());
            System.out.println("Ingrese la nota 2");
            notasService.add(scn.nextInt());
            System.out.println("Ingrese la nota 3");
            notasService.add(scn.nextInt());
            Alumno a1 = new Alumno(nombre, notasService);
            alumnos.add(a1);
            System.out.println("Desea agregar otro alumno?");
            System.out.println("ingrese 1 para agregar / 2 para salir");
            int resp = scn.nextInt();
            if (resp == 1) {
                crearOtro = true;
            } else if (resp == 2) {
                crearOtro = false;
                System.out.println("saliendo...");
            } else {
                System.out.println("Era solo 1 o 2, saliendo...");
                crearOtro = false;
            }
        }
//        alumnos.add(alumno);
//        if (alumnos.isEmpty()) {
//            System.out.println("esta vaciiio vees?");
//        } else {
//            System.out.println("la arraylist tipo alumno si tiene algo");
//        }
    }

    /*
    Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
     */
    public double notaFinal(String buscar) {
        double suma = 0;
        double promedio = -1;
        for (Alumno a1 : alumnos) {
            if (a1.getNombre().equalsIgnoreCase(buscar)) {
                for (Integer nota : a1.getNotas()) {
                    suma += nota;
                }
                promedio = suma / 3;
            }

        }
        return promedio;

    }

}
