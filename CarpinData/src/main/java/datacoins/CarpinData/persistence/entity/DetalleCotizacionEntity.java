package datacoins.CarpinData.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DetalleCotizacion")
@Data
public class DetalleCotizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_mueble", nullable = false)
    private Long idMueble;

    @Column(name = "id_cotizacion", nullable = false)
    private Long idCotizacion;
}