package Preparation.PreparationModule1;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {
	
public static void main(String[] args){
		
		System.out.println(ReadJson());
	}
	
	
public Static String  readJson() {
		
		JSONParser jp = new JSONParser();
		FileReader reader = new FileReader("C:\\Users\\DivyanshAgarwal\\new Eclipse\\PreparationModule1\\JsonFiles\\data.json");
		Object obj = jp.parse(reader);
		JSONObject userData = (JSONObject)obj;
		
		 return userData;
		
	}
	
}




