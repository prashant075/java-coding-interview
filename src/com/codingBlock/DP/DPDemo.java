package com.codingBlock.DP;

public class DPDemo {
	
	public static long start;
	public static long end;
	public static void StartAlgo(){
		start = System.currentTimeMillis();
	}
	public static long endAlgo(){
		end = System.currentTimeMillis();
		return end-start;
	}
	public static void main(String[] args){
		int n =45;
		int[] strg = new int[n+1];
		StartAlgo();
		System.out.println(fib(45));
		System.out.println("Normal " + endAlgo() + " Ms");
		
		StartAlgo();
		System.out.println(fibRS(45, strg));
		System.out.println("DP "+ endAlgo() + " Ms");
		
		StartAlgo();
		System.out.println(fibIS(45));
		System.out.println("IS " + endAlgo() + " Ms");
		
		int n1 =30;
		int[] strg1 = new int[n+1];
		StartAlgo();
		System.out.println(cbp(n1,0));
		System.out.println("CBP Normal time " + endAlgo() + " Ms");
		
		StartAlgo();
		System.out.println(cbpRS(n1,0,strg1));
		System.out.println("CBP DP time " + endAlgo() + " Ms");
		
		StartAlgo();
		System.out.println(cbpIS(n1,0));
		System.out.println("CBP DP time IS storage " + endAlgo() + " Ms");
		
		String  s1= "agbdsfdsfsdfdsdsfddsfsdfg", s2= "acgsdfdsfdsffdfsdb";
		StartAlgo();
		System.out.println(editDistance(s1,s2));
		System.out.println("ed Iterative time  " + endAlgo() + " Ms");
		
		StartAlgo();
		System.out.println(editDistanceN(s1,s2));
		System.out.println("ed Normal time  " + endAlgo() + " Ms");
		
		StartAlgo();
		System.out.println(lcsI(s1,s2));
		System.out.println("LCS Iterative time  " + endAlgo() + " Ms");
		
		StartAlgo();
		System.out.println(lcs(s1,s2));
		System.out.println("LCS Recursive time  " + endAlgo() + " Ms");
	}
	
	private static int fib(int n) {
		if(n ==0){
			return 0;
		}
		if(n ==1){
			return 1;
		}
		int fm1 = fib(n-1);
		int fm2 = fib(n-2);
		int fn= fm1 + fm2;
		return fn;
	}

	private static int fibRS(int n, int[] strg) {
		if(n ==0){
			return 0;
		}
		if(n ==1){
			return 1;
		}
		if(strg[n] !=0){
			return strg[n];
		}
		int fm1 = fibRS(n-1, strg);
		int fm2 = fibRS(n-2, strg);
		int fn= fm1 + fm2;
		strg[n] =fn;
		return fn;
	}
	
	public static int fibIS(int n){
		int[] strg = new int[n+1];
		//seed
		strg[0] =0;
		strg[1] =1;
		
		for(int i=2;i<=n;i++){
			strg[i] = strg[i-1] +strg[i-2];
		}
		return strg[n];
	}
	public static int cbp(int end, int curr){
		
		if(end ==curr){
			return 1;
		}
		if(curr > end){
			return 0;
		}
		int count =0;
		for(int dice =1; dice<=6;dice++){
			count= count + cbp(end, curr+dice);
		}
		return count;
	}
	
		public static int cbpRS(int end, int curr, int[] strg){
		
		if(end ==curr){
			return 1;
		}
		if(curr > end){
			return 0;
		}
		if(strg[curr] !=0){
			return strg[curr];
		}
		int count =0;
		for(int dice =1; dice<=6;dice++){
			count= count + cbpRS(end, curr+dice, strg);
		}
		strg[curr] = count;
		return count;
	}
		
	public static int cbpIS(int end, int curr){
			int [] strg = new int[end+1];
			strg[end] =1;
			for(int i =end-1 ;i >=0;i--){
				int count =0;
				for(int dice =1; dice<=6 && dice + i < strg.length;dice++){
					count = count +strg[dice + i];
				}
				strg[i] = count;
			}
			return strg[curr];
	}
	
	public static int editDistance(String s1, String s2){
		int[][] strg = new int[s1.length() +1][s2.length()+2];
		strg[s1.length()][s2.length()] =0;
		
		for(int i =s1.length();i>=0;i--){
			for(int j=s2.length();j>=0;j--){
				if(i==s1.length()){
					strg[i][j]=s2.length() -j;
					continue;
				}
				if(j==s2.length()){
					strg[i][j] = s1.length() -i;
					continue;
				}
				
				if(s1.charAt(i) == s2.charAt(j)){
					strg[i][j] = strg[i+1][j+1];
				}else{
					strg[i][j] = 1 + Math.min(strg[i+1][j+1], Math.min(strg[i+1][j], strg[i][j+1]));
				}
			}
		}
		
		return strg[0][0];
	}
	
	public static int editDistanceN(String s1, String s2){
		if(s1.length() ==0){
			return s2.length();
		}
		if(s2.length() ==0){
			return s1.length();
		}
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans =0;
		if(s1.charAt(0) == s2.charAt(0)){
			ans = editDistanceN(ros1, ros2);
		}else{
			int f1 = 1 + editDistanceN(ros1, ros2);
			int f2 = 1+ editDistanceN(ros1, s2);
			int f3 = 1+ editDistanceN(s1, ros2);
			ans = Math.min(f1, Math.min(f2, f3));
		}
		return ans;
	}
	
	public static int lcsI(String s1, String s2){
		int[][] strg = new int[s1.length()+1][s2.length()+1];
		strg[s1.length()][s2.length()] =0;
		
		for(int i = s1.length();i>=0;i--){
			for(int j = s2.length();j>=0;j--){
				if(i ==s1.length() || j ==s2.length()){
					strg[i][j] =0;
					continue;
				}
				if(s1.charAt(i) == s2.charAt(j)){
					strg[i][j] = 1+ strg[i+1][j+1];
				}else{
					strg[i][j] = Math.max(strg[i+1][j], strg[i][j+1]);
				}
			}
		}
		return strg[0][0];
	}
	
	public static int lcs(String str1, String str2){
		int count =0;
		if(str1.length() ==0 || str2.length() ==0){
			return 0;
		}
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		
		if(str1.charAt(0) == str2.charAt(0)){
			count = 1+ lcs(ros1, ros2);
		}else{
			int f1 = lcs(ros1, str2);
			int f2 = lcs(str1, ros2);
			count = Math.max(f1, f2);
		}
		return count;
	}
}
