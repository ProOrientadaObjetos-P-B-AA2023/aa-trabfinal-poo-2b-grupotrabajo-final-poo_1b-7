package MODEL;

public class PlanPostPagoMinutosMegas extends Planes{
    public double minutos;
    public double costoMinutos;
    public double mega;
    public double costoGigas;

    public PlanPostPagoMinutosMegas() {
        this.minutos = 150;
        this.costoMinutos = 0.15;
        this.mega = 3000;
        this.costoGigas = 0.18;
        this.tipo = "4";

    }

    public double calcularTotal(){
        return (minutos * costoMinutos) + (mega * costoGigas);
    }

    @Override
    public String toString() {
        return "PlanPostPagoMinutosMegas{" +
                "minutos=" + minutos +
                ", costoMinutos=" + costoMinutos +
                ", mega=" + mega +
                ", costoGigas=" + costoGigas +
                '}' + super.toString();
    }
}
