package appi_dia_festivo.appi_dia_festivo.aplicacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Tipo;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.repositorios.ITipoRepositorio;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.ITipoServicio;

@Service
public class TipoServico  implements ITipoServicio{
    
    private ITipoRepositorio repositorio;

    public TipoServico(ITipoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public List<Tipo> listar(){
        return repositorio.findAll();
    }

    @Override
    public Tipo obtener(int id){
        Optional <Tipo> tipo = repositorio.findById(id);
        return tipo.isEmpty() ? null : tipo.get();
    }

}
