package Diggaren.Diggaren;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Diggaren.Diggaren.beans.SRBean;
import Diggaren.Diggaren.beans.SongBean;

/**
 * A small program that retrieves information about today from an external API
 * and presents this info in a more readable way as a console print out.
 * 
 * @author Johan Holmberg
 */
public class DiggarenTest {

	/**
	 * The main method that's used to run the program.
	 * 
	 * @param args Arguments from the command line. This program won't honor
	 * 		  them at all.
	 */
	public static void main(String[] args) {
		String baseUrl = "http://api.sr.se/api/v2/playlists/rightnow?channelid=2576&format=json";
		
		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;
		
		GsonBuilder builder = new GsonBuilder();
		Gson json = builder.create();
		

		SRBean envelope = null;

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
					envelope = json.fromJson(reader, SRBean.class);
					
					// Yep, that went well. Let's print today's information.
					// As the API will return a list of days, we'll need to
					// fetch "today", which will be the first and only object.
					for (Map.Entry<String, SongBean> song : envelope.playlist.entrySet()) {
						printSong(song.getValue());
					}
					
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

	/**
	 * Prints info about today. This method makes no effort trying to be of
	 * great coding standard. In fact, it looks like crap, but works well
	 * enough for this example.
	 * 
	 * @param bean The bean containing all information about today.
	 */
	public static void printSong(SongBean bean) {
		int nbrOfNames = 0;
		
		System.out.println("Låten heter " + bean.getTitle());
		System.out.println("Artisten heter " + bean.getArtist());

	}
}
