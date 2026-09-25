package ar.edu.unahur.obj2.cafeteria.configuracion;

public class ConfiguracionCafeteria {
    
    private static ConfiguracionCafeteria instancia;
    private Double porcentajeCargoServicio;
    private Double porcentajeImpuestos;

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

    public void setPorcentajeCargoServicio(Double porcentajeCargoServicio) {
        this.porcentajeCargoServicio = porcentajeCargoServicio;
    }

    public Double getPorcentajeImpuestos() {
        return porcentajeImpuestos;
    }

    public void setPorcentajeImpuestos(Double porcentajeImpuestos) {
        this.porcentajeImpuestos = porcentajeImpuestos;
    }

    
}
