package Diggaren.Diggaren.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.annotations.SerializedName;

public class SRBean {

	@SerializedName("song")
//	public Map<String, SongBean> playlist = new TreeMap<String, SongBean>();
	public SongBean bean = new SongBean();

	@SerializedName("nextsong")
	public NextSongBean bean2 = new NextSongBean(); 
	
//	@SerializedName("channel")
//	private ChannelBean beanInfo;

	/**
	 * Being a bean, the class needs an empty, public constructor.
	 */
	public SRBean() {
		
	}



//	public ChannelBean getBeanInfo() {
//		return beanInfo;
//	}



//	public void setBeanInfo(ChannelBean beanInfo) {
//		this.beanInfo = beanInfo;
//	}

	public SongBean getPlaylist() {
		return bean;
	}
	
}
