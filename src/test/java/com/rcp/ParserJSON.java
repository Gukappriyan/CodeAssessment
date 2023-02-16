package com.rcp;
import java.io.File;
import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParserJSON {

	public JSONObject getJSONObject() {
		JSONObject jsonObject = null;
		try {
			// Read the JSON file and parse it
			JSONParser parser = new JSONParser();
			File resourcesDirectory = new File("src/test/resources");

			Object obj = parser.parse(new FileReader(resourcesDirectory.getAbsoluteFile() + "/team.json"));
			jsonObject = (JSONObject) obj;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

}
