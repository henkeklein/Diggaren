package Diggaren.Beans.SR;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Initiates the API from Sveriges Radio (SR)
 * 
 * @author Henrik Klein, Dennis Kristensson, Daniel H-E
 */
public class SRStarter {
	private static String firstSong;
	
	//This string will represent every sons that have been played
	private static String songsPlayed;

	public void startRadio(int channel) {

		String baseUrl = "http://api.sr.se/api/v2/playlists/rightnow?channelid=" + channel + "&format=json";	

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
		System.out.println("CHANNEL:");
		System.out.println("Channel name: " + channel.getName());
		System.out.println("Channel id: " + channel.getId());

	}

	public static void printSong(SongBean song) {
		System.out.println("\n" + "-------------------------------");
		System.out.println("SONG:");
		System.out.println("Artist: " + song.getArtist());
		System.out.println("Title: " + song.getTitle());
		System.out.println("Description: " + song.getDescription());
		System.out.println("\n" + "-------------------------------");

		firstSong = song.getArtist() + "  -  " + song.getTitle() + "  -  ";
	}

	
	public String getFirstSong() {
		return firstSong;
	}
	
//-----------------------------------Separates the list functions from the "first song" function----------------------------------	
	/*
	 * Prints every song played on 9/10-15
	 */
	public static void printSongList(SongListBean bean) {
		System.out.println("Artist: " + bean.getArtist());
		System.out.println("Song: " + bean.getTitle());
		songsPlayed = bean.getTitle();
		System.out.println("---------------------------");
	}
	
	/*
	 * Is not being used anymore
	 */
	public String getSongsPlayed() {
		return songsPlayed;
	}
	
	/*
	 * Method to get all songs 9/10-15.
	 * Might change the parameter to receive a start time and a stop time.
	 */
	public ArrayList<SongListBean> createAndGetList() {
		String baseUrl = "http://api.sr.se/api/v2/playlists/getplaylistbyprogramid?id=2576&startdatetime=2015-10-09&format=json";

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

					// Print the info
//					for (int i = 0; i < envelope.list.size(); i++) {
//						//printSongList(envelope.list.get(i));
//						return envelope.list;
//					}
					
					// Simply returns list
					return envelope.list;
		//			System.out.println("Songs played this day: " + envelope.list.size());

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
		return null;
	}
}
