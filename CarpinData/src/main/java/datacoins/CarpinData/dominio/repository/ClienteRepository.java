package datacoins.CarpinData.dominio.repository;

import datacoins.CarpinData.dominio.dto.ClienteDto;
import datacoins.CarpinData.dominio.dto.ModClienteDto;

import java.util.List;

public interface ClienteRepository {
    List<ClienteDto> obtenerTodo();
    ClienteDto obtenerClientePorCodigo(Long codigo);
    ClienteDto guardarCliente(ClienteDto clienteDto);
    ClienteDto modificarCliente(Long codigo, ModClienteDto modClienteDto);
    void eliminarCliente(Long codigo);
}