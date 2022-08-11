package in.shaukat;

import java.util.HashMap;
import java.util.Map;

public class MainDriver {

	public static void main(String[] args) {
		
		
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("a", 2);
		
		 Object object = map.get("a");
		 
		 Integer object1 = (Integer)map.get("a");
		 System.out.println(object1);
		 
//		 Integer s=(Integer)object;
//		System.out.println(s);
		
	}
}
