package org.rest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.model.User;
import org.service.ApiUserService;

/**
 * Projeto: api-quarkus
 * @author: jaime Dev
 * File: UserRest.java
 * Data: 3 de nov de 2020 **/


@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRest {
	
	@Inject
	ApiUserService service;
	
	/*
	 * GET
	 */
	@GET
	@Path("/listar")
	@APIResponse(responseCode = "200")
	public Response listar () {
		return Response
				.status(Response.Status.OK)
				.entity(service.listar())
				.build();
		
	}
	/*
	 * POST
	 */
	@POST
	@Transactional(rollbackOn = Exception.class)
	@APIResponse(responseCode = "201")
	public Response add(@Valid User user) {
		service.insert(user);
		return Response
				.status(Response.Status.CREATED)
				.build();
	}
	/*
	 * PUT
	 */
	@PUT
	@Path("/{id}")
	@Transactional(rollbackOn = Exception.class)
	@APIResponse(responseCode = "201")
	public Response update(User user, @PathParam("id") Long id) {
		service.update(user, id);
		return Response
				.status(Response.Status.CREATED)
				.build();
	}
	/*
	 * DELETE
	 */
	@DELETE
	@Path("/{id}")
	@Transactional(rollbackOn = Exception.class)
	@APIResponse(responseCode = "200")
	public Response delete(@PathParam("id")Long id) {
		service.delete(id);
		return Response
				.status(Response.Status.ACCEPTED)
				.build();
		
	}

}
