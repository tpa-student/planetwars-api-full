package com.tieto.planetwars.map.parser;

import java.util.List;
import java.util.Map;

import com.tieto.planetwars.map.MapException;
import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Fleet;
import com.tieto.planetwars.world.Planet;

/**
 * Parser for fleet description (F <owner:int> <ships:int> <source:int>
 * <destination:int> <total_turns:int> <remaining_turns:int>). Creates fleet
 * object for the game based on string description.
 */
public class FleetParser {
	public static final String FLEET_DESCRIPTION_SEPARATOR = " ";
	public static final String FLEET_DESCRIPTION_MARKER = "F";
	public static final int FLEET_DESCRIPTION_LENGTH = 7;

	/**
	 * Parses fleet description and creates fleet object
	 * 
	 * @param fleetDescription
	 *            fleet description
	 * @param playersMap
	 *            players in the game
	 * @param planets
	 *            planets in the game
	 * @return fleet object
	 */
	public Fleet parse(String fleetDescription,
			Map<Integer, Player> playersMap, List<Planet> planets) {
		if (fleetDescription == null) {
			throw new IllegalArgumentException(
					"Fleet description cannot be null");
		}
		String[] fleetElement = fleetDescription
				.split(FLEET_DESCRIPTION_SEPARATOR);
		if (fleetElement.length != FLEET_DESCRIPTION_LENGTH) {
			throw new MapException("Wrong fleet description");
		}
		Player player = playersMap.get(Integer.valueOf(fleetElement[1]));
		int numberOfShips = Integer.parseInt(fleetElement[2]);
		Planet sourcePlanet = planets.get(Integer.valueOf(fleetElement[3]));
		Planet destinationPlanet = planets
				.get(Integer.valueOf(fleetElement[4]));
		int totalTurns = Integer.parseInt(fleetElement[5]);
		int remainingTurns = Integer.parseInt(fleetElement[6]);
		return new Fleet(player, numberOfShips, sourcePlanet,
				destinationPlanet, totalTurns, remainingTurns);
	}
}
