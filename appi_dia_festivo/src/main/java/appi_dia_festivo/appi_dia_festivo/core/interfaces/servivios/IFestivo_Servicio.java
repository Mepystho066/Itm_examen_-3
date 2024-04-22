package appi_dia_festivo.appi_dia_festivo.core.interfaces.servivios;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;
import java.util.List;

public interface IFestivo_Servicio {

    public List<Festivo> listar();

    public Festivo obtener(int id);

    public List<Festivo> buscar(String nombre);

    public Festivo agregar(Festivo Festivo);

    public Festivo modificar(Festivo Festivo);

    public boolean eliminar(int id);

}
