package MODEL;

public class PlanPostPagoMinutos  extends Planes{
    public int minutosNacionales;
    public double costoMinutoNacional;
    public int minutosInternacionales;
    public double costoMinutosInternacionales;

    public PlanPostPagoMinutos() {
        this.minutosNacionales = 150;
        this.costoMinutoNacional = 0.15;
        this.minutosInternacionales = 300;
        this.costoMinutosInternacionales = 0.25;
        this.tipo = "2";
    }

    public double calcularTotal(){
        return (minutosNacionales * costoMinutoNacional) + (minutosInternacionales * costoMinutosInternacionales);
    }

    @Override
    public String toString() {
        return "PlanPostPagoMinutos{" +
                "minutosNacionales=" + minutosNacionales +
                ", costoMinutoNacional=" + costoMinutoNacional +
                ", minutosInternacionales=" + minutosInternacionales +
                ", costoMinutosInternacionales=" + costoMinutosInternacionales +
                '}' + super.toString();
    }
}
