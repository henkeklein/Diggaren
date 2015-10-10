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

public class Test {
	SpotifyBean spotifyBean;
	ArtistBean artistBean;
	ItemBean itemBean;
	static String link;
	static String id;

	public void startSpotify(String bean) {

		String title = bean;

		try {
			title = URLEncoder.encode(title, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String baseUrl = "https://api.spotify.com/v1/search?type=track&limit=50&q=%27track:" + title;

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

					for (int i = 0; i < envelope.track.items.size(); i++) {
						if (i == 1) {
							printUrl(envelope.track.items.get(i));

						}
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

	private static void printUrl(ItemBean itemBean) {
		link = itemBean.getLink().getUrl();
		System.out.println("\n" + "URL länk: " + link);
		System.out.println("\n" + "-------------------------------");
		
	}

	public String getLink() {
		return link;

	}

	public String getID() {
		return id;

	}

}
