package datacoins.CarpinData.persistence.crud;

import datacoins.CarpinData.persistence.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudClienteEntity extends CrudRepository<ClienteEntity, Long> {

    ClienteEntity findFirstByNombre(String nombre);
}
