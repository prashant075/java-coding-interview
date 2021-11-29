package com.codingBlock.tree;

public class BinarySearchTreeClient {

	public static void main(String[] args) {
		int []array={10,20,30,40,50,60,70};
		BinarySearchTree bst = new BinarySearchTree(array);
		bst.display();
		System.out.println("Is item 100 Present in tree "+bst.find(100));
		System.out.println("Max Node Value in tree "+bst.max());
		System.out.println("Add 55 into BST ");
		bst.add(55);
		bst.display();

	}

}
