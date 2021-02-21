package Preparation.PreparationModule1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		Object obj = new JSONParser().parse(new FileReader("C:\\\\Users\\\\DivyanshAgarwal\\\\new Eclipse\\\\PreparationModule1\\\\JsonFiles\\\\test.json"));
//		System.out.println(obj);
		JSONObject jo = (JSONObject) obj;
//		System.out.println(jo.get("address"));
		System.out.println("this is aray of object:: "+ jo.get("phoneNumbers"));
		ArrayList<Object> ls = new ArrayList<Object>();
		ls = (ArrayList<Object>) jo.get("phoneNumbers");
		
		ls.forEach((item)->{
			System.out.println(item  	 );
			Map<String, Object> mp = (Map<String, Object>) item;
			System.out.println(mp.get("type"));
			
		});
		
		
	}

}
