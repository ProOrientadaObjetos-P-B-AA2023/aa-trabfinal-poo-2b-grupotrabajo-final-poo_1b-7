package MODEL;

import java.util.ArrayList;

public class Cliente {
    public String nombre;
    public String cedula;
    public String ciudad;
    public String marca;
    public String modelo;
    public String numeroCelular;
    public ArrayList<PlanPostPagoMinutosMegasEconomico> economico;
    public ArrayList<PlanPostPagoMinutos> medio;
    public ArrayList<PlanPostPagoMegas> alto;
    public ArrayList<PlanPostPagoMinutosMegas> premium;


    public Cliente(String nombre, String cedula, String ciudad, String marca, String modelo, String numeroCelular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCelular = numeroCelular;
        economico = new ArrayList<>();
        medio = new ArrayList<>();
        alto = new ArrayList<>();
        premium = new ArrayList<>();
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                '}';
    }
}
