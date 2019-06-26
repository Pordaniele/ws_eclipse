package it.prova.web.rest.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dto.ClienteDTO;
import it.prova.model.Cliente;
import it.prova.service.ClienteService;

@Component
@Path("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		List<ClienteDTO> result = clienteService.list().stream()
				.map(item -> ClienteDTO.buildClienteDTOFromModel(item, false, false, false))
				.collect(Collectors.toList());
		return Response.status(200).entity(result).build();
	}
	@GET
	@Path("/searchEager")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllEager() {
		List<ClienteDTO> result = clienteService.findAllEagerOrdini().stream()
				.map(item -> ClienteDTO.buildClienteDTOFromModel(item, true, false, false))
				.collect(Collectors.toList());
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCliente(@PathParam("id") Long id) {
		ClienteDTO clienteDTOInstance =ClienteDTO.buildClienteDTOFromModel(clienteService.get(id), false, false, false);
		return Response.status(200).entity(clienteDTOInstance).build();
	}
	
	@GET
	@Path("/eager/{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClienteEager(@PathParam("id") Long id) {
		ClienteDTO clienteDTOInstance =ClienteDTO.buildClienteDTOFromModel(clienteService.caricaEager(id), true, false, false);
		return Response.status(200).entity(clienteDTOInstance).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertNuovoCliente(ClienteDTO clienteDTOInput) {
		Cliente clienteDaInserire = ClienteDTO.buildClienteFromDTO(clienteDTOInput, true, false, false);
		clienteService.insert(clienteDaInserire);
		clienteDTOInput.setId(clienteDaInserire.getId());
		return Response.status(200).entity(clienteDTOInput).build();
	}
	
	@DELETE
	@Path("{id : \\d+}")
	public void deleteCliente(@PathParam("id") Long id) {
		
		clienteService.delete(clienteService.get(id));
		
	}
	
	@GET
	@Path("/searchByExample")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByExample(ClienteDTO clienteDTOInput) {
		
		Cliente prova= ClienteDTO.buildClienteFromDTO(clienteDTOInput, false, false,false);
		
		List <ClienteDTO> result= new ArrayList<ClienteDTO>();
		clienteService.findByExample(prova).stream().forEach(item->result.add(ClienteDTO.buildClienteDTOFromModel(item, false, false, false)));
		
		return Response.status(200).entity(result).build();
	}
	
	
}
