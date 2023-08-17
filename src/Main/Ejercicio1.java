/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.

 */
package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        ArrayList<String> razas = new ArrayList();
        boolean guardarOtroPerro = true;
        int resp;
        Scanner scn = new Scanner(System.in).useDelimiter("\n");
        do {
            System.out.println("Ingrese el perro");
            razas.add(scn.next());
            System.out.println("1: ingresar un nuevo perro 2: salir");
            resp = scn.nextInt();
            if (resp == 1) {
                guardarOtroPerro = true;
            } else if (resp == 2) {
                guardarOtroPerro = false;
            } else {
                System.out.println("solo aceptamos 1 o 2 , te saco por tu error");
            }
        } while (guardarOtroPerro);
        
        System.out.println(razas.toString());
        System.out.println(" ");
        System.out.println("Ahora con iterator");
        
        Iterator it;
        it = razas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }

        /*
        Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
        un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
        está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
        ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
        la lista ordenada.
         */
        System.out.println("Ingrese raza buscada");
        String buscada = scn.next();
        int encontrada =0;
        //recorrer:
        while (it.hasNext()) {
            if (it.next().equals(buscada))  {
                encontrada++;
                it.remove();
                System.out.println("Ya se borro la raza ingresada:)");
            }
        }
        if (encontrada==0) {
            System.out.println("no se encontro esa raza");
        } 
        
        it=razas.iterator();
         while (it.hasNext()) {
            System.out.print(it.next() + " - ");
        }
         
         
         
         
         
         
         
    }
    
}
