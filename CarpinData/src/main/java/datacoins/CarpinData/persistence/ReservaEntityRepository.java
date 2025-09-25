package datacoins.CarpinData.persistence;

import datacoins.CarpinData.dominio.dto.ReservaDto;
import datacoins.CarpinData.dominio.dto.ModReservaDto;
import datacoins.CarpinData.dominio.exception.ReservaNoExisteException;
import datacoins.CarpinData.dominio.exception.ReservaYaExisteException;
import datacoins.CarpinData.dominio.repository.ReservaRepository;
import datacoins.CarpinData.persistence.crud.CrudReservaEntity;
import datacoins.CarpinData.persistence.entity.ReservaEntity;
import datacoins.CarpinData.web.mapper.ReservaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaEntityRepository implements ReservaRepository {

    private final CrudReservaEntity crudReserva;
    private final ReservaMapper reservaMapper;

    public ReservaEntityRepository(CrudReservaEntity crudReserva, ReservaMapper reservaMapper) {
        this.crudReserva = crudReserva;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public List<ReservaDto> obtenerTodo() {
        return this.reservaMapper.toDto(this.crudReserva.findAll());
    }

    @Override
    public ReservaDto obtenerReservaPorId(Long id) {
        ReservaEntity reservaEntity = this.crudReserva.findById(id)
                .orElseThrow(() -> new ReservaNoExisteException(id));
        return this.reservaMapper.toDto(reservaEntity);
    }

    @Override
    public ReservaDto guardarReserva(ReservaDto reservaDto) {
        // Validar si ya existe una reserva activa para el mismo mueble y usuario
        List<ReservaEntity> reservasUsuario = this.crudReserva.findByIdUsuario(reservaDto.idUsuario());
        List<ReservaEntity> reservasMueble = this.crudReserva.findByIdMueble(reservaDto.idMueble());

        boolean existeReservaActiva = reservasUsuario.stream()
                .anyMatch(r -> r.getIdMueble().equals(reservaDto.idMueble()) &&
                        "ACTIVA".equals(r.getEstado()));

        if (existeReservaActiva) {
            throw new ReservaYaExisteException("Usuario " + reservaDto.idUsuario() +
                    " ya tiene una reserva activa para el mueble " + reservaDto.idMueble());
        }

        ReservaEntity reservaEntity = this.reservaMapper.toEntity(reservaDto);

        // Si no viene un estado válido, se asigna por defecto
        if (reservaEntity.getEstado() == null || reservaEntity.getEstado().isBlank()) {
            reservaEntity.setEstado("ACTIVA");
        }

        this.crudReserva.save(reservaEntity);
        return this.reservaMapper.toDto(reservaEntity);
    }

    @Override
    public ReservaDto modificarReserva(Long id, ModReservaDto modReservaDto) {
        ReservaEntity reservaEntity = this.crudReserva.findById(id)
                .orElseThrow(() -> new ReservaNoExisteException(id));

        this.reservaMapper.modificarEntityFromDto(modReservaDto, reservaEntity);
        return this.reservaMapper.toDto(this.crudReserva.save(reservaEntity));
    }

    @Override
    public void eliminarReserva(Long id) {
        ReservaEntity reservaEntity = this.crudReserva.findById(id)
                .orElseThrow(() -> new ReservaNoExisteException(id));

        this.crudReserva.delete(reservaEntity);
    }
}