package Diggaren.Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Diggaren.Beans.SR.Playlist;
import Diggaren.Beans.SR.SRStarter;
import Diggaren.Beans.Spotify.SpotifyStarter;

public class JavaToJson {
	
//	public static void main(String[] args) {
//		CreateJson json = new CreateJson();
//		json.setValues();
//		GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//        System.out.println(gson.toJson(json));
//	}
	
	public String getJson() {
		CreateJson json = new CreateJson();
		json.setValues();
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(json));
        return gson.toJson(json);
	}

}
