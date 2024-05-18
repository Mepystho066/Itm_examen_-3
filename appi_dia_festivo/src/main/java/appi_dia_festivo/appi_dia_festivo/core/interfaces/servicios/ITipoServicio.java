package appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios;

import java.util.List;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Tipo;

public interface ITipoServicio {

    public List<Tipo> listar();    
    public Tipo obtener(int id);
    public List<Tipo> buscar(String tipo);
} 
    

