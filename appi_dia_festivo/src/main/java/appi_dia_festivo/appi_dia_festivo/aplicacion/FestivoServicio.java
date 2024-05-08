package appi_dia_festivo.appi_dia_festivo.aplicacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.repositorios.IFestivoRepositorio;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.IFestivoServicio;

@Service
public class FestivoServicio implements IFestivoServicio{
    
    private IFestivoRepositorio repositorio;
    private FestivoServicio(IFestivoRepositorio repositorio){
        this.repositorio =repositorio;
    }

    @Override
    public List<Festivo> listar() {
        return repositorio.findAll();
    }

    @Override
    public Festivo obtener(int id) {
        Optional <Festivo> festivo = repositorio.findById(id);
        return festivo.isEmpty() ? null : festivo.get();
    }
    
    
}
