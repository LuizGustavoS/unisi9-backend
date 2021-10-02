package br.com.si9.unisi9.converter;

import br.com.si9.unisi9.dto.ClienteDTO;
import br.com.si9.unisi9.enumeration.TipoCliente;
import br.com.si9.unisi9.orm.Cliente;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteConverter {

    public Cliente dtoToOrm(ClienteDTO clienteDTO){

        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setDsNome(clienteDTO.getDsNome());
        cliente.setDsCpf(clienteDTO.getDsCpf());
        cliente.setTipoCliente(TipoCliente.values()[clienteDTO.getTipoCliente()]);

        return cliente;
    }

    public ClienteDTO ormToDto(Cliente cliente){

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(cliente.getIdCliente());
        clienteDTO.setDsNome(cliente.getDsNome());
        clienteDTO.setDsCpf(cliente.getDsCpf());
        clienteDTO.setTipoCliente(cliente.getTipoCliente().ordinal());

        return clienteDTO;
    }

}
