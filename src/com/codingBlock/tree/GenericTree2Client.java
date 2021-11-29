package com.codingBlock.tree;

public class GenericTree2Client {

	public static void main(String[] args) {
		GenericTree2 gt = new GenericTree2();
		gt.display();
		
		System.out.println("Size of tree is "+gt.Size());
		System.out.println("Find for this in Tree "+gt.find(60));
		System.out.println("Max in this Tree is "+gt.max());
		System.out.println("Height of the tree is "+gt.height());
		//10 3 20 2 50 0 60 0 30 0 40 1 70 0

	}

}
