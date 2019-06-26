package it.prova.web.rest.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import it.prova.dto.OrdineDTO;
import it.prova.model.Ordine;
import it.prova.service.OrdineService;

@Component
@Path("/ordine")
public class OrdineResource {

	@Autowired
	OrdineService ordineService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		List<OrdineDTO> result = ordineService.list().stream()
				.map(item -> OrdineDTO.buildOrdineDTOFromModel(item, false, false)).collect(Collectors.toList());
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/findAllEager")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllEager() {
		List<OrdineDTO> result = ordineService.findALLEagerPizze().stream()
				.map(item -> OrdineDTO.buildOrdineDTOFromModel(item, true, false)).collect(Collectors.toList());
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrdine(@PathParam("id") Long id) {
		OrdineDTO ordineDTOInstance = OrdineDTO.buildOrdineDTOFromModel(ordineService.get(id), false, false);
		return Response.status(200).entity(ordineDTOInstance).build();
	}

	@GET
	@Path("/totale/{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrdineTotale(@PathParam("id") Long id) {
		Double result=ordineService.calcolaTotaleOrdine(id);
		return Response.status(200).entity(result).build();
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertNuovoOrdine(OrdineDTO ordineDTOInput) {
		Ordine OrdineDaInserire = OrdineDTO.buildOrdineFromDTO(ordineDTOInput, true, false);
		ordineService.insert(OrdineDaInserire);
		ordineDTOInput.setId(OrdineDaInserire.getId());
		return Response.status(200).entity(ordineDTOInput).build();
	}

	@DELETE
	@Path("{id : \\d+}")
	public void deleteOrdine(@PathParam("id") Long id) {

		ordineService.delete(ordineService.get(id));

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void aggiornaOrdine(OrdineDTO ordineInput) {
		Ordine edit = OrdineDTO.buildOrdineFromDTO(ordineInput, true, false);
		ordineService.update(edit);

	}
	
	@GET
	@Path("/searchByExample")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByExample(OrdineDTO ordineDTOInput) {
		
		Ordine prova= OrdineDTO.buildOrdineFromDTO(ordineDTOInput, false, false);
		
		List <OrdineDTO> result= new ArrayList<OrdineDTO>();
		ordineService.findByExample(prova).stream().forEach(item->result.add(OrdineDTO.buildOrdineDTOFromModel(item, false, false)));
		
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/caricaPizze/{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrdineConPizza(@PathParam("id") Long id) {
		OrdineDTO ordineDTOInstance = OrdineDTO.buildOrdineDTOFromModel(ordineService.cercaConPizza(id), true, true);
		return Response.status(200).entity(ordineDTOInstance).build();
	}
	
	
	
}
