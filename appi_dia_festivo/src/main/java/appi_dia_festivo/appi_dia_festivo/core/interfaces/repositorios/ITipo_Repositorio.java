package appi_dia_festivo.appi_dia_festivo.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Tipo;

public interface ITipo_Repositorio extends JpaRepository<Tipo, Integer>{
    
}
