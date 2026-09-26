package ar.edu.unahur.obj2.cafeteria.configuracion;

public class ConfiguracionCafeteria {
    
    private static ConfiguracionCafeteria instancia;
    private double porcentajeCargoServicio;
    private double porcentajeImpuestos;

    private ConfiguracionCafeteria(){}

    public static ConfiguracionCafeteria getInstancia(){
        if (instancia == null){
            instancia = new ConfiguracionCafeteria();
        }
        return instancia;
    }

    public Double getPorcentajeCargoServicio() {
        return porcentajeCargoServicio;
    }

    public void setPorcentajeCargoServicio(int porcentajeCargoServicio) {
        this.porcentajeCargoServicio = porcentajeCargoServicio;
    }

    public Double getPorcentajeImpuestos() {
        return porcentajeImpuestos;
    }

    public void setPorcentajeImpuestos(int porcentajeImpuestos) {
        this.porcentajeImpuestos = porcentajeImpuestos;
    }

    
}
