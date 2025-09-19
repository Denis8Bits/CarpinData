package datacoins.CarpinData.persistence.crud;

import datacoins.CarpinData.persistence.entity.MuebleEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMuebleEntity extends CrudRepository <MuebleEntity, Long> {
    //CRUD sustituye a DAO->Transacciones, o el Controller
    //MuebleEntity bsucarPorCOlor(String color);

    MuebleEntity findFirstByColor(String color);
}
