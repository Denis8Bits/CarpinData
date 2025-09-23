package datacoins.CarpinData.persistence.crud;

import datacoins.CarpinData.persistence.entity.CotizacionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudCotizacionEntity extends CrudRepository<CotizacionEntity, Long> {
    CotizacionEntity findFirstByCantidad(Integer cantidad);
}