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
package Main;

import Service.AlumnoService;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        AlumnoService as = new AlumnoService();
        as.crearAlumno();
        System.out.println("Ingrese el alumno a buscar");
        String buscar = scn.next();
        double nota = as.notaFinal(buscar);
        if(nota==-1){
            System.out.println("no se encontro el alumno");
        }else{
            System.out.println("La nota final del alumno "+buscar+" es "+nota);
        }
       
      
    }
    
}
