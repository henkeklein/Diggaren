package Diggaren.Web;

import static spark.Spark.*;

import java.util.List;

import Diggaren.Diggaren.beans.ChannelBean;
import Diggaren.Diggaren.beans.SRBean;

public class WebService {
	public static void main (String [] args){
		get("/hej", (req, res) -> "Inga fel");
		get("/kanal", (req, res) -> {
			SRBean b = new SRBean();
        	List<ChannelBean> list = b.getAll();
        	String allUni = "";
    		for (ChannelBean bean : list) {
    			System.out.println(bean.getId() + ": " + bean.getName());
    			allUni += ("<p>" + bean.getId() + ": " + bean.getName() + "</p>");
    		}
    		return allUni;
        });
	}

}
