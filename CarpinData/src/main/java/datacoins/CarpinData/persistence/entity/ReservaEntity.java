package datacoins.CarpinData.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@Data
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Reservas")
    private Long idReservas;

    @Column(name = "fecha_Reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(length = 50, nullable = false)
    private String estado;

    @Column(name = "id_Usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_Mueble", nullable = false)
    private Long idMueble;
}