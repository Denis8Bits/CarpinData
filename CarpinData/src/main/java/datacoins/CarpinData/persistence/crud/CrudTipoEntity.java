package datacoins.CarpinData.persistence.crud;

import datacoins.CarpinData.persistence.entity.TipoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudTipoEntity extends CrudRepository <TipoEntity, Long> {
    //CRUD sustituye a DAO->Transacciones, o el Controller

    TipoEntity findFirstByNombre(String nombre);
}