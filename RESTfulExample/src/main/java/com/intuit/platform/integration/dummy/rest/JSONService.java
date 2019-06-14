package com.intuit.platform.integration.dummy.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.intuit.platform.integration.dummy.common.Track;
import com.intuit.platform.integration.module1.Class1;
import com.intuit.platform.integration.module2.Class2;
import com.intuit.platform.integration.module3.Class3;

@Path("/json/metallica")
public class JSONService {

	private Class1 class1 = new Class1();
	private Class2 class2 = new Class2();
	private Class3 class3 = new Class3();
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");
		track.setCount(class2.clientAdd10(class1.clientSub10(567)));
		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}
	
}