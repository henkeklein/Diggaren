package StartPackage;

import java.io.UnsupportedEncodingException;

import Diggaren.Beans.Spotify.Test;
import Diggaren.Diggaren.DiggarenTest;

public class Run {

	public static void main (String [] args) throws UnsupportedEncodingException{
		DiggarenTest radio = new DiggarenTest();
		radio.startRadio();
		Test spotify = new Test();
		spotify.startSpotify();
		
	}
}
