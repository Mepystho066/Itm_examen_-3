package appi_dia_festivo.appi_dia_festivo.aplicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    public List logica(int año) {
        List <Festivo> festivos = repositorio.findAll();
        List <Map<String, Object>> datos= new ArrayList<>();
        Date domingoRamos = ICalculosFechas.domingoRamos(año);
        Date domingoPascua = ICalculosFechas.agregarDias(domingoRamos, 7);
        for (Festivo festivo :festivos){
            Map<String, Object> ListaFestivos = new LinkedHashMap<>();
            if(festivo.getTipo().getId() == 1)
            {
                Date fecha = new Date(año-1900,festivo.getMes()-1,festivo.getDia());
                ListaFestivos.put("Festivo", festivo.getNombre());
                ListaFestivos.put("Fecha", fecha);
                datos.add(ListaFestivos);
            }
            else if(festivo.getTipo().getId() == 2)
            {
                // Se traslada al siguiente lunes
               Date fecha = ICalculosFechas.siguienteLunes(domingoPascua,festivo.getDia());
               ListaFestivos.put("Festivo", festivo.getNombre());
               ListaFestivos.put("Fecha", fecha);
               datos.add(ListaFestivos);
            }
            else if(festivo.getTipo().getId() == 3)
            {
                //Basadi domingo Pasuca
                Date fecha = ICalculosFechas.agregarDias(domingoPascua,festivo.getDia());
                ListaFestivos.put("Festivo", festivo.getNombre());
                ListaFestivos.put("Fecha", fecha);
                datos.add(ListaFestivos);
            }
            else if(festivo.getTipo().getId() == 4)
            {
                Date fecha = ICalculosFechas.siguienteLunes(domingoPascua,festivo.getDiapascua());
                // Domingo Pascua Y ley puente Festivo
                ListaFestivos.put("Festivo", festivo.getNombre());
                ListaFestivos.put("Fecha", fecha);
                datos.add(ListaFestivos);
            
            }
        
        }
        
        
        return datos;
    }

    @Override
    public boolean verificar(Date fecha) {
        for(Festivo festivolista: listar()){
            return false;
        }
        return false;

    }

    
    
}
