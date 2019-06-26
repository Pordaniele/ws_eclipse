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

import it.prova.model.Abitante;
import it.prova.service.abitante.AbitanteService;
import it.prova.web.dto.abitante.AbitanteDTO;

@Component
@Path("/abitante")
public class AbitanteResource {

	@Autowired
	AbitanteService abitanteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		List<AbitanteDTO> result = AbitanteDTO.buildListFromModelList(abitanteService.listAllAbitantiEager());
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAbitante(@PathParam("id") Long id) {
		AbitanteDTO abitanteDTOInstance =AbitanteDTO.buildAbitanteDTOFromModel(abitanteService.caricaSingoloAbitanteWithMunicipio(id),true);
		return Response.status(200).entity(abitanteDTOInstance).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertiNuovaAutomobile(AbitanteDTO abitanteDTOInput) {
		Abitante abitanteDaInserire = AbitanteDTO.buildAbitanteModelFromDTO(abitanteDTOInput, true);
		abitanteService.inserisciNuovo(abitanteDaInserire);
		abitanteDTOInput.setId(abitanteDaInserire.getId());
		return Response.status(200).entity(abitanteDTOInput).build();
	}
	
	@DELETE
	@Path("{id : \\d+}")
	public void deleteAbitante(@PathParam("id") Long id) {
		
		abitanteService.rimuovi(abitanteService.caricaSingoloAbitante(id));
		
	}
	
	@GET
	@Path("/searchByExample")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByExample(AbitanteDTO AbitanteDTOInput) {
		
		Abitante prova= AbitanteDTO.buildAbitanteModelFromDTO(AbitanteDTOInput, false);
		System.out.println(AbitanteDTOInput.getNome());
		
		AbitanteDTO prova2= AbitanteDTO.buildAbitanteDTOFromModel((Abitante)abitanteService.findByExample(prova),false);
	 prova2.getId();
	
		List <AbitanteDTO> result= AbitanteDTO.buildListFromModelList(abitanteService.findByExample((AbitanteDTO.buildAbitanteModelFromDTO(AbitanteDTOInput, false))));
		
		return Response.status(200).entity(result).build();
	}
	

	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void aggiornaMunicipio(AbitanteDTO abitanteInput) {
		Abitante edit= AbitanteDTO.buildAbitanteModelFromDTO(abitanteInput, true);
		abitanteService.aggiorna(edit);	
	}
	
	
}
