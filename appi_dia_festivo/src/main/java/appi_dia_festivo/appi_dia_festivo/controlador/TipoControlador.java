package appi_dia_festivo.appi_dia_festivo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;
import appi_dia_festivo.appi_dia_festivo.core.dominio.Tipo;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.ITipoServicio;


@RestController
@RequestMapping("api/tipo")
public class TipoControlador {
    
    public ITipoServicio servicio;
    public TipoControlador(ITipoServicio servicio){
        this.servicio= servicio;
    }

    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public List<Tipo> listar() {
        return servicio.listar();
    }
    
     @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Tipo obtener(@PathVariable int id ){
        return servicio.obtener(id);
    }
    
    @RequestMapping(value ="/buscar/{nombre}",method = RequestMethod.GET)
    public  List<Tipo> buscar(@PathVariable String tipo){
        return servicio.buscar(tipo);

    }

}
