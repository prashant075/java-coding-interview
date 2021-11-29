package com.codingBlock.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	private class Node{
		int data;
		Node left;
		Node right;
		Node(int data, Node left, Node right){
			this.data =data;
			this.left = left;
			this.right =right;
		}
		public Node() {
			
		}
	}
	private Node root = null;
	private int size =0;
	BinaryTree(){
		Scanner sc = new Scanner(System.in);
		this.root = takeInput(sc, root, false);
	}
	
	private Node takeInput(Scanner sc, Node parent, boolean isLeftOrRight) {
		if(parent==null){
			System.out.println("Enter the data for Root Node");
		}else{
			if(isLeftOrRight){
				System.out.println("Enter the data for left chid of "+parent.data);
			}else{
				System.out.println("Enter the data for Right chid of "+parent.data);
			}
		}
		int newdata = sc.nextInt();
		Node node = new Node(newdata,null,null);
		this.size++;
		
		boolean choice = false;
		System.out.println("Do you have Left Child of "+node.data);
		choice = sc.nextBoolean();
		 
		if(choice){
			node.left=takeInput(sc, node,true);
		}
		
		choice = false;
		System.out.println("Do you have Right Child of "+node.data);
		choice = sc.nextBoolean();
		if(choice){
			node.right=takeInput(sc, node,false);
		}
		
		return node;
	}
	
	BinaryTree(int[] pre, int[] in ){
		root = construct(pre, 0,pre.length-1,in, 0, in.length-1);
	}
	
	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		
		if(ilo > ihi || plo > phi){
			return null;
		}
		Node nn = new Node();
		nn.data =pre[plo];
		int nel =0;
		int si = -1;
		for(int i=ilo; i <= ihi; i++){
			if(pre[plo] == in[i]){
				si =i;
				break;
			}
			nel++;
		}
		
		nn.left  =construct(pre, plo+1,plo+nel,in,ilo,si-1);
		nn.right =construct(pre, plo+nel+1,phi,in,si+1,ihi);
		return nn;
	}

	public void display(){
		display(this.root);
	}

	private void display(Node node) {
		String str = "";
		
		if(node.left != null){
			str =str + node.left.data+ "=>";
		}else{
			str =str+"END=>";
		}
		str = str+node.data;
		if(node.right != null){
			str = str+"<="+node.right.data;
		}else{
			str =str+"<=END";
		}
		System.out.println(str);
		
		if(node.left!=null){
			this.display(node.left);
		}
		if(node.right!=null){
			this.display(node.right);
		}
		
	}
	
	public int height(){
		return this.height(this.root);
	}

	private int height(Node node) {
		if(node == null){
			return -1;
		}
		int lheight = height(node.left);
		int rheight = height(node.right);
		
		int height = Math.max(lheight, rheight)+1;
		return height;
	}
	
	public void preOrder(){
		 this.preOrder(this.root);
		 System.out.print("END");
		 
	}

	private void preOrder(Node node) {
		if(node ==null){
			return ;
		}
		System.out.print(node.data+", ");
		preOrder(node.left);
		preOrder(node.right);
		
	}
	public void InOrder(){
		 this.InOrder(this.root);
		 System.out.print("END");
	}

	private void InOrder(Node node) {
		if(node ==null){
			return ;
		}
		
		InOrder(node.left);
		System.out.print(node.data+", ");
		InOrder(node.right);
		
		
	}
	
	public void PostOrder(){
		 this.PostOrder(this.root);
		 System.out.print("END");
	}

	private void PostOrder(Node node) {
		if(node ==null){
			return ;
		}
		
		PostOrder(node.left);
		PostOrder(node.right);
		System.out.print(node.data+", ");
		
	}
	
	
	public void LevelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);
		while(!queue.isEmpty()){
			Node node= queue.removeFirst();
			System.out.print(node.data+", ");
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
			
		}
		System.out.print("END");
		
	}
	public List<Integer> InOrderIterative(){
		return this.InOrderIterative(this.root);
	}

	private List<Integer> InOrderIterative(Node node) {
		Stack<Node> stack = new Stack<>();
		ArrayList<Integer> list  =new ArrayList<>();
		if(node ==null){
			ArrayList<Integer> li  =new ArrayList<>();
			return li;
		}
		while(true){
			if(node!=null){
				stack.push(node);
				node = node.left;
			}else{
				if(stack.isEmpty()){
					break;
				}
				
				node = stack.pop();
				list.add(node.data);
				node = node.right;
			}
			
		}
		return list;
			
	}
	
	public int sumOfLeafNode(){
		return this.sumOfLeafNode(this.root);
	}

	private int sumOfLeafNode(Node node) {
		if(node == null){
			return 0;
		}
		if(node.left == null && node.right==null){
			return node.data;
		}
		int lsum = sumOfLeafNode(node.left);
		int rsum = sumOfLeafNode(node.right);
		return lsum+rsum;
	}
	public int diaMeterOfTree(){
		return this.diaMeterOfTree(this.root);
	}

	private int diaMeterOfTree(Node node) {
		if(node ==null){
			return 0;
		}
		int case1 = this.height(node.left)+this.height(node.right)+2;
		int case2 = diaMeterOfTree(node.left);
		int case3 = diaMeterOfTree(node.right);
		
		return Math.max(case1, Math.max(case2, case3));
	}
	
	
	public class DiaPair{
		int high;
		int diaMeter;
		
		DiaPair(){
			
		}
		DiaPair(int high,int diameter ){
			this.high=high;
			this.diaMeter = diameter;
		}
		
	}
	
	public int diameterBtr(){
		return this.diameterBtr(this.root).diaMeter;
	}

	private DiaPair diameterBtr(Node node) {
		if(node == null){
			DiaPair bp = new DiaPair(-1,0);
			return bp;
		}
		DiaPair lp = this.diameterBtr(node.left);
		DiaPair rt = this.diameterBtr(node.right);
		
		DiaPair mp = new DiaPair();
		mp.high = Math.max(lp.high, rt.high)+1;
		
		mp.diaMeter = Math.max(lp.high+rt.high+2, Math.max(lp.diaMeter, rt.diaMeter));
		
		return mp;
	}
	
	public int size(){
		return size(root);
		
	}

	private int size(Node node) {
		if(node == null){
			return 0;
		}
		
		int ls = size(node.left);
		int rs = size(node.right);
		return ls + rs +1;
	}
	
	public int max(){
		return max(root);
		
	}

	private int max(Node node) {
		if(node == null){
			return Integer.MIN_VALUE;
		}
		
		int lm = max(node.left);
		int rm = max(node.right);
		return Math.max(node.data, Math.max(lm, rm));
	}
	
	public boolean find(int item){
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if(node == null){
			return false;
		}
		if(node.data == item){
			return true;
		}
		boolean lf =find(node.left,item);
		boolean rf =find(node.right,item);
		return lf || rf;
	}
	
	public int ht(){
		return ht(root);
		
	}

	private int ht(Node node) {
		if(node == null){
			return -1;
		}
		
		int lh = ht(node.left);
		int rh = ht(node.right);
		return Math.max(lh, rh) +1;
	}
	
	public boolean isBalanced(){
		return isBalanced(root);
		
	}

	private boolean isBalanced(Node node) {
		if(node == null){
			return true;
		}
		
		boolean lb = isBalanced(node.left);
		boolean rb = isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);
		
		if( lb && rb && bf >= -1 && bf <=1){
			return true;
		}else{
			return false;
		}
	}
	
	public class BalPair{
		boolean isBal = true;
		int ht =-1;
		
	}
	public boolean isBalancedUsingBP(){
		return isBalancedUsingBP(root).isBal;
		
	}

	private BalPair isBalancedUsingBP(Node node) {
		
		if(node == null){
			return new BalPair();
		}
		
		BalPair lbp =isBalancedUsingBP(node.left);
		BalPair rbp =isBalancedUsingBP(node.right);
		
		BalPair sbp = new BalPair();
		
		boolean lb = lbp.isBal;
		boolean rb = rbp.isBal;

		int bf = lbp.ht - rbp.ht;
		
		if( lb && rb && bf >= -1 && bf <=1){
			sbp.isBal =true;
		}else{
			sbp.isBal= false;
		}
		sbp.ht = Math.max(lbp.ht, rbp.ht) +1;
		return sbp;
	}
	
	public boolean flipEquivalent(BinaryTree other){
		return flipEquivalent(root, other.root);
	}

	private boolean flipEquivalent(Node node1, Node node2) {
		
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null){
			return false;
		}
		
		if(node1.data != node2.data){
			return false;
		}
		boolean ll = flipEquivalent(node1.left,node2.left);
		boolean rr = flipEquivalent(node1.right,node2.right);
		
		if(ll && rr){
			return true;
		}
		boolean lr = flipEquivalent(node1.left,node2.right);
		boolean rl = flipEquivalent(node1.right,node2.left);
		
		return (ll && rr) ||(lr && rl);
		
	}
	
	private class Pair{
		Node node;
		boolean ld;
		boolean rd;
		boolean sd;
	}
	public void preorderI(){
		Stack<Pair> stack = new Stack<>();
		
		Pair sp = new Pair();
		sp.node = root;
		stack.push(sp);
		
		while(!stack.isEmpty()){
			Pair tp = stack.peek();
			
			if(tp.node ==null){
				stack.pop();
				continue;
			}
			if(tp.sd == false){
				System.out.println(tp.node.data);
				tp.sd = true;
			}else if(tp.ld ==false){
				Pair np = new Pair();
				np.node = tp.node.left;
				stack.push(np);
				tp.ld = true;
			}else if(tp.rd ==false){
				Pair np = new Pair();
				np.node = tp.node.right;
				stack.push(np);
				tp.rd = true;
			}else{
				stack.pop();
			}
			
		}
	}
	public int sum(){
		return sum(root);
	}

	private int sum(Node node) {
		if(node ==null){
			return 0;
		}
		
		int ls = sum(node.left);
		int rs = sum(node.right);
		return ls+ rs + node.data;
	}
	
	int maxSum = Integer.MIN_VALUE;
	
	public int maxSubtreeSum(){
		maxSubTreeSum(root);
		return maxSum;
	}

	private int maxSubTreeSum(Node node) {
		if (node == null){
			return 0;
		}
		int ls = maxSubTreeSum(node.left);
		int rs = maxSubTreeSum(node.right);
		
		int nodeans = ls + rs + node.data; 
		if( nodeans > maxSum){
			maxSum = nodeans;
		}
		return nodeans;
		
	}
	
	public int maxSubtreeSum2(){
		return maxSubTreeSum2(root);
	}

	private int maxSubTreeSum2(Node node) {
		if (node == null){
			return Integer.MIN_VALUE;
		}
		int lMaxSubtreeSum = maxSubTreeSum2(node.left);
		int rMaxSubtreeSum = maxSubTreeSum2(node.right);
		int selfSum = node.data +sum(node.left)+sum(node.right);
		
		return Math.max(selfSum, Math.max(lMaxSubtreeSum, rMaxSubtreeSum));
		
	}
	
	private class maxSubtreeSumPair{
		int entireSum =0;
		int maxSubtreeSum = Integer.MIN_VALUE;
	}
	
	public int maxSubtreeSum3(){
		return maxSubTreeSum3(root).maxSubtreeSum;
	}
	
	

	private maxSubtreeSumPair maxSubTreeSum3(Node node) {
		if (node == null){
			return new maxSubtreeSumPair();
		}
		maxSubtreeSumPair lp = maxSubTreeSum3(node.left);
		maxSubtreeSumPair rp = maxSubTreeSum3(node.right);
		maxSubtreeSumPair sp = new maxSubtreeSumPair();
		sp.entireSum = lp.entireSum + rp.entireSum + node.data;
		sp.maxSubtreeSum =Math.max(sp.entireSum, Math.max(lp.maxSubtreeSum, rp.maxSubtreeSum));
		
		return  sp;
		
	}
	
	public boolean Mirror(BinaryTree other1, BinaryTree other){
		return Mirror(other1.root, other.root);
	}
	
	public boolean Mirror(Node root1, Node root2)
	{
	  if(root1 == null && root2 == null) return true;
	  
	  if(root1 == null || root2 == null || (root1.data != root2.data)) return false;
	   
	  boolean l = Mirror(root1.left, root2.right);
	  boolean r = Mirror(root1.right, root2.left);
	  
	  return l && r;
	   
	}
	

}
