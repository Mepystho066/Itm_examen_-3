package appi_dia_festivo.appi_dia_festivo.core.dominio;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivo")
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_dias")
    @GenericGenerator(name = "Secuencia_dias_festivos", strategy = "increment")
    private int id;

    @Column(name = "nombre", length = 100, unique = true)
    private String nombre;
    @Column(name = "dia", length = 100, unique = false)
    private int dia;
    @Column(name = "mes", length = 100, unique = false)
    private int mes;
    @Column(name = "diapascua", length = 100, unique = false)
    private int diapascua;
    @ManyToAny
    @JoinColumn(name = "idtipo",referencedColumnName = "id")
    private int idtipo;
    
    public Festivo(int id, String nombre, int dia, int mes, int diapascua, int idtipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diapascua = diapascua;
        this.idtipo = idtipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDiapascua() {
        return diapascua;
    }

    public void setDiapascua(int diapascua) {
        this.diapascua = diapascua;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }
    


}
