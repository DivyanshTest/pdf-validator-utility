package com.listners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DEmo {
    public static String frequencySort(String s) {
        String result ="";
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        List<Character>[]ls = new List[s.length()+1];
        for(char c : s.toCharArray() ){
            hash.put(c, hash.getOrDefault(c, 0) + 1);

        }
        for(Character c : hash.keySet()){
            int w = hash.get(c);
            if(ls[w]!=null){
                
                ls[w].add(c);
            }
            ls[w] = new ArrayList();
             System.out.println(ls.toString());
        }
         for(int i =ls.length-1; i>=0 ;i--){
            if(ls[i]!=null){
             List<Character>res = ls[i];
              for(char r: res){
                  System.out.println("my reult" + res.get(r));
                  result+=res.get(r);
             }
            }
         }
        return result;
    }
   public static void main(String...args) {
	   System.out.println("result" +frequencySort("tree"));
	
}
}