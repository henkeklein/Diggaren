package Diggaren.Diggaren.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.annotations.SerializedName;

public class SRBean {

	@SerializedName("playlist")
	public Map<String, SongBean> playlist = new TreeMap<String, SongBean>();

	@SerializedName("channel")
	private ChannelBean beanInfo;

	/**
	 * Being a bean, the class needs an empty, public constructor.
	 */
	public SRBean() {
		
	}



	public ChannelBean getBeanInfo() {
		return beanInfo;
	}



	public void setBeanInfo(ChannelBean beanInfo) {
		this.beanInfo = beanInfo;
	}

	public Map<String, SongBean> getPlaylist() {
		return playlist;
	}
	
	public List<ChannelBean> getAll (){
		List <ChannelBean> bean = new ArrayList<ChannelBean>();
		Iterator<ChannelBean> iter = bean.iterator();
		while (iter.hasNext()){
			ChannelBean b = new ChannelBean();
			b.getId();
			b.getName();
		}
		return bean;
		
	}
}
