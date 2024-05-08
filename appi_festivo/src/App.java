import java.util.Date;

import servicios.Servicio_festivo;

public class App {
    public static void main(String[] args) throws Exception {

        int año = 2024;
        Date domingoRamos = Servicio_festivo.getDomingoRamos(año);
        System.out.println("Domingo de ramos " + domingoRamos);
    
        Date domingoPascua= Servicio_festivo.agregarDias( domingoRamos, 7);
        System.out.println("Domingo de Pascua " + domingoPascua);
    
        Date asensionSeñor = Servicio_festivo.agregarDias(domingoPascua, 40);
        System.out.println("Asencion Señor "+ asensionSeñor);

    }




}
