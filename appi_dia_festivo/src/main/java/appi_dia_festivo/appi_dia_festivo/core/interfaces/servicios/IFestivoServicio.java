package appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios;

import java.util.Date;
import java.util.List;


import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;

public interface IFestivoServicio {
    
    
    public List<Festivo> listar();    
    public Festivo obtener(int id);
    public List<Festivo> buscar(String nombre);
    public Festivo agregar(Festivo festivo);
    public Festivo modificar(Festivo festivo);
    public boolean eliminar(int id);
    public List logica(int año);
    public boolean verificar(Date fecha);
}
