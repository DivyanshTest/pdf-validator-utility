package Preparation.PreparationModule1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
//    	String command="curl -o C:\\Users\\DivyanshAgarwal\\Documents\\blabab.pdf https://reportstorageaccount.blob.core.windows.net/konsole-reports/Assessment%20Report_Atul%20_DrHXUi.pdf";
//    	Process p = Runtime.getRuntime().exec(command);
//        System.out.println( "Hello World!" );
//    }
    String ar[] = {"a","b"};
	Arrays.stream(ar).forEach((e) -> { System.out.println(e); });
//ArrayList items = new ArrayList();
ArrayList<String> items = new ArrayList<>();

items.add("coins");
items.add("pens");
items.add("keys");
items.add("sheets");

items.stream().filter(item -> (item.length() == 5)).forEach(System.out::println);
}
	
	
	
    }

