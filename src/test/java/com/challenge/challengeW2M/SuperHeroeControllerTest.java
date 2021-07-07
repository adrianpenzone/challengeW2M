package com.challenge.challengeW2M;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class SuperHeroeControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getSuperHeroes() throws Exception {
		String uri = "/superHeroes";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		SuperHeroe[] superHeroes = super.mapFromJson(content, SuperHeroe[].class);
		assertTrue(superHeroes.length > 0);
	}
	
	@Test
	public void getSuperHeroesById() throws Exception {
		String uri = "/superHeroes/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		SuperHeroe superHeroe = new SuperHeroe(1L, "SuperMan");
		assertEquals(content, super.mapToJson(superHeroe));
	}

}
