package com.codingBlock.HashTable;

public class Client {
	
	public static void main(String [] args) throws Exception{
		HashTable<String, Integer> map= new HashTable<>(3);
		map.put("USA", 200);
		map.put("UK", 175);
		map.put("India", 300);
		map.put("China", 350);

		map.display();
		map.put("Sweden", 100);
		
		map.display();
		map.put("AUS", 325);
		map.put("RSA", 225);
		map.display();
		
		System.out.println("*****************");
		System.out.println(map.get("India"));
		System.out.println(map.get("AUS"));
		System.out.println("*****************");
		System.out.println(map.remove("India"));
		System.out.println(map.remove("AUS"));
		map.display();
	}

}
