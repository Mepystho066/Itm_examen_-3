package appi_dia_festivo.appi_dia_festivo.controlador;

//import java.util.Calendar;
//import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;
import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.IFestivoServicio;
//import appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios.ICalculosFechas;

@RestController
@RequestMapping("api/festivo")
public class FestivoControlador {
      
    public IFestivoServicio servicio;
    public FestivoControlador(IFestivoServicio servicio){
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    }
    
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Festivo obtener(@PathVariable int id ){
        return servicio.obtener(id);
    }

    @RequestMapping(value ="/agregar",method = RequestMethod.POST)
    public Festivo agregar(@RequestBody Festivo festivo){
        return servicio.agregar(festivo);

    }
    
    @RequestMapping(value ="/modificar",method = RequestMethod.PUT)
    public Festivo modificar(@RequestBody Festivo festivo){
        return servicio.modificar(festivo);

    }

    @RequestMapping(value ="/eliminar/{id}",method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable int id){
        return servicio.eliminar(id);
    }

    @RequestMapping(value ="/buscar/{nombre}",method = RequestMethod.GET)
    public  List<Festivo> buscar(@PathVariable String nombre){
        return servicio.buscar(nombre);

    }

    //@RequestMapping(value = "/domingosRamos/{año}", method = RequestMethod.GET)
    //public static Date domingoRamos(@PathVariable int año){
    //    return ICalculosFechas.domingoRamos(año);
    //}
//
//    public static Date agregarDias( Date fecha,int dia){
//
//     
//    }

//    public static Date siguienteLunes(Date fecha, int dia){
//    }

}
