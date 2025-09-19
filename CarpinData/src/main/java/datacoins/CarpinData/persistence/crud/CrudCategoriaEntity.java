package datacoins.CarpinData.persistence.crud;

import datacoins.CarpinData.persistence.entity.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudCategoriaEntity extends CrudRepository<CategoriaEntity, Long> {
    CategoriaEntity findFirstByNombre(String nombre);
}
