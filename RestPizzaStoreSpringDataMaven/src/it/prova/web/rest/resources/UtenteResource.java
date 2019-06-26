package it.prova.web.rest.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dto.UtenteDTO;
import it.prova.model.Utente;
import it.prova.service.UtenteService;

@Component
@Path("/utente")
public class UtenteResource {

	@Autowired
	UtenteService utenteService;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		List<UtenteDTO> result = UtenteDTO.buildListFromModelList(utenteService.list());
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAbitante(@PathParam("id") Long id) {
		UtenteDTO utenteDTOInstance =UtenteDTO.buildUtenteDTOFromModel(utenteService.get(id));
		return Response.status(200).entity(utenteDTOInstance).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertNuovoUtente(UtenteDTO utenteDTOInput) {
		Utente utenteDaInserire = UtenteDTO.buildUtenteFromUtenteDTO(utenteDTOInput);
		utenteService.insert(utenteDaInserire);
		utenteDTOInput.setId(utenteDaInserire.getId());
		return Response.status(200).entity(utenteDTOInput).build();
	}
	
	@DELETE
	@Path("{id : \\d+}")
	public void deleteMunicipio(@PathParam("id") Long id) {
		
		utenteService.delete(utenteService.get(id));
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void aggiornaUtente(UtenteDTO utenteInput) {
		Utente edit= UtenteDTO.buildUtenteFromUtenteDTO(utenteInput);
		utenteService.update(edit);
		
	}
	
	@GET
	@Path("/searchByExample")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByExample(UtenteDTO utenteDTOInput) {
		
		Utente prova= UtenteDTO.buildUtenteFromUtenteDTO(utenteDTOInput);
		System.out.println(utenteDTOInput.getNome());
		
		
		List <UtenteDTO> result= UtenteDTO.buildListFromModelList(utenteService.findByExample((UtenteDTO.buildUtenteFromUtenteDTO(utenteDTOInput))));
		
		return Response.status(200).entity(result).build();
	}
	
}
