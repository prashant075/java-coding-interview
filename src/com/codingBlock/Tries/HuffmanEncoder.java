package com.codingBlock.Tries;

import java.util.HashMap;

public class HuffmanEncoder {
	
	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;
	
	//Step 1: Create a freq map of this feeder string
	public HuffmanEncoder(String feeder){
		HashMap<Character, Integer> fmap=new HashMap<>();
		for(int i=0; i< feeder.length();i++){
			char cc =feeder.charAt(i);
			if(fmap.containsKey(cc)){
				int ov = fmap.get(cc);
				ov++;
				fmap.put(cc, ov);
			}else{
				fmap.put(cc, 1);
			}
		}
	}
	
	//Step2:Create the minHeap of Trees.
	
	private	class Node implements Comparable<Node>{
			Character data;
			int cost;
			Node left;
			Node Right;
			
			Node(char data, int cost){
				this.data =data;
				this.cost =cost;
				this.left =null;
				this.Right =null;
			}

			@Override
			public int compareTo(Node o) {
				return this.cost-o.cost;
			}
			
		}
}
