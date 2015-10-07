package Diggaren.Beans.Spotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test2 {
	public static void main(String[] args) throws Exception {
		
		String baseUrl = "https://api.spotify.com/v1/search?query=Queen&offset=0&limit=1&type=artist";
		JSONObject jObj = readJsonFromUrl(baseUrl);
		JSONObject nObj = (JSONObject) jObj.get("artists");
		JSONArray yObj = nObj.getJSONArray("items");
		System.out.println(yObj);
		
	}
	
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	private static String readAll(Reader rd) throws IOException {	    
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

}
