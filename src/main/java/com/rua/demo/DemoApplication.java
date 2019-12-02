package com.rua.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.*;

@SpringBootApplication(scanBasePackages = "com.rua.demo")
@ServletComponentScan
@MapperScan(basePackages = {"com.rua.demo.mapper"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		/*System.out.println(method("B1"));
		System.out.println(method("B10"));
		System.out.println(method("B11"));
		System.out.println(method("F21"));
		System.out.println(method("F1"));*/


		/*Set<List<Integer>> result = new HashSet<>();
		List<Integer> cur1 = new ArrayList<>();
		List<Integer> cur2 = new ArrayList<>();
		cur1.add(1);
		cur1.add(2);
		cur2.add(1);
		cur2.add(2);

		result.add(cur1);
		result.add(cur2);


		// ort();
		int[] arr = {10,1,2,7,6,1,5};

		combinationSum(arr, 8);*/

	}


	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(result, cur, candidates, target, 0);

		result.forEach(System.out::println);
		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int index){
		if(target == 0) {
			List<Integer> tmpList = new ArrayList<>(cur);
			result.add(tmpList);
			return;
		}

		for(int i = index; i < candidates.length; i++) {
			if(i > index && candidates[i] == candidates[i - 1]){
				continue;
			}

			int temp = candidates[i];

			cur.add(temp);

			dfs(result, cur, candidates, target-candidates[i], i + 1);

			cur.remove(cur.size() - 1);
		}
	}

	private static void sort() {
		Map<String, String> map = new HashMap<>();
		map.put("B1", "B111");
		map.put("B9", "B999");
		map.put("B3", "B333");
		map.put("F2", "F222");
		map.put("F5", "F555");

		/*List<String> list = map.keySet().stream().sorted((String o1, String o2) -> {
			if (o1.charAt(0) == o2.charAt(0) && o1.charAt(0) == 'B') {
				return -o1.compareTo(o2);
			} else if (o1.charAt(0) == o2.charAt(0) && o1.charAt(0) == 'F') {
				return o1.compareTo(o2);
			} else {
				return o1.compareTo(o2);
			}
		}).collect(Collectors.toList());

		for (String s: list) {
			System.out.println(s);
		}*/

		TreeMap<String, String> tree = new TreeMap<>((String o1, String o2) -> {
			if (o1.charAt(0) == o2.charAt(0) && o1.charAt(0) == 'B') {
				return -o1.compareTo(o2);
			} else if (o1.charAt(0) == o2.charAt(0) && o1.charAt(0) == 'F') {
				return o1.compareTo(o2);
			} else {
				return o1.compareTo(o2);
			}
		});

		tree.putAll(map);

		for(Map.Entry<String, String> entry: tree.entrySet()) {
			System.out.println(entry.getKey() + " === " + entry.getValue());
		}
	}

	private static String method(String input) {
		String front = input.substring(0,1);
		String back = input.substring(1);
		String result;

		if ("B".equals(front)) {
			result =  "-" + back + "F";
		} else {
			result = back + "F";
		}

		return result;
	}

}
