package Diggaren.Beans.Spotify;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import Diggaren.Diggaren.beans.SongBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
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
	 * @throws UnsupportedEncodingException 
	 */
	public void startSpotify() {
		SongBean bean = new SongBean();

		String baseUrl = "https://api.spotify.com/v1/search?type=track&limit=50&q=%27track:"+ bean.getTitle();
	
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
				
					for (int i = 0; i < 1; i++){
						printUrl(envelope.artists.items.get(i));						
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
		ArrayList<String> arr = new ArrayList<String>();
		for (int i =0; i < 1; i++){
			arr.add(itemBean.getLink().getUrl());
			System.out.println("URL länk: " + arr + "\n");			
		
		}
	}
	
}


