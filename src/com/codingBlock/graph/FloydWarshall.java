package com.codingBlock.graph;

//v^2 * V => o(v^3) 
//Dynamic Programming
public class FloydWarshall {
	
	public static void main(String[] args){
		
		int v =4;
		int [][] graph ={{0,3,10000,7},{8,0,2,100000},{5,10000,0,1},{2,10000,10000,0}};
		
		int [] [] dist = new int[v][v];
		
		for(int i=0; i<dist.length;i++){
			for(int j=0; j <dist.length;j++){
				dist[i][j] =graph[i][j];
			}
		}
		
		for(int k=0; k < v;k++){
			for(int i =0; i < v ;i++){
				for(int j =0; j<v;j++){
					int oc = dist[i][j];
					int nc = dist[i][k] +dist[k][j];
					
					if(nc < oc){
						dist[i][j] = nc;
					}
				}
			}
		}
		
		for(int i=0; i<dist.length;i++){
			for(int j=0; j <dist.length;j++){
				System.out.print(dist[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
}
