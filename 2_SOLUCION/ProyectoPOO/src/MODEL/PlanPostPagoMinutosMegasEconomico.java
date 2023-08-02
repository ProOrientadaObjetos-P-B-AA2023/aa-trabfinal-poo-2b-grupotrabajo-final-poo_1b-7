package MODEL;

public class PlanPostPagoMinutosMegasEconomico extends Planes{
    public int minutos;
    public double costoMinuto;
    public double megas;
    public double costoGiga;
    public double descuento;

    public PlanPostPagoMinutosMegasEconomico() {
        this.minutos = 150;
        this.costoMinuto = 0.15;
        this.megas = 4000;
        this.costoGiga = 0.18;
        this.descuento = 15;
        this.tipo = "1";
    }

    public double calcularTotal(){
        return (minutos * costoMinuto) + (megas * costoGiga) - ((minutos * costoMinuto) + (megas * costoGiga) * (descuento / 100));
    }

    @Override
    public String toString() {
        return "PlanPostPagoMinutosMegasEconomico{" +
                "minutos=" + minutos +
                ", costoMinuto=" + costoMinuto +
                ", megas=" + megas +
                ", costoGiga=" + costoGiga +
                ", descuento=" + descuento +
                '}' + super.toString();
    }
}
