package SeleniumFunctions;

import java.util.HashMap;
import java.util.Map;

public class gag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar= {4,1,2,1,2};
		System.out.println(singleNumber(ar));
//		var try="kol";
	}
	
	
	    public static int singleNumber(int[] nums) {
	        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	        
	    for(int i=0; i<nums.length;i++){
	       if(map.containsKey(nums[i])){
	           map.replace(nums[i],map.get(nums[i]) + 1);
	           System.out.println("HashMap: "
                       + map.toString());
	       } else{
	           map.put(nums[i],1);
	       }
	    }
	        for (Integer j : map.keySet()) {
	        	System.out.println("keys are:" +j);
	            if (map.get(j)==1){
	                System.out.println(j); 
	                return j;
	                
	            }
	        }
	      return 0;
	    }
	}



