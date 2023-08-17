/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
productos que venderemos y el precio que tendrán. Además, se necesita que la
aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductoService {

    HashMap<String, Double> productos = new HashMap();
    Scanner scn = new Scanner(System.in);

    public void tienda() {
        boolean menu = true;
        do {
            System.out.println("Seleccione la opcion deseada:");
            System.out.println("1) INGRESAR PRODUCTO");
            System.out.println("2) MODIFICAR PRECIO");
            System.out.println("3) ELIMINAR PRODUCTO");
            System.out.println("4) MOSTRAR PRODUCTOS");
            System.out.println("5) SALIR");
            int resp = scn.nextInt();

            switch (resp) {
                case 1: {
                    boolean ingresar = true;
                    do {
                        System.out.println("Ingrese el nombre del producto");
                        String nombre = scn.next();
                        System.out.println("Ingrese el precio del producto");
                        Double precio = scn.nextDouble();
                        productos.put(nombre, precio);
                        System.out.println("Desea seguir ingresando productos? (s/n)");
                        if (!salir(scn.next())) {
                            ingresar = false;
                        }
                    } while (ingresar);
                }
                break;
                case 2:
                    boolean modificar = true;
                    do {
                        System.out.println("Ingrese el nombre del producto que quiera modificar");
                        String llave = scn.next();
                        if (productos.containsKey(llave)) {
                            System.out.println("El precio era $" + productos.get(llave) + ". Ingrese el precio nuevo");
                            productos.put(llave, scn.nextDouble());
                        } else {
                            System.out.println("El producto ingresado no está en la lista");
                        }
                        System.out.println("Desea modificar otro producto? (S/N)");
                        if (!salir(scn.next())) {
                            modificar = false;
                        }
                    } while (modificar);
                    break;
                case 3:
                    boolean eliminar = true;
                    do {
                        System.out.println("Ingrese el producto que quiere eliminar");
                        String llave = scn.next();
                        if (productos.containsKey(llave)) {
                            System.out.println("El producto " + llave + " se eliminó");
                            productos.remove(llave);
                        } else {
                            System.out.println("El producto ingresado no esta en la lista");
                        }
                        System.out.println("Desea eliminar otro producto? (S/N)");
                        if (!salir(scn.next())) {
                            eliminar = false;
                        }
                    } while (eliminar);
                    break;
                case 4:
                    for (Map.Entry<String, Double> entry : productos.entrySet()) {
                        System.out.println(entry.getKey() + "----- Precio $" + entry.getValue());
                    }
                    System.out.println("Volviendo al menu principal...");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    menu = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta, saliendo...");
                    menu = false;
            }
        } while (menu);
    }

    private boolean salir(String resp) {
        boolean si = true;
        if (resp.equalsIgnoreCase("n")) {
            System.out.println("Volviendo al menu principal...");
            si = false;
        } else if (!resp.equalsIgnoreCase("s")) {
            System.out.println("Era S o N, volviendo al menu principal...");
            si = false;
        }
        return si;
    }

}
