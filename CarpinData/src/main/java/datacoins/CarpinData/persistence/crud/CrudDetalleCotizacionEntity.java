package datacoins.CarpinData.persistence.crud;

import datacoins.CarpinData.persistence.entity.DetalleCotizacionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDetalleCotizacionEntity extends CrudRepository<DetalleCotizacionEntity, Long> {
    DetalleCotizacionEntity findFirstByIdCotizacion(Long idCotizacion);
}