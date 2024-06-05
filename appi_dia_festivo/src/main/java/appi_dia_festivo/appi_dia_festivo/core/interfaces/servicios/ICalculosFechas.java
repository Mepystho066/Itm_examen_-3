package appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios;

import java.util.Date;

import org.hibernate.mapping.List;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;
import appi_dia_festivo.appi_dia_festivo.core.dominio.Tipo;

import java.util.Calendar;

public class ICalculosFechas {
    
    /// Me toco por esto
     @SuppressWarnings("deprecation")
    public static Date domingoRamos(int año){
        
        int a = año % 19 ;          
        int b = año % 4;        
        int c = año % 7 ;             
        int d = (19*a + 24 ) % 30  ;  

        int dias = d +(2*b+4*c+6*d+5)% 7;
        
        int dia = 15 +dias;
        int mes = 3 ;
        
        if (dia > 31 ){
            dia = dias -31 ;
            mes  = 4 ; 
        }
            return new Date(año -1900, mes-1, dia); 
    }

    public static Date agregarDias( Date fecha,int dia){

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE ,dia); 

        return calendario.getTime(); 
    }

    
    public static Date siguienteLunes(Date fecha){

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        if(calendario.get(Calendar.DAY_OF_WEEK) > Calendar.MONDAY){
            fecha  = agregarDias(fecha, 9-calendario.get(Calendar.DAY_OF_WEEK)); 
        }
        else {
            fecha = agregarDias(fecha, 40);
        }
        return fecha;
    }

    //Logica de la base de datos y las tablas  esta es la que se debe mostrar al listar 

    public static String verificar(int año){
        
        /// No se va a necesitar dado que en el Fontend se puede hacer la consula con logica 
        Tipo tipo = new Tipo();
        Festivo festivo = new Festivo();
        
        // 1 solo se modifica el año 
        String tabla_tipo = tipo.getTipo();
        
        String test = "dia " +festivo.getDia()+ " tipo "+ festivo.getTipo() + "";

        // listar  toda la cada las columnas, utilizar 
        int [] datos =  {año};

        
        // se debe hacer primero la logica que selecciona la tabla tipo que se requiere 

        return test; 



    }


}
