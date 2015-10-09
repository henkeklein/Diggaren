package Diggaren.Diggaren.beans;

import com.google.gson.annotations.SerializedName;

public class ChannelBean {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	public ChannelBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
