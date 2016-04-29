package br.com.birouskaapi.api;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.birouskaapi.control.EstadoControl;
import br.com.birouskaapi.model.Estado;

@Path("/service")
public class Service {

	@POST
	@Path("/postService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postREST(InputStream incomingData) {
		StringBuilder crunchifyBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
	}
 
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("estados")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEstado(InputStream incomingData) {
		String strEstado = new String();
		try {
			
			EstadoControl estControl = new EstadoControl();
			List<Estado> lstEstado = new ArrayList<Estado>();
			lstEstado = estControl.List();
			
			Gson gson = new Gson();
			strEstado = gson.toJson(lstEstado);
			//System.out.println("Estados = " + strEstado);
			
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(strEstado).build();
	}
	
	

}

