package datacoins.CarpinData.persistence.crud;

import datacoins.CarpinData.persistence.entity.ReservaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudReservaEntity extends CrudRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByIdUsuario(Long idUsuario);
    List<ReservaEntity> findByIdMueble(Long idMueble);
    List<ReservaEntity> findByEstado(String estado);
}