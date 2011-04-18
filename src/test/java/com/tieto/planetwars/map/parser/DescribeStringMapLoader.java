package com.tieto.planetwars.map.parser;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;
import com.tieto.planetwars.world.WarsMap;


public class DescribeStringMapLoader {
	@Test
	public void should_create_planet() throws Exception {
		//given
		String map = "P 0 0 0 23 1\n";
		InputStream inputStream = new ByteArrayInputStream(map.getBytes("UTF-8")); 
		StringMapLoader loader  = new StringMapLoader( inputStream );
		Planet planet = new Planet(0, 1, null, 23, new Coordinates(0, 0));
		
		//when
		WarsMap world = loader.createMap();
		
		//then
		assertThat(world.getFleets().size(), is(0));
		assertThat(world.getPlanets().size(), is(1));
		assertThat(world.getPlanets().get(0), equalTo(planet));
		assertThat(world.getPlanets().get(0).getCoordinates().getX(), equalTo(planet.getCoordinates().getX()));
		assertThat(world.getPlanets().get(0).getCoordinates().getY(), equalTo(planet.getCoordinates().getY()));
		assertThat(world.getPlanets().get(0).getGrowthRate(), equalTo(planet.getGrowthRate()));
		assertThat(world.getPlanets().get(0).getNumberOfShips(), equalTo(planet.getNumberOfShips()));
		assertThat(world.getPlanets().get(0).getOwner(), equalTo(planet.getOwner()));
		//shift+ctrl+m podczas gdy selected region na metodzie
		//shift+ctrl+o organizuje kod
	}
}
