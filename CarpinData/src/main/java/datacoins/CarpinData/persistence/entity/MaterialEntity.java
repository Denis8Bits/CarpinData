package datacoins.CarpinData.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Material")
@Data
public class MaterialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String nombre;

    @Column(length = 255, nullable = false)
    private String descripcion;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal costo;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(length = 1, nullable = false)
    private String estado;
}
