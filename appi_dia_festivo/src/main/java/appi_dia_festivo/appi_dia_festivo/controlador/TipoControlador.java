package appi_dia_festivo.appi_dia_festivo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Tipo;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.ITipoServicio;


@RestController
@RequestMapping("appi/tipo")
public class TipoControlador {
    
    public ITipoServicio tipo;
    public TipoControlador(ITipoServicio tipo){
        this.tipo = tipo;
    }

    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public List<Tipo> listar() {
        return tipo.listar();
    }
    
     @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Tipo obtener(@PathVariable int id ){
        return tipo.obtener(id);
    }
    

}
