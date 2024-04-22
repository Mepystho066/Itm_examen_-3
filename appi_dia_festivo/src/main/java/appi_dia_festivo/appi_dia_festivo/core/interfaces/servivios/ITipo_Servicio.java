package appi_dia_festivo.appi_dia_festivo.core.interfaces.servivios;

import java.util.List;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Tipo;

public interface ITipo_Servicio {
   
    public List<Tipo> listar();

    public Tipo obtener(int id);

    public List<Tipo> buscar(String nombre);

    public Tipo agregar(Tipo Festivo);

    public Tipo modificar(Tipo Festivo);

    public boolean eliminar(int id);



}
