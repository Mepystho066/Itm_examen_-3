package appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios;

import java.util.List;


import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;

public interface IFestivoServicio {
    
    
    public List<Festivo> listar();    
    public Festivo obtener(int id);
  

}
