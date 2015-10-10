package Diggaren.Beans.SR;
import java.util.*;

import com.google.gson.annotations.*;;

public class Envelope {
	
		private Playlist playlist;
		
		@SerializedName("song")
		public ArrayList<SongListBean> list = new ArrayList<SongListBean>();
		

		public List<SongListBean> getList() {
			return list;
		}

		public void setList(ArrayList<SongListBean> list) {
			this.list = list;
		}

		public Envelope() {
			
		}
		
		public Playlist getPlaylist() {
			return playlist;
		}

		public void setPlaylist(Playlist playlist) {
			this.playlist = playlist;
		}
	}


