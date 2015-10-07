package Diggaren.Beans.Spotify;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.swing.JOptionPane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;




/**
 * A small program that retrieves information about today from an external API
 * and presents this info in a more readable way as a console print out.
 * 
 * @author
 */
public class Test {

	/**
	 * The main method that's used to run the program.
	 * 
	 * @param args
	 *            Arguments from the command line. This program won't honor them
	 *            at all.
	 */
	public static void main(String[] args) {
		String artist = JOptionPane.showInputDialog("Name an artist");
		String baseUrl = "https://api.spotify.com/v1/search?query="+artist+"&offset=0&limit=1&type=artist";

		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;

		GsonBuilder builder = new GsonBuilder();
		Gson json = builder.create();

		SpotifyBean envelope = null;

		try {
			// Create the client that will call the API
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet(baseUrl);

			// Call the API and verify that all went well
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {
				// All went well. Let's fetch the data
				entity = response.getEntity();
				data = entity.getContent();

				try {
					// Attempt to parse the data as JSON
					reader = new InputStreamReader(data);
					json = builder.create();
					envelope = json.fromJson(reader, SpotifyBean.class);

//					for (Entry<String, ArtistBean song : envelope.artists.entrySet()) {
//						printSong(song.getValue());
//					}
					
					
					JSONObject jObj = readJsonFromUrl(baseUrl);
					System.out.println(jObj);
					
					
			//		printSong(envelope.artists);

				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("Det blev fel. Gå hem och sov.");
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("API:t svarade inte, så du är nog ledig.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printSong(ArtistBean artistBean) {
		System.out.println("Länk: " + artistBean.getHref() + "\n");
		System.out.println("Total: " + artistBean.getTotal() + "\n");

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
	
	private static String readID(Reader rd) throws IOException {
		return null;
	}
}


