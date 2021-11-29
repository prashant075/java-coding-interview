package com.codingBlock.tree;

public class SegmentTreeClient {

	public static void main(String[] args) {
		int[] array={3,8,7,6,-2,-8,4,9};
		SegmentTree st = new SegmentTree(array);
		st.display();
		System.out.println("SUM is "+st.sum(2, 6));
		st.update(3, 14);
		System.out.println("SUM is "+st.sum(2, 6));
	}

}
