package datacoins.CarpinData.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Categoria")
@Data
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Categoria;

    @Column(length = 150, unique = true, nullable = false)
    private String nombre;

    @Column(length = 60, nullable = false)
    private String descripcion;

    @Column(length = 40, nullable = false)
    private String estado;//varchar(40)

}
