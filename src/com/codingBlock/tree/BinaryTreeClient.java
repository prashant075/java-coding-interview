package com.codingBlock.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeClient {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.display();
		
		System.out.println("Height of the tree is "+bt.height());
		System.out.println("PerOrder of the Tree is ");
		bt.preOrder();
		System.out.println("\nInOrder of the Tree is ");
		bt.InOrder();
		
		System.out.println("\nPostOrder of the Tree is ");
		bt.PostOrder();
		
		System.out.println("\nLevelOrder of the Tree is ");
		bt.LevelOrder();
		
		System.out.println("\nInOrder Iterative of the Tree is ");
		List<Integer> list = new ArrayList<>();
		list = bt.InOrderIterative();
		System.out.println(list);
		
		System.out.println("Sum of Leaf Node is "+bt.sumOfLeafNode());
		
		System.out.println("DiaMeter of Tree is "+bt.diaMeterOfTree());
		
		System.out.println("More better way for DiaMeter of Tree is "+bt.diameterBtr());
		
		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(30));
		System.out.println(bt.ht());
		System.out.println(bt.isBalanced());
		System.out.println(bt.isBalancedUsingBP());
		
		bt.preorderI();
		System.out.println("------------------------");
		System.out.println(bt.maxSubtreeSum());
		System.out.println(bt.maxSubtreeSum2());
		System.out.println(bt.maxSubtreeSum3());
		
		/*
		 * Pre, In => unique Tree can be created
		 * Post, In => unique Tree can be created
		 * */
		
		int[] pre = {10,20,40,30,50,60,70};
		int[] in ={40,20,10,50,30,60,70};
		BinaryTree bt2 = new BinaryTree(pre, in);
		bt2.display();
		
		int[] pre11 = {10,30,70,60,20,50,40};
		int[] in11 ={70,30,60,10,50,20,40};
		BinaryTree bt21 = new BinaryTree(pre11, in11);
		bt2.display();
		System.out.println("00000000000000000000000000000");
		System.out.println(bt.Mirror(bt2, bt21));
		
		
		
		
	}

}

/*
o/p
50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
Enter the data for Root Node
50
Do you have Left Child of 50
true
Enter the data for left chid of 50
25
Do you have Left Child of 25
false
Do you have Right Child of 25
true
Enter the data for Right chid of 25
48
Do you have Left Child of 48
true
Enter the data for left chid of 48
18
Do you have Left Child of 18
false
Do you have Right Child of 18
false
Do you have Right Child of 48
false
Do you have Right Child of 50
true
Enter the data for Right chid of 50
45
Do you have Left Child of 45
true
Enter the data for left chid of 45
85
Do you have Left Child of 85
false
Do you have Right Child of 85
false
Do you have Right Child of 45
true
Enter the data for Right chid of 45
60
Do you have Left Child of 60
false
Do you have Right Child of 60
false
25=>50<=45
END=>25<=48
18=>48<=END
END=>18<=END
85=>45<=60
END=>85<=END
END=>60<=END 
*/