package Diggaren.Diggaren;
import static spark.Spark.get;
import spark.Spark.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Diggaren.Diggaren.beans.ChannelBean;
import Diggaren.Diggaren.beans.NextSongBean;
import Diggaren.Diggaren.beans.SRBean;
import Diggaren.Diggaren.beans.SongBean;

/**
 * A small program that retrieves information about today from an external API
 * and presents this info in a more readable way as a console print out.
 * 
 * @author
 */
public class DiggarenTest {
	String string;
	SongBean bean;
	static String hejsan;
	/**
	 * The main method that's used to run the program.
	 * 
	 * @param args Arguments from the command line. This program won't honor
	 * 		  them at all.
	 */
	public void startRadio(int channel) {
		String baseUrl = "http://api.sr.se/api/v2/playlists/rightnow?channelid="+ channel+ "&format=json";
		
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
//					for (Entry<String, SongBean> song : envelope.playlist.entrySet()) {
//						System.out.println(song.getKey());
//						printSong(song.getValue());	
//					}
					
					for (int i = 0; i < 1; i++){
						printSong(envelope.bean);
						printNextSong(envelope.bean2);
					}
											
//					
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
		
		// Yep, that went well. Let's print today's information.
		// As the API will return a list of days, we'll need to
		// fetch "today", which will be the first and only object.
		
	}



	/**
	 * Prints info about today. This method makes no effort trying to be of
	 * great coding standard. In fact, it looks like crap, but works well
	 * enough for this example.
	 * 
	 * @param songBean The bean containing all information about today.
	 */
	public static void printSong(SongBean songBean) {
		System.out.println("Låten heter: " + songBean.getTitle() + "\n");
	
		hejsan = songBean.getTitle();
	
	}
	
	public static void printNextSong(NextSongBean songBean) {
		System.out.println("Låten heter: " + songBean.getTitle() + "\n");
	
		hejsan = songBean.getTitle();
	
	}
	
	
	
	public String getTitle() {
		return hejsan;
	}

	
}
