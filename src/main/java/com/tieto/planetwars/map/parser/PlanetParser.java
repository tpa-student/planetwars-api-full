package com.tieto.planetwars.map.parser;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.tieto.planetwars.map.MapException;
import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;

public class PlanetParser {
	public static final String PLANET_DEFINITION_SEPARATOR = " ";
	public static final String PLANET_DESCRIPTION_MARKER = "P";
	public static final int PLANET_DESCRIPTION_LENGTH = 6;
	private static final String WRONG_TOKEN_NUMER = "Planet description has wrong elements number: ";

	private final AtomicInteger sequence = new AtomicInteger(0);

	public Planet parse(String planetDescription,
			Map<Integer, Player> fleetElement) {
		if (planetDescription == null) {
			throw new IllegalArgumentException(
					"Planet description cannot be null");
		}
		String[] tokens = planetDescription.split(PLANET_DEFINITION_SEPARATOR);
		if (tokens.length != PLANET_DESCRIPTION_LENGTH) {
			throw new MapException(WRONG_TOKEN_NUMER + sequence.get());
		}

		double x = Double.valueOf(tokens[1]);
		double y = Double.valueOf(tokens[2]);
		Player owner = fleetElement.get(Integer.valueOf(tokens[3]));
		int ships = Integer.valueOf(tokens[4]);
		int growth = Integer.valueOf(tokens[5]);
		Coordinates coordinates = new Coordinates(x, y);

		return new Planet(sequence.getAndIncrement(), growth, owner, ships,
				coordinates);
	}

}
