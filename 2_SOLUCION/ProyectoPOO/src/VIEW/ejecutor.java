package VIEW;

import CONTROLER.GestionEscribir;
import MODEL.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;

import static CONTROLER.GestionEscribir.buscarCliente;
import static CONTROLER.GestionEscribir.eliminarCliente;

public class ejecutor {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        Map<String, Integer> nmbresIngresados = new HashMap<>();
        boolean interruptor = true;
        while (interruptor) {
            System.out.println("---------GESTION DE TELEFONIA MOVIL----------");
            System.out.println("1: Agregar");
            System.out.println("2: Buscar");
            System.out.println("3: Actulizar");
            System.out.println("4: Eliminar");
            System.out.println("5: Factura");
            System.out.println("0: Salir");
            System.out.println("----------------------------------------------");
            System.out.print("Ingrese la opcion: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("AGREGAR");
                    System.out.println("Ingrese: nombre, cedula, ciudad, marca de celular, modelo de celular y numero celular");
                    String nombreClientes = sc.next().toLowerCase();
                    int vecesIngresados = nmbresIngresados.getOrDefault(nombreClientes, 0);
                    if (vecesIngresados < 3) {
                        clientes.add(new Cliente(nombreClientes, sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
                    } else {
                        System.out.println("Este usuario no puede volver a registrarse");
                    }
                    break;
                case 2:
                    System.out.println("BUSCAR");
                    System.out.println("Ingrese el nombre que desea buscar");
                    String nombreBuscar = sc.next().toLowerCase();
                    Cliente clienteEncontrado = buscarCliente(clientes, nombreBuscar);
                    if (clienteEncontrado != null) {
                            System.out.println("Cliente encontrado");
                            System.out.println(clienteEncontrado);
                        } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 3:
                    System.out.println("ACTUALIZAR");
                    System.out.print("Ingrese el nombre del cliente a actualizar: ");
                    String nombreActualizar = sc.next();
                    Cliente clienteEncontrad = buscarCliente(clientes, nombreActualizar);
                    if (clienteEncontrad != null) {
                        System.out.println("Cliente encontrado:");
                        System.out.println(clienteEncontrad);

                        System.out.println("Ingrese los nuevos datos del cliente:");
                        System.out.print("Cedula: ");
                        clienteEncontrad.setCedula(sc.next());
                        System.out.print("Ciudad: ");
                        clienteEncontrad.setCiudad(sc.next());
                        System.out.print("Marca de celular: ");
                        clienteEncontrad.setMarca(sc.next());
                        System.out.print("Modelo de celular: ");
                        clienteEncontrad.setModelo(sc.next());
                        System.out.print("Numero celular: ");
                        clienteEncontrad.setNumeroCelular(sc.next());
                        GestionEscribir gestionEscribir = new GestionEscribir();
                        gestionEscribir.clientes(clientes);
                    } else {
                        System.out.println("Cliente no encontrado. No se pudo actualizar.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del cliente a eliminar: ");
                    String nombreEliminar = sc.next();
                    boolean eliminado = GestionEscribir.eliminarCliente(clientes, nombreEliminar);
                    if (eliminado) {
                        System.out.println("Cliente eliminado correctamente.");
                    } else {
                        System.out.println("Cliente no encontrado. No se pudo eliminar.");
                    }
                    break;
                case 5:
                    System.out.println("FACTURA");
                    System.out.println("Ingrese el nombre del cliente para generar la factura:");
                    String nombreFactura = sc.next().toLowerCase();
                    Cliente clienteFactura = buscarCliente(clientes, nombreFactura);
                    if (clienteFactura != null) {
                        GestionEscribir.presentarFactura(clienteFactura);
                    } else {
                        System.out.println("Cliente no encontrado. No se pudo generar la factura.");
                    }
                    break;
                case 0:
                    System.out.println("---------VUELVA PRONTO----------");
                    interruptor = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;            }
        }
    }
}

