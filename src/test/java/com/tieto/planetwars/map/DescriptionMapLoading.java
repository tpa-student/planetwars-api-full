package com.tieto.planetwars.map;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.tieto.planetwars.map.parser.StringMapLoader;
import com.tieto.planetwars.world.WarsMap;

public class DescriptionMapLoading {

	@Test
	public void should_parse_word_with_planets() throws Exception {
		// given
		String map = "P 0    0    1 34 2  # Player one's home planet. \n"
				+ "P 7    9    2 34 2  # Player two's home planet.\n"
				+ "P 3.14 2.71 0 15 5  # A neutral planet with real-number coordinates.\n";
		
		InputStream inputStream = new ByteArrayInputStream(map.getBytes());

		StringMapLoader stringMapLoader = new StringMapLoader(inputStream);
		
		// when
		WarsMap createdMap = stringMapLoader.createMap();
		
		// then
		assertThat(createdMap.getPlanets().size(), is(3));
	}
}
