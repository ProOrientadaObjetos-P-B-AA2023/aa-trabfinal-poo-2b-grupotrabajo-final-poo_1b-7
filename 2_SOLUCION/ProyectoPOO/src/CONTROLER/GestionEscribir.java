package CONTROLER;

import MODEL.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class GestionEscribir {
    static Scanner sc = new Scanner(System.in);
    Formatter escribir;

    public GestionEscribir() throws FileNotFoundException {
        escribir = new Formatter(new File("GestionPlanes.csv"));
    }

    public void clientes(ArrayList<Cliente> clientes) throws FileNotFoundException {
        for (Cliente cliente : clientes) {
            escribir.format("nombre;cedula;ciudad;marca;modelo;numeroCelular%n");
            escribir.format("%s;%s;%s;%s;%s;%s%n", cliente.nombre, cliente.cedula, cliente.ciudad, cliente.marca, cliente.modelo, cliente.numeroCelular);
            if (cliente.economico.size() != 0) {
                escribirPlanEconomico(cliente.economico);
            } else if (cliente.medio.size() != 0) {
                escribirPlanMedio(cliente.medio);
            } else if (cliente.alto.size() != 0) {
                escribirPlanAlto(cliente.alto);
            } else if (cliente.premium.size() != 0) {
                escribirPlanPremiun(cliente.premium);
            }
            escribir.close();
        }
    }

    public void escribirPlanEconomico(ArrayList<PlanPostPagoMinutosMegasEconomico> economico) {
        escribir.format("minutos;costominutos;megas;costodeGiga;descuento;%n");
        for (PlanPostPagoMinutosMegasEconomico plan : economico) {
            escribir.format("%d;%.2f;%.2f;%.2f;%.2f%n", plan.minutos, plan.costoMinuto, plan.megas, plan.costoGiga, plan.descuento);
        }
    }

    public void escribirPlanMedio(ArrayList<PlanPostPagoMinutos> medio) {
        escribir.format("minutosnacionales;costominutosNacionales;minutosInternacionales;costoMinutosInternacionales%n");
        for (PlanPostPagoMinutos plan : medio) {
            escribir.format("%d;%.2f;%d;%.2f%n", plan.minutosNacionales, plan.costoMinutoNacional, plan.minutosInternacionales, plan.costoMinutosInternacionales);
        }
    }

    public void escribirPlanAlto(ArrayList<PlanPostPagoMegas> alto) {
        escribir.format("megas;costoGigas;tarifaBase%n");
        for (PlanPostPagoMegas plan : alto) {
            escribir.format("%.2f;%.2f;%.2f%n", plan.mega, plan.costoGiga, plan.tarifaBase);
        }
    }

    public void escribirPlanPremiun(ArrayList<PlanPostPagoMinutosMegas> premiun) {
        escribir.format("minutos;costoMinutos;megas;costoGiga%n");
        for (PlanPostPagoMinutosMegas plan : premiun) {
            escribir.format("%.2f;%.2f;%.2f;%.2f%n");
        }
    }

    public static Cliente buscarCliente(ArrayList<Cliente> clientes, String nombreBuscar) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreBuscar)) {
                return cliente;
            }
        }
        return null;
    }

    public static boolean eliminarCliente(ArrayList<Cliente> clientes, String nombreEliminar) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getNombre().equalsIgnoreCase(nombreEliminar)) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void presentarFactura(Cliente cliente) {
        System.out.println("FACTURA PARA EL CLIENTE: " + cliente.getNombre());
        System.out.println("Ingrese el plan adquirido");
        System.out.println("1: ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                PlanPostPagoMinutosMegasEconomico bajo = new PlanPostPagoMinutosMegasEconomico();
                System.out.println("Cedula: " + cliente.getCedula());
                System.out.println("Ciudad: " + cliente.getCiudad());
                System.out.println("Marca de celular: " + cliente.getMarca());
                System.out.println("Modelo de celular: " + cliente.getModelo());
                System.out.println("Numero celular: " + cliente.getNumeroCelular());
                System.out.println("Costo Total: " + bajo.calcularTotal());

                System.out.println("----- FIN DE LA FACTURA -----");
                break;
            case 2:
                PlanPostPagoMinutos medio = new PlanPostPagoMinutos();
                System.out.println("Cedula: " + cliente.getCedula());
                System.out.println("Ciudad: " + cliente.getCiudad());
                System.out.println("Marca de celular: " + cliente.getMarca());
                System.out.println("Modelo de celular: " + cliente.getModelo());
                System.out.println("Numero celular: " + cliente.getNumeroCelular());
                System.out.println("Costo Total: " + medio.calcularTotal());

                System.out.println("----- FIN DE LA FACTURA -----");
                break;
            case 3:
                PlanPostPagoMegas alto = new PlanPostPagoMegas();
                System.out.println("Cedula: " + cliente.getCedula());
                System.out.println("Ciudad: " + cliente.getCiudad());
                System.out.println("Marca de celular: " + cliente.getMarca());
                System.out.println("Modelo de celular: " + cliente.getModelo());
                System.out.println("Numero celular: " + cliente.getNumeroCelular());
                System.out.println("Costo Total: " + alto.calcularTotal());

                System.out.println("----- FIN DE LA FACTURA -----");
                break;
            case 4:
                PlanPostPagoMinutosMegas premium = new PlanPostPagoMinutosMegas();
                System.out.println("Cedula: " + cliente.getCedula());
                System.out.println("Ciudad: " + cliente.getCiudad());
                System.out.println("Marca de celular: " + cliente.getMarca());
                System.out.println("Modelo de celular: " + cliente.getModelo());
                System.out.println("Numero celular: " + cliente.getNumeroCelular());
                System.out.println("Costo Total: " + premium.calcularTotal());

                System.out.println("----- FIN DE LA FACTURA -----");
        }
    }
}
