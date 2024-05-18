package appi_dia_festivo.appi_dia_festivo.core.interfaces.servicios;

import java.util.Date;
import java.util.Calendar;

public class ICalculosFechas {
    

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

    
    public static Date siguienteLunes(Date fecha, int dia){

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




}
