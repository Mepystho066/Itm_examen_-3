package appi_dia_festivo.appi_dia_festivo.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Festivo;

@Repository
public interface IFestivo_Repositorio extends JpaRepository <Festivo, Integer> {
    
}
