package com.codingBlock.recursion;

import java.util.ArrayList;

public class PrintReverse {

	// Tail recursion
	// Doing work while Building stack, print first and then add to stack
	// After Work Done all the Function pops up from stack immediately instead
	// of one by one
	public static void PrintDc(int n) {
		if (n == 0) {
			return;
		}

		System.out.println(n);
		PrintDc(n - 1);
	}

	// Head recursion
	// Doing work after building stack, print last
	// After Work Done all the Function pops up from stack one by one
	public static void PrintIc(int n) {
		if (n == 0) {
			return;
		}
		PrintIc(n - 1);
		System.out.println(n);
	}

	// Head and Tail recursion
	// Doing work while and after building stack, print first and last
	public static void PrintDIc(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		PrintDIc(n - 1);
		System.out.println(n);
	}

	public static void PDISkip(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 == 1)
			System.out.println(n);
		PDISkip(n - 1);
		if (n % 2 == 0)
			System.out.println(n);
	}

	public static int Fact(int n) {
		if (n == 1) {
			return 1;
		}
		int fact = n * Fact(n - 1);
		return fact;

	}

	public static int fibnth(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}
		int fib = fibnth(n - 1);
		int fibn = fibnth(n - 2);
		return fib + fibn;

	}

	public static int power(int n, int k) {
		if (k == 0) {
			return 1;
		}

		return n * power(n, k - 1);

	}

	public static boolean isSorted(int arr[], int len) {

		if (len == arr.length - 1) {
			return true;
		}

		if (arr[len] > arr[len + 1]) {
			return false;
		} else {
			boolean issort = isSorted(arr, len + 1);
			return issort;
		}

	}

	public static int firstIndex(int arr[], int si, int data) {

		if (si == arr.length) {
			return -1;
		}

		if (arr[si] == data) {
			return si;
		} else {
			int restAns = firstIndex(arr, si + 1, data);
			return restAns;
		}

	}

	public static int lastIndex(int arr[], int si, int data) {

		if (si == arr.length) {
			return -1;
		}
		int index = lastIndex(arr, si + 1, data);
		if (index == -1) {
			if (arr[si] == data) {
				return si;
			} else {
				return -1;
			}
		} else {
			return index;
		}
	}

	public static int[] allIndices(int arr[], int si, int data, int count) {

		if (si == arr.length) {
			int base[] = new int[count];
			return base;
		}
		int[] indices = null;
		if (arr[si] == data) {
			indices = allIndices(arr, si + 1, data, count + 1);
		} else {
			indices = allIndices(arr, si + 1, data, count);
		}
		if (arr[si] == data) {
			indices[count] = si;
		}

		return indices;
	}

	private static void bubblesort(int[] arr, int i, int length) {

		if (length == 0) {
			return;
		}
		if (i == length) {
			bubblesort(arr, 0, length - 1);
			return;
		}

		if (arr[i] > arr[i + 1]) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
		bubblesort(arr, i + 1, length);

	}

	/*
	 * SS => abc "", c "",b,c,bc ""a,b,c,ab,ac,bc,abc
	 */
	private static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<String>();
			base.add(" ");
			return base;
		}

		char cc = str.charAt(0);
		String substr = str.substring(1);
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> rec = getSS(substr);
		for (int i = 0; i < rec.size(); i++) {
			result.add(rec.get(i));
			result.add(cc + rec.get(i));
		}
		return result;

	}

	private static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<String>();
			base.add("");
			return base;
		}

		char cc = str.charAt(0);
		String substr = str.substring(1);
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> rec = getPermutation(substr);
		for (String rr : rec) {
			for (int i = 0; i <= rr.length(); i++) {
				String mystr = rr.substring(0, i) + cc + rr.substring(i);
				result.add(mystr);
			}

		}
		return result;

	}

	private static ArrayList<String> getBoradPath(int start, int reach) {

		if (start == reach) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if (start > reach) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoradPath(start + dice, reach);
			for (String rec : rr) {
				mr.add(dice + rec);
			}
		}
		return mr;

	}

	private static ArrayList<String> getMazePath(int sr, int sc, int er, int ec) {

		if (sr == er && sc == ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if (sr > er || sc > ec) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> hrr = getMazePath(sr, sc + 1, er, ec);
		for (String rrh : hrr) {
			mr.add("H" + rrh);
		}
		ArrayList<String> vrr = getMazePath(sr + 1, sc, er, ec);
		for (String rrv : vrr) {
			mr.add("V" + rrv);
		}
		return mr;
	}

	private static ArrayList<String> getMazePathDiag(int sr, int sc, int er, int ec) {

		if (sr == er && sc == ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if (sr > er || sc > ec) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> hrr = getMazePathDiag(sr, sc + 1, er, ec);
		for (String rrh : hrr) {
			mr.add("H" + rrh);
		}
		
		ArrayList<String> vrr = getMazePathDiag(sr + 1, sc, er, ec);
		for (String rrv : vrr) {
			mr.add("V" + rrv);
		}
		ArrayList<String> drr = getMazePathDiag(sr + 1, sc + 1, er, ec);
		for (String rrd : drr) {
			mr.add("D" + rrd);
		}
		return mr;
	}

	private static void printSS(String str, String result) {

		if (str.length() == 0) {
			System.out.print(result + " ");
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		printSS(ros, result);
		printSS(ros, result + cc);
	}
	
	private static void printPermutations(String str, String result) {

		if (str.length() == 0) {
			System.out.print(result + " ");
			return;
		}
		for(int i=0; i<str.length();i++){
			char cc = str.charAt(i);
			String ros = str.substring(0,i)+str.substring(i+1);
			printPermutations(ros, result+cc);
		}
		
	}
	private static void printBoradPath(int curr, int end, String ans) {

		if (curr==end) {
			System.out.print(ans + " ");
			return;
		}
		if (curr>end) {
			return;
		}
		
		for(int dice=1; dice<=6;dice++){
			printBoradPath(curr+dice,end,ans+dice);
		}
		
	}
	
	private static void printMazePath(int sr, int sc, int er, int ec, String ans) {

		if (sr==er && sc==ec) {
			System.out.print(ans + " ");
			return;
		}
		if (sr>er || sc>ec) {
			return;
		}
		printMazePath( sr+1,  sc,  er,  ec, ans+"H");
		printMazePath( sr,  sc+1,  er,  ec, ans+"V");
		
	}
	
	private static void printMazePathDiag(int sr, int sc, int er, int ec, String ans) {

		if (sr==er && sc==ec) {
			System.out.print(ans + " ");
			return;
		}
		if (sr>er || sc>ec) {
			return;
		}
		printMazePathDiag( sr+1,  sc,  er,  ec, ans+"H");
		printMazePathDiag( sr,   sc+1, er,  ec, ans+"V");
		printMazePathDiag( sr+1, sc+1, er,  ec, ans+"D");
		
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		PrintDc(5);
		System.out.println("-------------------------------------------");
		PrintIc(5);
		System.out.println("-------------------------------------------");
		PrintDIc(5);
		System.out.println("-------------------------------------------");
		PDISkip(5);
		System.out.println("-------------------------------------------");
		System.out.println(Fact(5));
		System.out.println("-------------------------------------------");
		System.out.println(fibnth(5));
		System.out.println("-------------------------------------------");
		System.out.println(power(2, 5));
		System.out.println("-------------------------------------------");
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(isSorted(arr, 0));
		System.out.println("-------------------------------------------");
		int arr1[] = { 5, 12, 2, 2, 2, 3, 2, 2, 3, 4, 5, 6 };
		System.out.println(firstIndex(arr1, 0, 3));
		System.out.println("-------------------------------------------");
		int arr2[] = { 5, 2, 2, 3 };
		System.out.println(lastIndex(arr2, 0, 2));
		System.out.println("-------------------------------------------");
		int arr3[] = { 5, 2, 2, 3 };
		display(allIndices(arr3, 0, 2, 0));
		System.out.println("\n-------------------------------------------");
		bubblesort(arr, 0, arr.length - 1);
		display(arr);
		System.out.println("\n-------------------------------------------");
		ArrayList<String> sebsequnece = getSS("abc");
		System.out.println(sebsequnece);
		System.out.println("\n-------------------------------------------");
		ArrayList<String> permutation = getPermutation("abc");
		System.out.println(permutation);
		System.out.println("\n-------------------------------------------");
		ArrayList<String> boradPath = getBoradPath(0, 10);
		System.out.println(boradPath);
		System.out.println(boradPath.size());
		System.out.println("\n-------------------------------------------");
		ArrayList<String> MazePath = getMazePath(0, 0, 2, 2);
		System.out.println(MazePath);
		System.out.println("\n-------------------------------------------");
		ArrayList<String> MazePathDiag = getMazePathDiag(0, 0, 2, 2);
		System.out.println(MazePathDiag);
		System.out.println("\n-------------------------------------------");
		printSS("abc", "");
		System.out.println("\n-------------------------------------------");
		printPermutations("abc","");
		System.out.println("\n-------------------------------------------");
		printBoradPath(0,10,"");
		System.out.println("\n-------------------------------------------");
		printMazePath(0, 0, 2, 2,"");
		System.out.println("\n-------------------------------------------");
		printMazePathDiag(0, 0, 2, 2,"");
	
	}

}
