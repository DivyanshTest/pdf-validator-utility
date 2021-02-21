package com.listners;

import org.testng.annotations.Test;

public class B extends A{
B(){
	System.out.println("isnide the child class constructor ::" + this.hashCode());
}
public static int add(int x, int y) {

	return x-y;
}
	@Test 
	public void inside()  {
		int sum;
		
		sum= add(90, 4);
System.out.println(":" + this.hashCode()); 
	}
	
}
