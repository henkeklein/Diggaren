package Diggaren.Beans.SR;

import com.google.gson.annotations.SerializedName;

/**
 * Bean that holds information about id and name in the JSON-document from SR
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class ChannelBean {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	/**
	 * Empty constructor 
	 */
	public ChannelBean() {}

	/**
	 * Returns the ID
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Set id to the new id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Return name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name to the new name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	
}
