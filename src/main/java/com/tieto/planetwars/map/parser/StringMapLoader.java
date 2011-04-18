package com.tieto.planetwars.map.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.tieto.planetwars.map.GameMapFactory;
import com.tieto.planetwars.map.MapException;
import com.tieto.planetwars.world.Fleet;
import com.tieto.planetwars.world.Planet;
import com.tieto.planetwars.world.WarsMap;

public class StringMapLoader implements GameMapFactory {

	private final FleetParser fleetParser = new FleetParser();
	private BufferedReader reader;
	private PlanetParser planetParser;

	public StringMapLoader(InputStream inputStream) {
		reader = new BufferedReader(new InputStreamReader(inputStream));
	}
	
	public WarsMap createMap() {
		
		List<String> lines = readLines();
		List<Planet> planets = readPlanets(lines);
		List<Fleet> fleets = readFleets(lines);
		
		return new WarsMap(planets, fleets);		

	}

	private List<Fleet> readFleets(List<String> lines) {
		List<Fleet> fleets = new ArrayList<Fleet>();
		for (String line : lines) {
			
		}
		return fleets;
	}

	private List<Planet> readPlanets(List<String> lines) {
		List<Planet> planets = new ArrayList<Planet>();
		
		for (String line : lines) {
		}
		
		return planets;
	}

	private List<String> readLines() {
		List <String> lines = new ArrayList<String>();
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException ex) {
			throw new MapException("");
		}
		return lines;
	}
}
