package edu.unh.cs.Assignment2.Entitylinking;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


//parsing out entity link using DBPedia
public class EntityLinking {
	
	/*DBpedia Spotlight is a tool for automatically annotating mentions of DBpedia resources in text*/
	private String spotlightAPIurl = "http://model.dbpedia-spotlight.org/en/annotate?"; //creating spotlight API URL
    private final String data=null; 
	
	public ArrayList<String> getAnootatedListOfWords(String text) {
		ArrayList<String> wordresults = new ArrayList<String>();
       
		String httpUrl = spotlightAPIurl + "text=" + text.replace(" ", "%10");// Remove
																				// spaces.

		ArrayList<String> stringResponse = getHttpResponseString(httpUrl);

          //incomplete

		return wordresults;
	}

	// To get the HTTP Response
	//Queries DBpedia and returns a list of entities
	private ArrayList<String> getHttpResponseString(String urlStr) {
		try {

			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				System.out.println("Connection Failed with  " + urlStr + " with HTTP error code: " + conn.getResponseCode());
				if (conn.getResponseCode() == 401) {
				}
				return null;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			ArrayList<String> output = "";// br.readLine();
			String line = "";
			while ((line = br.readLine()) != null) {
				output += line;
			}

			conn.disconnect();
			return output;
		} catch (Exception e) {
			return null;
		}
	}





public static void main(String[] args) throws IOException {
	EntityLinking entityLinker = new EntityLinking();
    ArrayList<String> entities = entityLinker.getHttpResponseString("Mahatama Gandi was great leader");
    for (String entity : entities) {
        System.out.println(entity);
    }
}
}
