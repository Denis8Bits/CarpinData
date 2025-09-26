package datacoins.CarpinData.persistence;

import datacoins.CarpinData.dominio.dto.ClienteDto;
import datacoins.CarpinData.dominio.dto.ModClienteDto;
import datacoins.CarpinData.dominio.exception.ClienteNoExisteException;
import datacoins.CarpinData.dominio.repository.ClienteRepository;
import datacoins.CarpinData.persistence.crud.CrudClienteEntity;
import datacoins.CarpinData.persistence.entity.ClienteEntity;
import datacoins.CarpinData.web.mapper.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteEntityRepository implements ClienteRepository {

    private final CrudClienteEntity crudCliente;
    private final ClienteMapper clienteMapper;

    public ClienteEntityRepository(CrudClienteEntity crudCliente, ClienteMapper clienteMapper) {
        this.crudCliente = crudCliente;
        this.clienteMapper = clienteMapper;
    }


    @Override
    public List<ClienteDto> obtenerTodo() {
        return this.clienteMapper.toDto(this.crudCliente.findAll());
    }

    @Override
    public ClienteDto obtenerClientePorCodigo(Long codigo) {
        ClienteEntity clienteEntity = this.crudCliente.findById(codigo).orElse(null);
        if (clienteEntity == null) throw new ClienteNoExisteException(codigo);
        return this.clienteMapper.toDto(clienteEntity);
    }

    @Override
    public ClienteDto guardarCliente(ClienteDto clienteDto) {
        if (this.clienteMapper)
    }

    @Override
    public ClienteDto modificarCliente(Long codigo, ModClienteDto modClienteDto) {
        return null;
    }

    @Override
    public void eliminarCliente(Long codigo) {

    }
}
