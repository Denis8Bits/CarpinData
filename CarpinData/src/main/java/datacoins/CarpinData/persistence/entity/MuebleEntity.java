package datacoins.CarpinData.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Mueble")
@Data
public class MuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, unique = true, nullable = false)
    private String color;
    @Column(length = 150, nullable = false)
    private String tamaño;
    @Column(length = 150, nullable = false)
    private String estilo;
}
