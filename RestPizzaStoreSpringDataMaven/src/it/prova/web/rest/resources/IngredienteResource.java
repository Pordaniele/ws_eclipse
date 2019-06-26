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

import it.prova.dto.IngredienteDTO;
import it.prova.dto.UtenteDTO;
import it.prova.dto.IngredienteDTO;
import it.prova.dto.IngredienteDTO;
import it.prova.model.Ingrediente;
import it.prova.model.Utente;
import it.prova.model.Ingrediente;
import it.prova.service.IngredienteService;

@Component
@Path("/ingrediente")
public class IngredienteResource {
@Autowired
IngredienteService ingredienteService;

@GET
@Produces(MediaType.APPLICATION_JSON)
public Response listAll() {
	List<IngredienteDTO> result = ingredienteService.list().stream().map(item-> IngredienteDTO.buildIngredienteDTOFromModel(item, false, false)).collect(Collectors.toList());
	return Response.status(200).entity(result).build();
}

@GET
@Path("/findAllEager")
@Produces(MediaType.APPLICATION_JSON)
public Response listAllEagerPizze() {
	List<IngredienteDTO> result = ingredienteService.findAllEagerPizze().stream().map(item-> IngredienteDTO.buildIngredienteDTOFromModel(item, true, false)).collect(Collectors.toList());
	return Response.status(200).entity(result).build();
}


@GET
@Path("{id : \\d+}")
@Produces(MediaType.APPLICATION_JSON)
public Response getIngrediente(@PathParam("id") Long id) {
	IngredienteDTO ingredienteDTOInstance =IngredienteDTO.buildIngredienteDTOFromModel(ingredienteService.get(id), false, false);
	return Response.status(200).entity(ingredienteDTOInstance).build();
}

@POST
@Produces(MediaType.APPLICATION_JSON)
public Response insertNuovoIngrediente(IngredienteDTO ingredienteDTOInput) {
	Ingrediente ingredienteDaInserire = IngredienteDTO.buildIngredienteFromDTO(ingredienteDTOInput, true, false);
	ingredienteService.insert(ingredienteDaInserire);
	ingredienteDTOInput.setId(ingredienteDaInserire.getId());
	return Response.status(200).entity(ingredienteDTOInput).build();
}

@DELETE
@Path("{id : \\d+}")
public void deleteIngrediente(@PathParam("id") Long id) {
	
	ingredienteService.delete(ingredienteService.get(id));
	
}

@PUT
@Produces(MediaType.APPLICATION_JSON)
public void aggiornaIngrediente(IngredienteDTO ingredienteInput) {
	Ingrediente edit= IngredienteDTO.buildIngredienteFromDTO(ingredienteInput, true, false);
	ingredienteService.update(edit);
	
}

@GET
@Path("/searchByExample")
@Produces(MediaType.APPLICATION_JSON)
public Response searchByExample(IngredienteDTO ingredienteDTOInput) {
	
	Ingrediente prova= IngredienteDTO.buildIngredienteFromDTO(ingredienteDTOInput, false, false);
	
	List <IngredienteDTO> result= new ArrayList<IngredienteDTO>();
	ingredienteService.findByExample(prova).stream().forEach(item->result.add(IngredienteDTO.buildIngredienteDTOFromModel(item, false, false)));
	
	return Response.status(200).entity(result).build();
}

}
