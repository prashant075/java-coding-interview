package com.codingBlock.tree;

public class SegmentTree {
	public class Node{
		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;
	}
	private Node root;
	public SegmentTree(int[] arr){
		this.root = ConstructTree(arr,0,arr.length-1);
	}
	private Node ConstructTree(int[] arr, int st, int en) {
		if(st ==en){
			Node leafNode = new Node();
			leafNode.data = arr[st];
			leafNode.startInterval=st;
			leafNode.endInterval =en;
			return leafNode;
		}
		Node node = new Node();
		node.startInterval = st;
		node.endInterval = en;
		int mid =(st+en)/2;
		node.left = ConstructTree(arr,st,mid);
		node.right = ConstructTree(arr,mid+1,en);
		node.data = node.left.data + node.right.data;
		
		return node;
	}
	
	public void display(){
		this.display(this.root);
	}
	private void display(Node node) {
		String str = "";
		if(node.left!=null){
			str = str+ "Interval =["+node.left.startInterval+" , "+node.left.endInterval+"]" + " and Data = "+node.left.data+" =>" ;
		}else{
			str =str+ " No Left Child => ";
		}
		str = str +"Interval = "+ "["+node.startInterval+" , "+node.endInterval+"] and Data ="+ node.data;
		
		if(node.right!=null){
			str = str+" <=data is = "+node.right.data +" and Interval is "+"["+node.right.startInterval+" , "+node.right.endInterval+"]" ;
		}else{
			str =str+ " No Right Child";
		}
		System.out.println(str);
		if(node.left!=null){
			display(node.left);
		}
		if(node.right!=null){
			display(node.right);
		}
		
		
	}
	
	public int sum(int st, int en){
		return this.sum(this.root,st, en);
	}
	private int sum(Node node, int qst, int qen) {
		if(node.startInterval>=qst && node.endInterval<=qen){
			return node.data;
		}else if(node.startInterval>qen || node.endInterval<qst){
			return 0;
		}else{
			int leftans = sum(node.left,qst,qen);
			int rightans = sum(node.right,qst,qen);
			return leftans +rightans;
		}
	}
	public void update(int index, int newVal){
		this.root.data=update(this.root,index,newVal);
	}
	private int update(Node node, int index, int newVal) {
		if(index>=node.startInterval&& index<=node.endInterval){
			if(node.startInterval==index && node.endInterval==index){
				 node.data=newVal;
			}else{
				int leftval = update(node.left,index,newVal);
				int rightval = update(node.right,index,newVal);
				node.data= leftval+rightval;
			}
		}
		return node.data;
	}
}
