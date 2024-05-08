package appi_dia_festivo.appi_dia_festivo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.IFestivoServicio;

@RestController
@RequestMapping("appi/festivo")
public class FestivoControlador {
      
    public IFestivoServicio festivo;
    public FestivoControlador(IFestivoServicio festivo){
        this.festivo = festivo;
    }

    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public List<Festivo> listar() {
        return festivo.listar();
    }
    
     @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Festivo obtener(@PathVariable int id ){
        return festivo.obtener(id);
    }
}
