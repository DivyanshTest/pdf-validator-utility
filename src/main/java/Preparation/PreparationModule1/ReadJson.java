package Preparation.PreparationModule1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson{

	public static void main(String[] args) throws IOException, ParseException {
		String data[] =jsonData();
		
		System.out.println(Arrays.deepToString(data));
	}
	public static String[] jsonData() throws IOException, ParseException {
		
		JSONParser jp = new JSONParser();
		FileReader reader = new FileReader("C:\\Users\\DivyanshAgarwal\\new Eclipse\\PreparationModule1\\JsonFiles\\data.json");
		Object obj = jp.parse(reader);
		JSONObject userData = (JSONObject)obj;
		JSONArray usersCred = (JSONArray) userData.get("users");
		
		String array[] = new String[usersCred.size()];
		for(int i = 0; i<usersCred.size(); i++) {
			JSONObject users = (JSONObject) usersCred.get(i);
			String username = (String) users.get("username");
			String pwd = (String) users.get("password");
			array[i] = username+","+pwd;
		}
				
		 return array;
		
	}

}
