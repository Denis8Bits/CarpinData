package datacoins.CarpinData.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoria")  // Asegúrate de que el nombre coincida exactamente
@Data
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // Si tu columna se llama diferente, especifícalo aquí
    private Long id;

    @Column(length = 150, nullable = false)
    private String nombre;

    @Column(length = 300)
    private String descripcion;

    @Column(length = 50, nullable = false)
    private String estado;
}