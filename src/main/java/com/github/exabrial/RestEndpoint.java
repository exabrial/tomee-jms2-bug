package com.github.exabrial;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
@ApplicationScoped
public class RestEndpoint {
	@Inject
	private ControllerEJB ejb;

	@GET
	public String get() {
		ejb.businessFlow();
		return "done";
	}
}
