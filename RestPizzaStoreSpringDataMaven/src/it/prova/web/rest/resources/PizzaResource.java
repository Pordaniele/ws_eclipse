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
import it.prova.dto.PizzaDTO;
import it.prova.dto.PizzaDTO;
import it.prova.model.Pizza;
import it.prova.model.Pizza;
import it.prova.service.PizzaService;

@Component
@Path("/pizza")
public class PizzaResource {
@Autowired
PizzaService pizzaService;

@GET
@Produces(MediaType.APPLICATION_JSON)
public Response listAll() {
	List<PizzaDTO> result = pizzaService.list().stream().map(item-> PizzaDTO.buildPizzaDTOFromModel(item, false, false)).collect(Collectors.toList());
	return Response.status(200).entity(result).build();
}

@GET
@Path("/findAllEager")
@Produces(MediaType.APPLICATION_JSON)
public Response listAllEager() {
	List<PizzaDTO> result = pizzaService.findAllEagerIngredientiAndOrdini().stream().map(item-> PizzaDTO.buildPizzaDTOFromModel(item, true, true)).collect(Collectors.toList());
	return Response.status(200).entity(result).build();
}


@GET
@Path("{id : \\d+}")
@Produces(MediaType.APPLICATION_JSON)
public Response getPizza(@PathParam("id") Long id) {
	PizzaDTO pizzaDTOInstance =PizzaDTO.buildPizzaDTOFromModel(pizzaService.get(id), false, false);
	return Response.status(200).entity(pizzaDTOInstance).build();
}

@POST
@Produces(MediaType.APPLICATION_JSON)
public Response insertNuovaPizza(PizzaDTO pizzaDTOInput) {
	Pizza pizzaDaInserire = PizzaDTO.buildPizzaFromModelDTO(pizzaDTOInput, true, true);
	pizzaService.insert(pizzaDaInserire);
	pizzaDTOInput.setId(pizzaDaInserire.getId());
	return Response.status(200).entity(pizzaDTOInput).build();
}

@DELETE
@Path("{id : \\d+}")
public void deleteIngrediente(@PathParam("id") Long id) {
	
	pizzaService.delete(pizzaService.get(id));
	
}

@PUT
@Produces(MediaType.APPLICATION_JSON)
public void aggiornaPizza(PizzaDTO pizzaInput) {
	Pizza edit= PizzaDTO.buildPizzaFromModelDTO(pizzaInput, true, true);
	pizzaService.update(edit);
	
}

@GET
@Path("/searchByExample")
@Produces(MediaType.APPLICATION_JSON)
public Response searchByExample(PizzaDTO pizzaDTOInput) {
	Pizza prova= PizzaDTO.buildPizzaFromModelDTO(pizzaDTOInput, false, false);
	List<PizzaDTO> result= new ArrayList<PizzaDTO>();
	pizzaService.findByExample(prova).stream().forEach(item-> result.add(PizzaDTO.buildPizzaDTOFromModel(item, false, false)));
	return Response.status(200).entity(result).build();

}



}
