package com.rcp;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class JsonValidationTest extends ParserJSON {
	JSONObject parser;

	@BeforeTest
	public void beforeClass() {

		ParserJSON parserJSON = new ParserJSON();
		parser = parserJSON.getJSONObject();
	}

	@Test
	public void validateForeignPlayers() {
		// Get the player array from the JSON object
		JSONArray playerArray = (JSONArray) parser.get("player");

		int foreignPlayerCount = 0;

		// Iterate over each player in the array and check if they are foreign players
		for (Object playerObj : playerArray) {
			JSONObject player = (JSONObject) playerObj;
			String country = (String) player.get("country");

			if (!country.equals("India")) {
				foreignPlayerCount++;
			}
		}

		// Check if there are exactly 4 foreign players in the team

		assertEquals(foreignPlayerCount, 4);
		

	}

	@Test
	public void validateRole() {
		// Get the player array from the JSON object
		JSONArray playerArray = (JSONArray) parser.get("player");

		int roleCount = 0;

		// Iterate over each player in the array and check if they are foreign players
		for (Object playerObj : playerArray) {
			JSONObject player = (JSONObject) playerObj;
			String role = (String) player.get("role");

			if (role.equals("Wicket-keeper")) {
				roleCount++;
			}
		}

		// Check if there areWicket-keeper players in the team
		if (roleCount <= 1) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

}
