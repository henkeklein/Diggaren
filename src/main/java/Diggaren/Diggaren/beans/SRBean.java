package Diggaren.Diggaren.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.annotations.SerializedName;

public class SRBean {

//	@SerializedName("playlist")
//	public Map<String, SongBean> playlist = new TreeMap<String, SongBean>();
//	public SongBean bean = new SongBean();

//	@SerializedName("nextsong")
//	public NextSongBean bean2 = new NextSongBean(); 
	
	
	@SerializedName("playlist")
	public Map<String, SongBean> playlist = new TreeMap<String, SongBean>();
//	private ChannelBean beanInfo;

	/**
	 * Being a bean, the class needs an empty, public constructor.
	 */
	public SRBean() {
		
	}



	public Map<String, SongBean> getBeanInfo() {
		return playlist;
	}


	public Map<String, SongBean> getPlaylist() {
		return playlist;
	}
	
}
