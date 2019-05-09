package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapUtils {

	public static HashMap<Integer, User> sortHashMap(Map<Integer, User> userMap){
		Set<Integer> ageSet = userMap.keySet();
		List<Integer> ageList = new ArrayList<Integer>();
		ageList.addAll(ageSet);
		
		LinkedHashMap<Integer, User> resultMap = new LinkedHashMap<Integer, User>();
		
		Collections.sort(ageList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.intValue() - o1.intValue();
			}
			
		});
		
		for(Integer age: ageList) {
			resultMap.put(age, userMap.get(age));
		}
		return resultMap;
	}
	
	public static void main(String[] args) {
		Map<Integer, User> userMap = new HashMap<Integer, User>();
		
		User user1 = new User("张三", 25);
		User user2 = new User("李四", 27);
		User user3 = new User("王五", 22);
		User user4 = new User("赵六", 11);
		User user5 = new User("田七", 19);
		
		userMap.put(25, user1);
		userMap.put(27, user2);
		userMap.put(22, user3);
		userMap.put(11, user4);
		userMap.put(19, user5);
		
		System.out.println(userMap);
		
		HashMap<Integer, User> resultList = sortHashMap(userMap);
		
		System.out.println(resultList);
	}
	
}
