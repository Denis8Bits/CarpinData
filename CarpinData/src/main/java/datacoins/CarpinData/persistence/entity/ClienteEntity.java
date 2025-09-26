package datacoins.CarpinData.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Cliente")
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 100, unique = true, nullable = false)
    private String nombre;

    @Column(length = 100, unique = true, nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Integer telefono;

    @Column(length = 100, unique = true, nullable = false)
    private String genero;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 100, unique = true, nullable = false)
    private String correo;

    @Column(length = 100, unique = true, nullable = false)
    private String contraseña;

}