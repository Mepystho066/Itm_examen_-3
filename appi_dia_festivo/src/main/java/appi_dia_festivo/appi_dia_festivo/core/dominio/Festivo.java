package appi_dia_festivo.appi_dia_festivo.core.dominio;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivo")
public class Festivo {
    
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "Secuencia_de_festivo")
    @GenericGenerator(name = "Secuencia_de_festivo",strategy="increment")
    @Column(name = "id")
    private int id;

    @Column(name="Nombre")
    private String nombre;
    @Column(name="dia")
    private int dia;
    @Column(name="mes")
    private int mes;
    @Column(name="diaspascua")
    private int diapascua;
    
    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    @PrimaryKeyJoinColumn
    private Tipo tipo;

    public Festivo(){

    }

    public Festivo(int id, String nombre, int dia, int mes, int diapascua, Tipo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diapascua = diapascua;
        this.tipo = tipo;
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    

    
}
