package it.prova.web.rest.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.model.Municipio;
import it.prova.service.municipio.MunicipioService;
import it.prova.web.dto.municipio.MunicipioDTO;

@Component
@Path("/municipio")
public class MunicipioResource {

	@Autowired
	MunicipioService municipioService;

	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMunicipio(@PathParam("id") Long id) {
		MunicipioDTO result = MunicipioDTO.buildMunicipioDTOFromModel(municipioService.caricaSingoloMunicipioConAbitanti(id), true);
		return Response.status(200).entity(result).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertNuovoMunicipio(MunicipioDTO municipioDTOInput) {
		Municipio municipioDaInserire = MunicipioDTO.buildMunicipioModelFromDTO(municipioDTOInput, true);
		municipioService.inserisciNuovo(municipioDaInserire);
		municipioDTOInput.setId(municipioDaInserire.getId());
		return Response.status(200).entity(municipioDTOInput).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		
		List<MunicipioDTO> result = MunicipioDTO.buildListFromModelList(municipioService.listAllMunicipi(), false);
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/searchByExample")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchMunicipio(@QueryParam("descrizione") String descrizione, @QueryParam("codice") String codice,  @QueryParam("ubicazione") String ubicazione) {
		
		Municipio example = new Municipio(descrizione, codice, ubicazione);
		List<MunicipioDTO> result =MunicipioDTO.buildListFromModelList(municipioService.findByExample(example), false);
		return Response.status(200).entity(result).build();
	}
	
	
	@DELETE
	@Path("{id : \\d+}")
	public void deleteMunicipio(@PathParam("id") Long id) {
		
		municipioService.rimuovi(municipioService.caricaSingoloMunicipio(id));
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void aggiornaMunicipio(MunicipioDTO municipioInput) {
		Municipio edit= MunicipioDTO.buildMunicipioModelFromDTO(municipioInput, false);
		municipioService.aggiorna(edit);
		
	}
	
	@GET
	@Path("/searchByDescrizione")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchMunicipioByDescrizione(@QueryParam("descrizione") String descrizione) {
		
		List<MunicipioDTO> result = MunicipioDTO.buildListFromModelList(municipioService.cercaByDescrizioneILike(descrizione), false);
		return Response.status(200).entity(result).build();
	}
	
	
	
}
