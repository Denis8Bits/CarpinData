package datacoins.CarpinData.persistence.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Tipo")
@Data
public class TipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTipo estado;

    public enum EstadoTipo {
        DISPONIBLE,
        NO_DISPONIBLE
    }
}