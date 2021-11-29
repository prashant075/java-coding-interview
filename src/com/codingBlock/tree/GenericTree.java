package com.codingBlock.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

	private class Node{
		int data;
		ArrayList<Node> children;
		Node(int data){
			this.data =data;
			this.children= new ArrayList<>();
		}
	}
	
	private Node root;
	private int size;
	
	GenericTree(){
		Scanner sc = new Scanner(System.in);
		this.root = takeInput(sc,null,0);
	}

	private Node takeInput(Scanner sc, Node parent, int ithChild) {
		if(parent == null){
			System.out.println("Enter the Data for the Root NOde ");
		}else{
			System.out.println("Enter the Data for the "+ithChild+"th child of "+parent.data);
		}
		int nodedata = sc.nextInt();
		Node newNode = new Node(nodedata);
		this.size++;
		System.out.println("Enter the number of childern for "+newNode.data);
		int childrens = sc.nextInt();
		
		for(int i=0;i< childrens;i++){
			Node child =this.takeInput(sc, newNode, i);
			newNode.children.add(child);
		}
		return newNode;
	}
	
	public void display(){
		this.display(this.root);
	}

	private void display(Node node) {
		String str = node.data+"=>";
		for(int i=0; i< node.children.size();i++){
			str = str + node.children.get(i).data+", ";
		}
		str = str +"END";
		System.out.println(str);
		for(int i=0; i< node.children.size();i++){
			this.display(node.children.get(i));
		}
		
		
	}

}
