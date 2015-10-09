package Diggaren.Diggaren;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Diggaren.Diggaren.beans.ChannelBean;
import Diggaren.Diggaren.beans.Envelope;
import Diggaren.Diggaren.beans.Playlist;
import Diggaren.Diggaren.beans.SongBean;

/**
 * A small program that retrieves information about today from an external API
 * and presents this info in a more readable way as a console print out.
 * 
 * @author
 */
public class DiggarenTest {
	private static String title;
	
	public void startRadio(int channel) {
	String string;
	SongBean bean;
		String hejsan;

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
		

		Envelope envelope = null;
		Playlist playlist = null;

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
					envelope = json.fromJson(reader, Envelope.class);
					playlist = envelope.getPlaylist();
					
					// Print the info
					printChannel(playlist.getChannel());
					if (playlist.getSong() != null) {
					printSong(playlist.getSong());
					}
					if (playlist.getNextSong() != null) {
						printSong(playlist.getNextSong());
					}
				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("SR didn't respond in a good manner.");
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("SR didn't respond in a good manner.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printChannel(ChannelBean channel) {
		System.out.println("Channel name: " + channel.getName());
		System.out.println("Channel id: " + channel.getId());
	}
	
	public static void printSong(SongBean song) {
		System.out.println("Artist: " + song.getArtist());
		System.out.println("Title: " + song.getTitle());
		title = song.getTitle();
		System.out.println("Description: " + song.getDescription());
	}
	
	public static String getTitle() {
		return title;
	}


}
