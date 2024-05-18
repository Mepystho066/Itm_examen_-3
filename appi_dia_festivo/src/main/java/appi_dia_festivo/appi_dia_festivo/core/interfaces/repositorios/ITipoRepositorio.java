package appi_dia_festivo.appi_dia_festivo.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import appi_dia_festivo.appi_dia_festivo.core.dominio.Tipo;

@Repository
public interface ITipoRepositorio extends JpaRepository<Tipo, Integer> {
    @Query("SELECT c FROM Festivo c  WHERE c.nombre like '%' || ?1 || '%' ")
    public List<Tipo> buscar(String nombre);
}
