package com.challenge.challengeW2M;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.challenge.challengeW2M.domain.SuperHeroe;

public class SuperHeroeControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getSuperHeroes() throws Exception {
		String uri = "/superHeroes";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult mvcResult = mockMvc.perform(requestBuilder)
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
	}

	@Test
	public void getSuperHeroesById() throws Exception {
		String uri = "/superHeroes/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult mvcResult = mockMvc.perform(requestBuilder)
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		SuperHeroe superHeroe = new SuperHeroe();
		superHeroe.setId(1L);
		superHeroe.setNombre("Superman");
		superHeroe.setPoder("super hombre");
		assertEquals(content, super.mapToJson(superHeroe));
	}

}
