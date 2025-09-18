package datacoins.CarpinData.persistence.crud;

import datacoins.CarpinData.persistence.entity.MaterialEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMaterialEntity extends CrudRepository<MaterialEntity, Long> {

    MaterialEntity findFirstByNombre(String nombre);
}
