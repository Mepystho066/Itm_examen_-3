package appi_dia_festivo.appi_dia_festivo.aplicacion;

import java.util.Date;
//import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.repositorios.IFestivoRepositorio;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.IFestivoServicio;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.ICalculosFechas;
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


    public Festivo agregar(Festivo festivo) {
        festivo.setId(0);
        return repositorio.save(festivo);
    }

    public Festivo modificar(Festivo festivo) {
        Optional <Festivo> festivoEncontrar = repositorio.findById(festivo.getId());
        return festivoEncontrar.isEmpty() ? null: repositorio.save(festivo);
    }

    @Override
    public List<Festivo> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public boolean eliminar(int id) {
        try{
            repositorio.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
    

    @Override
    public Date domingoRamos(int año) {
       return ICalculosFechas.domingoRamos(año);
    }

    @Override
    public Date agregarDias(Date fecha, int dia) {
        return ICalculosFechas.agregarDias(fecha, dia);
    }

    @Override
    public Date siguienteLunes(Date fecha, int dia) {
        return ICalculosFechas.siguienteLunes(fecha, dia);
    }
    
    
    
}
