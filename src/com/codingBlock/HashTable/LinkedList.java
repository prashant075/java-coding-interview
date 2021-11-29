package com.codingBlock.HashTable;

public class LinkedList<T> {

	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public void display() {
		Node temp = this.head;

		while (temp != null) {
			System.out.println(temp.data + "=>");
			temp = temp.next;
		}
	}

	public void addLast(T item) {
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null;

		if (this.size >= 1) {
			this.tail.next = newNode;
		}

		if (this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
			this.size++;
		} else {
			this.tail = newNode;
			this.size++;
		}
	}

	public void addFirst(T item) {
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null;

		if (this.size >= 1) {
			newNode.next = head;
		}

		if (this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
			this.size++;
		} else {
			this.head = newNode;
			this.size++;
		}
	}

	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	public T getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	public T getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.head.data;
	}

	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.tail.data;
	}

	public T removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		T rv = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}
		return rv;
	}

	public T removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		T rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sizenm2 = getNodeAt(this.size - 2);
			this.tail = sizenm2;
			tail.next = null;
			this.size--;
		}

		return rv;

	}

	public T removeAt(int index) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		if (index < 0 || index > this.size) {
			throw new Exception("Invalid Index");
		}


		if (index == 0) {
			return removeFirst();
		}
		else if (this.size == index) {
			return removeLast();
		}
		else {
			Node node1 = getNodeAt(index - 1);
			Node n = node1.next;
			Node np1 = n.next;
			node1.next = np1;

			this.size--;
			return n.data;
		}
	}
	public int Find(T data){
		int index =0;
		for(Node temp = this.head;temp !=null;temp =temp.next){
			if(temp.data.equals(data)){
				return index;
			}
			index++;
		}
		return -1;
	}

	public boolean isEmpty() {
		int size = this.size;
		if (size == 0){
			return true;
		} 
		return false ;
	}
}