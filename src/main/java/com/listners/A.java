package com.listners;

public class A {
int a=9;
int b=8;
A(){
	System.out.println("inside parent constructor::" + this.hashCode());
}
public int add1(int x,int y) {
	
	
	return x+y;
	
}
}
