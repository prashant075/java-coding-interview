package com.codingBlock.tree;

public class BinarySearchTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinarySearchTree(int[] arr) {
		this.root = Construct(arr, 0, arr.length - 1);
	}

	private Node Construct(int[] arr, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node node = new Node();

		node.data = arr[mid];
		node.left = Construct(arr, lo, mid - 1);
		node.right = Construct(arr, mid + 1, hi);

		return node;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		String str = "";
		if (node == null) {
			return;
		}
		if (node.left != null) {
			str += node.left.data + "=>";
		} else {
			str += "End=>";
		}
		str += node.data;
		if (node.right != null) {
			str += "<=" + node.right.data;
		} else {
			str += "<=End";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (item > node.data) {
			return find(node.right, item);
		} else if (item < node.data) {
			return find(node.left, item);
		} else {
			return true;
		}

	}
	
	public int max(){
		return max(this.root);
	}

	private int max(Node node) {
		if(node.right==null){
			return node.data;
		}
		return max(node.right);
	}
	
	public void add(int item){
		add(this.root, item);
	}

	private void add(Node node, int item) {
		if(node.data >item){
			if(node.left==null){
				Node nn = new Node();
				nn.data =item;
				node.left = nn;
			}else{
				add(node.left,item);
			}
		}else{
			if(node.right==null){
				Node nn = new Node();
				nn.data =item;
				node.right = nn;
			}else{
				add(node.right,item);
			}
		}
		
	}

	

}
