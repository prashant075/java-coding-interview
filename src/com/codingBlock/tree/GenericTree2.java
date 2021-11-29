package com.codingBlock.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree2 {
	Scanner sc = new Scanner(System.in);
	private class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	private Node root;
	GenericTree2(){
		root =construct(null,-1);
		
	}
	
	private Node construct (Node parent , int ith){
		if(parent ==null){
			System.out.println("Enter the data for Parent Node ?");
		}else{
		System.out.println("Enter the data for "+ith+"  child of "+parent.data+" ?");
		}
		
		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		
		System.out.println("Enter the No of Child for "+nn.data+" ?");
		
		int noc = sc.nextInt();
		
		for(int i=0;i<noc;i++){
			Node child = construct(nn,i);
			nn.children.add(child);
		}
		return nn;
		
	}
	public void display(){
		System.out.println("--------------------------------");
		this.display(root);
		System.out.println("--------------------------------");
	}

	private void display(Node node) {
		String str ="";
		str = str + node.data+" => ";
		for(Node no: node.children){
			str = str + no.data+" ";
		}
		str = str + " .";
		System.out.println(str);
		for(Node no: node.children){
			display(no);
		}

		
	}
	
	public int Size(){
		return this.Size(root);
	}

	private int Size(Node node) {
		int ts =0;
		for(Node nn: node.children){
			int cs = Size(nn);
			ts +=cs;
		}
		return ts+1;
	}
	public boolean find(int item){
		return this.find(root,item);
	}

	private boolean find(Node node,int item) {
		if(node.data==item)
			return true;
	
		for(Node nn: node.children){
			boolean cs = find(nn,item);
			if(cs)
				return true;
		}
		return false;
		
	}
	public int max(){
		return this.max(root);
	}

	private int max(Node node) {
		int tm = node.data;
		for(Node nn: node.children){
			int cm = max(nn);
			if(cm > tm){
				tm = cm;
			}
		}
		return tm;
		
	}
	public int height(){
		return this.height(root);
	}

	private int height(Node node) {
		int th = -1;
		for(Node nn: node.children){
			int ch = height(nn);
			if(ch > th){
				th = ch;
			}
		}
		return th+1;
		
	}
}
