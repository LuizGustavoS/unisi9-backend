package br.com.si9.unisi9.endpoint;

import br.com.si9.unisi9.controller.ClienteController;
import br.com.si9.unisi9.dto.ClienteDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteEndpoint {

    @Inject
    ClienteController clienteController;

    @POST
    public Response gravarCliente(ClienteDTO clienteDTO){
        ClienteDTO result = clienteController.gravarCliente(clienteDTO);
        return Response.ok(result).build();
    }

    @PUT
    public Response editarCliente(ClienteDTO clienteDTO){
        ClienteDTO result = clienteController.editarCliente(clienteDTO);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarCliente(@PathParam("id") Integer idCliente){
        clienteController.deletarCliente(idCliente);
        return Response.ok().build();
    }

    @GET
    public Response listarCliente(){
        List<ClienteDTO> result = clienteController.listarCliente();
        return Response.ok(result).build();
    }

}
