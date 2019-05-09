package String;

import java.util.HashMap;
import java.util.Map;

public class StringDemo {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("a");
		sb.append("b");
		System.out.println(sb.toString());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", 1);
		map.put("b", 2);
		
		System.out.println("b".hashCode());
		System.out.println(Integer.valueOf(1).hashCode());
		System.out.println(98 ^ 1);
		System.out.println("hashCode:" + map.get("b").hashCode());
		
		String str = "abc";
		int hash = 0;
		char[] chars = str.toCharArray();
		int h = 0;
		if (h == 0 && chars.length > 0) {
            char val[] = chars;

            for (int i = 0; i < chars.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
		System.out.println(hash);
		System.out.println(str.hashCode());
		
	}
	
}
