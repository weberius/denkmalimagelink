package de.illilli.opendata.service.denkmalimagelink;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/service")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private StringBuilder json = new StringBuilder("{}");

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{street}/{number}")
	public String getDenkmalInError(@PathParam("street") String street,
			@PathParam("number") String number) {
		response.setCharacterEncoding("UTF-8");
		return json.toString();
	}

}
