package MODEL;

public class PlanPostPagoMegas extends Planes{
    public double mega;
    public double costoGiga;
    public double tarifaBase;

    public PlanPostPagoMegas() {
        this.mega = 3000;
        this.costoGiga = 0.18;
        this.tarifaBase = 12;
        this.tipo = "3";
    }

    public double calcularTotal(){
        return (mega * costoGiga) + tarifaBase;
    }

    @Override
    public String toString() {
        return "PlanPostPagoMegas{" +
                "mega=" + mega +
                ", costoGiga=" + costoGiga +
                ", tarifaBase=" + tarifaBase +
                '}' + super.toString();
    }
}
