package com.opensource.resteasy;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;




@Path("/message")
public class helloWorld {

	@GET
	@Path("getMethod/{param}")
	public Response getIssue(@PathParam("param") String msg)
			throws URISyntaxException, FileNotFoundException {

		String result = "Helloword "+msg;

		return Response.status(200).entity(result).build();

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	}
	
}
