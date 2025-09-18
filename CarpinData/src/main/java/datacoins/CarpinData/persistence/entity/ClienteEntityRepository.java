package datacoins.CarpinData.persistence.entity;

import datacoins.CarpinData.dominio.dto.ClienteDto;
import datacoins.CarpinData.dominio.dto.ModClienteDto;
import datacoins.CarpinData.dominio.repository.ClienteRepository;
import datacoins.CarpinData.persistence.crud.CrudClienteEntity;
import datacoins.CarpinData.web.mapper.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteEntityRepository implements ClienteRepository {

    private final CrudClienteEntity crudCliente;
    private final ClienteMapper clienteMapper;

    public ClienteEntityRepository(CrudClienteEntity crudCliente, ClienteMapper clienteMapper){
        this.crudCliente = crudCliente;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDto> obtenerTodo() {
        return List.of();
    }

    @Override
    public ClienteDto obtenerClientePorCodigo(Long codigo) {
        return null;
    }

    @Override
    public ClienteDto guardarCliente(ClienteDto clienteDto) {
        return null;
    }

    @Override
    public ClienteDto modificarCliente(Long codigo, ModClienteDto modClienteDto) {
        return null;
    }

    @Override
    public void eliminarCliente(Long codigo) {

    }
}
