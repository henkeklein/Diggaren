package Diggaren.Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Transforms our final values to JSON-data
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class JavaToJson {
	
	/**
	 * Transform and returns JSON-data.
	 * We need to specify a radio channel in
	 * order to get the right information
	 * @param channel
	 * @return data as JSON
	 */
	public String getJson(int channel) {
		CreateJson json = new CreateJson();
		json.setValues(channel);
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(json));
        return gson.toJson(json);
	}

}
