package com.codingBlock.Misc;

import java.util.ListIterator;
import java.util.Vector;

public class VectorDemo {
	
	public static void main(String[] args){
		
		Vector<Integer> vector = new Vector<>();
		vector.ensureCapacity(20);
		vector.add(1);
		vector.add(2);
		vector.add(3);
		System.out.println(vector);
		System.out.println(vector.size());
		
		ListIterator<Integer> list = vector.listIterator(); 
		
		while(list.hasNext()){
			System.out.println(list.next());
		}
		
		while(list.hasPrevious()){
			System.out.println(list.previous());
		}
	}

}
