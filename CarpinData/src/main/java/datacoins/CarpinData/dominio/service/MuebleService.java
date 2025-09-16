package datacoins.CarpinData.dominio.service;

import datacoins.CarpinData.dominio.dto.ModMuebleDto;
import datacoins.CarpinData.dominio.dto.MuebleDto;
import datacoins.CarpinData.dominio.repository.MuebleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de muebles.
 *
 * Encapsula la lógica de negocio y delega las operaciones de persistencia en
 * {@link MuebleRepository}.
 *
 * Nota:
 * - Las validaciones de los DTOs (ej. @NotBlank, @Size) deben realizarse en el Controller
 *   mediante @Valid; aquí asumimos que los DTOs ya vienen validados.
 * - Las excepciones específicas (p. ej. MuebleNoExisteException, MuebleYaExisteException)
 *   deben lanzarse desde el repositorio o desde este servicio según corresponda.
 */
@Service
public class MuebleService {

    private final MuebleRepository muebleRepository;

    public MuebleService(MuebleRepository muebleRepository){
        this.muebleRepository = muebleRepository;
    }

    /**
     * Obtiene la lista de todos los muebles registrados.
     *
     * @return lista de {@link MuebleDto} con todos los muebles.
     */
    public List<MuebleDto> obtenerTodo(){
        return this.muebleRepository.obtenerTodo();
    }

    /**
     * Obtiene un mueble por su código único.
     *
     * @param codigo identificador único del mueble.
     * @return {@link MuebleDto} correspondiente al código solicitado.
     * @throws RuntimeException (por ejemplo MuebleNoExisteException) si no se encuentra el mueble.
     */
    public MuebleDto obtenerMueblePorCodigo(Long codigo){
        return this.muebleRepository.obtenerMueblePorCodigo(codigo);
    }

    /**
     * Crea/guarda un nuevo mueble en el sistema.
     *
     * @param muebleDto datos del mueble a crear (se espera que estén validados).
     * @return {@link MuebleDto} del mueble creado (puede incluir el id generado).
     * @throws RuntimeException (por ejemplo MuebleYaExisteException) si ya existe un mueble conflictivo.
     */
    public MuebleDto guardarMueble(MuebleDto muebleDto){
        return this.muebleRepository.guardarMueble(muebleDto);
    }

    /**
     * Modifica un mueble existente.
     *
     * @param codigo       identificador del mueble a modificar.
     * @param modMuebleDto datos nuevos del mueble (se espera que estén validados).
     * @return {@link MuebleDto} con los datos actualizados.
     * @throws RuntimeException (por ejemplo MuebleNoExisteException) si el mueble no existe.
     */
    public MuebleDto modificarMueble(Long codigo, ModMuebleDto modMuebleDto){
        return this.muebleRepository.modificarMueble(codigo, modMuebleDto);
    }

    /**
     * Elimina un mueble por su código.
     *
     * @param codigo identificador del mueble a eliminar.
     * @throws RuntimeException (por ejemplo MuebleNoExisteException) si no existe el mueble.
     */
    public void eliminarMueble(Long codigo){
        this.muebleRepository.eliminarMueble(codigo);
    }

}
