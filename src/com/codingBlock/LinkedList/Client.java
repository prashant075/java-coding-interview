package com.codingBlock.LinkedList;

public class Client {
	public static void main(String[] args) throws Exception{
	LinkedList list = new LinkedList();
	list.addLast(10);
	list.addLast(20);
	list.addFirst(5);
	list.display();
	System.out.println(list.removeLast());
	list.addFirst(15);
	list.display();
	list.reverseData();
	list.display();
	list.reversePointers();
	list.display();
	System.out.println(list.mid());
	
	}
}
