package Diggaren.Beans.Spotify;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Class that starts all the Spotify beans.
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class SpotifyStarter {
	SpotifyBean spotifyBean;
	ArtistBean artistBean;
	ItemBean itemBean;
	String link;
	String id;
	/**
	 * @param bean as a titel.
	 * Gets a titel and mapps it to a URL. Catch if no songs are played.
	 * Call the Spotify API and sets all the HTTP and other clients to null.
	 * Creates a new GSONbuilder.
	 * Create the client that will call the API and call the API and verify that all went well.
	 * If all went well it tries to parse the data as JSON.
	 * Then iterates through all the items and prints out the url.
	 */
	public void startSpotify(String bean) {
		String title = bean;
		try {
			title = URLEncoder.encode(title, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		} catch (NullPointerException e) {
			System.out.println("Ingen låt spelas just nu");
		}

		String baseUrl = "https://api.spotify.com/v1/search?query=" + title + "&offset=0&limit=20&type=track";

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
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet(baseUrl);
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {
				entity = response.getEntity();
				data = entity.getContent();

				try {
					reader = new InputStreamReader(data);
					json = builder.create();
					envelope = json.fromJson(reader, SpotifyBean.class);

					for (int i = 0; i < envelope.track.items.size(); i++) {
						if (i == 1) {
							printUrl(envelope.track.items.get(i));

						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Det blev fel.");
				}
			} else {
				System.out.println("API:t svarade inte.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Sets link to an url link to Spotify.
	 * @param itemBean as a ItemBean.
	 */
	private void printUrl(ItemBean itemBean) {
		link = itemBean.getLink().getUrl();
	}
	/**
	 * 
	 * @return a link as a String.
	 */
	public String getLink() {
		return link;
	}
	/**
	 * 
	 * @return a id as a String.
	 */
	public String getID() {
		return id;
	}

}
