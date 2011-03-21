package com.tieto.planetwars.map.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tieto.planetwars.map.MapException;
import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.world.Planet;

/**
 * 
 * 
 */
public class CommandParser {
	public static final String COMMAND_DEFINITION_SEPARATOR = " ";
	public static final int COMMAND_DEFINITION_LENGTH = 3;

	Map<Integer, Planet> planetsIdsToPlanets = new HashMap<Integer, Planet>();

	/**
	 * 
	 * @param planets
	 */
	public CommandParser(List<Planet> planets) {
		for (Planet planet : planets) {
			planetsIdsToPlanets.put(planet.getId(), planet);
		}
	}

	/**
	 * 
	 * @param commandDefinition
	 * @return
	 */
	public Command parse(String commandDefinition) {
		String[] split = commandDefinition.split(COMMAND_DEFINITION_SEPARATOR);
		if (split.length != COMMAND_DEFINITION_LENGTH) {
			throw new MapException("Wrong fleet description");
		}
		Planet srcPlanet = planetsIdsToPlanets.get(split[0]);
		Planet destPlanet = planetsIdsToPlanets.get(split[1]);
		int numShips = Integer.parseInt(split[2]);

		return new Command(srcPlanet, destPlanet, numShips);
	}
}
