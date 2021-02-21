package SeleniumFunctions;

import java.util.HashSet;

public class Test{

    public static void main(String []args){
    	System.out.println(result());

    }
    public static int result() {
    	String s ="loveleetcode";
        HashSet <Character> hs = new HashSet<Character>();
        int res=0;
        String[]  c = s.split("");
        for(int i=0;i<s.length();i++){
        	System.out.println(s.charAt(i));
            if(hs.contains(s.charAt(i))){
//                System.out.print(ch);
            	hs.remove(s.charAt(i));
         	   
            }
            else {
            	hs.add(s.charAt(i));
            }
            }
        System.out.println(hs);
        return s.indexOf(hs.iterator().next());
    	
    }
}