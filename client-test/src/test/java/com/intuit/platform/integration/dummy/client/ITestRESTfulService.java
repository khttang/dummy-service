package com.intuit.platform.integration.dummy.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.intuit.platform.integration.dummy.common.Track;

public class ITestRESTfulService {
	@Test
	public void testGetTrack() {
		List<Object> providers = new ArrayList<Object>();
		providers.add( new JacksonJaxbJsonProvider() );

		WebClient client = WebClient.create("http://localhost:8080/RESTfulExample", providers);
		//client = client.accept("application/json").type("application/json").path("/order").query("id", "1");

		client = client.accept("application/json").type("application/json").path("/rest/json/metallica/get");

		Track track = client.get(Track.class);
		System.out.println("Track "+ track.getTitle()+","+ track.getSinger()+":" + track.getCount());
		System.out.println("Track.toString():"+track.toString());

	}

	@Test
	public void testCreateTrack() {
		List<Object> providers = new ArrayList<Object>();
		providers.add( new JacksonJaxbJsonProvider() );

		WebClient client = WebClient.create("http://localhost:8080/RESTfulExample", providers);
		//client = client.accept("application/json").type("application/json").path("/order").query("id", "1");

		client = client.accept("application/json").type("application/json").path("/rest/json/metallica/post");

		Track track = new Track();
		track.setTitle("Khiem's Choices");
        track.setSinger("Metallica");
        track.setCount(100);
		Response response = client.post(track);
		
		System.out.println("Post Track: "+response.getStatus()+", length: "+response.getLength());

	}

}
