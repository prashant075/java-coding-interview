package com.codingBlock.queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingChar {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		Queue<Character> queue = new LinkedList<>();
		while(ch != '.'){
			queue.add(ch);
			if(map.containsKey(ch)){
				int ov = map.get(ch);
				ov +=1;
				map.put(ch, ov);
			}else{
				map.put(ch, 1);
			}
			
			while(!queue.isEmpty()){
				char fc = queue.peek();
				
				if(map.get(fc) ==1){
					System.out.println(fc);
					break;
				}else{
					queue.poll();
				}
			}
			
			if(queue.isEmpty()){
				System.out.println(-1);
			}
			
			ch = sc.next().charAt(0);
		}
	}
}
