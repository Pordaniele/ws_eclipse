package it.prova.web.rest.resources;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.prova.dao.PersonaDAOMock;
import it.prova.model.Persona;

@Path("/persona")
public class PersonaResource {

	private static final Logger LOGGER = Logger.getLogger(PersonaResource.class.getName());

	@Context
	HttpServletRequest request;

	private PersonaDAOMock personaDaoMock;

	public PersonaResource() {
		personaDaoMock = new PersonaDAOMock();
	}

	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersona(@PathParam("id") Long id) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		Persona personaDaCaricare = personaDaoMock.findById(id);
		return Response.status(200).entity(personaDaCaricare).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertiNuovaAutomobile(Persona personaInput) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		personaDaoMock.insert(personaInput);
		return Response.status(200).entity(personaInput).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		List<Persona> result = personaDaoMock.findAll();
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchAutomobile(@QueryParam("nome") String nome, @QueryParam("cognome") String cognome) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		List<Persona> result = personaDaoMock.findByFields(nome, cognome);
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/findPersonaMaggioreDi")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchPersona(@QueryParam("eta") Integer eta) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		List<Persona> result = personaDaoMock.findByEtaMaggioreDi(eta);
		return Response.status(200).entity(result).build();
	}
	
	@DELETE
	@Path("{id : \\d+}")
	public Response deleteAutomobile(@PathParam("id") Long id) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		if(personaDaoMock.delete(id))
			return Response.status(200).entity("Rimossa Persona con id: "+id).build();
		
		return Response.status(Response.Status.NOT_FOUND).entity("not found").build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response aggiornaPersona(Persona personaInput) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		Persona result = personaDaoMock.update(personaInput);
		return Response.status(200).entity(result).build();
	}

	
}
