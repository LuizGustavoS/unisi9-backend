package br.com.si9.unisi9.controller;

import br.com.si9.unisi9.converter.ClienteConverter;
import br.com.si9.unisi9.dto.ClienteDTO;
import br.com.si9.unisi9.orm.Cliente;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteController {

    @Inject
    ClienteConverter clienteConverter;

    public ClienteDTO gravarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteConverter.dtoToOrm(clienteDTO);
        cliente.persist();
        return clienteConverter.ormToDto(cliente);
    }

    public ClienteDTO editarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteConverter.dtoToOrm(clienteDTO);
        cliente.persist();
        return clienteConverter.ormToDto(cliente);
    }

    public void deletarCliente(Integer idCliente){
        Cliente.findById(idCliente).delete();
    }

    public List<ClienteDTO> listarCliente(){
        List<Cliente> clientes = Cliente.listAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (Cliente cliente : clientes) {
            clientesDTO.add(clienteConverter.ormToDto(cliente));
        }

        return clientesDTO;
    }

}
