package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Table(name = "empleado")
@Entity(name = "Emple")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apellido_paterno", length = 200, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 200, nullable = false)
    private String apellidoMaterno;

    @Column(name = "nombres", length = 200, nullable = false)
    private String nombres;

    @Column(name = "nro_hijos", nullable = false)
    private Integer nroHijos;

    @Column(name = "sueldo", nullable = false)
    private Double sueldo;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    public Long getId() {
        return id;
    }

    public Empleado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public Empleado setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
        return this;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public Empleado setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
        return this;
    }

    public String getNombres() {
        return nombres;
    }

    public Empleado setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public Integer getNroHijos() {
        return nroHijos;
    }

    public Empleado setNroHijos(Integer nroHijos) {
        this.nroHijos = nroHijos;
        return this;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public Empleado setSueldo(Double sueldo) {
        this.sueldo = sueldo;
        return this;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }


    public Empleado setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

// Respuesta:
    @Override
    public String toString() {
        return String.format("Empleado ID: %d %s %s %s | hijos: %d | fechaNacimiento: %s | sueldo: %.2f", id, nombres, apellidoPaterno, apellidoMaterno, nroHijos, fechaNacimiento, sueldo);
    }
}
