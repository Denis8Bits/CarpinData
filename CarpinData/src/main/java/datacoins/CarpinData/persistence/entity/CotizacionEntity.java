package datacoins.CarpinData.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Cotizacion")
@Data
public class CotizacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, unique = true, nullable = false)
    private Integer cantidad;

    @Column(length = 150, nullable = false)
    private BigDecimal total;

    @Column(length = 150, nullable = false)
    private String descripcion;

}
