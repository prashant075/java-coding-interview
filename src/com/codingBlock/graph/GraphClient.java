package com.codingBlock.graph;

import java.util.HashMap;

public class GraphClient {

	public static void main(String[] args) throws Exception {
		Graph gh = new Graph();
		gh.addVertex("A");
		gh.addVertex("B");
		gh.addVertex("C");
		gh.addVertex("D");
		gh.addVertex("E");
		gh.addVertex("F");
		gh.addVertex("G");
		
		gh.addEdges("A", "B", 3);
		gh.addEdges("A", "D", 2);
		gh.addEdges("B", "C", 4);
		gh.addEdges("C", "D", 7);
		gh.addEdges("D", "E", 10);
		gh.addEdges("E", "F", 9);
		gh.addEdges("E", "G", 8);
		gh.addEdges("F", "G", 6);
		
		gh.display();
		
		System.out.println("No of Vertex "+gh.numVertex());
		System.out.println("No of Edges "+gh.numEdges());
		
		System.out.println("Edges Contains "+gh.containsEdge("A", "C"));
		System.out.println("Edges Contains "+gh.containsEdge("A", "D"));
		gh.removeEdges("A", "B");
		gh.display();
		gh.removeVertex("G");
		gh.display();
		
		gh.addVertex("H");
		gh.display();
		
		gh.addEdges("A", "H", 20);
		gh.display();
		
		System.out.println("Has Path "+gh.hasPath("C", "F", new HashMap<String,Boolean>()));
		
		System.out.println("BFS have Path "+gh.BFS("C", "F"));
		//gh.removeEdges("E", "F");
		System.out.println("BFS have Path "+gh.BFS("C", "F"));
		gh.removeEdges("E", "F");
		
		
		System.out.println("DFS have Path "+gh.BFS("C", "F"));
		
		
		System.out.println("----------BFT----------");
		gh.BFT();
		
		System.out.println("----------DFT----------");
		gh.DFT();
		
		Graph gh1 = new Graph();
		gh1.addVertex("A");
		gh1.addVertex("B");
		gh1.addVertex("C");
		gh1.addEdges("A", "B", 3);
		gh1.addEdges("B", "C", 4);
		gh1.addEdges("C", "A", 4);
		System.out.println("Is Graph Cyclic "+ gh1.IsCyclic());
		gh1.addVertex("D");
		gh1.addVertex("E");
		gh1.addEdges("D", "E", 4);
		System.out.println("Is Graph Connected "+ gh1.IsConnected());
		gh1.addEdges("C", "D", 4);
		gh1.removeEdges("C", "A");
		System.out.println("Is Graph Tree "+ gh1.isTree());
		gh1.removeEdges("C", "D");
		System.out.println("Graph Connected Component "+ gh1.getCC());
		
		
		/*
		 *  A----6-- D----8---E\
		 *  |		 |		  | \
		 *  |		 |		  |	 \
		 *  2		 1		  5   7
		 *  |		 |		  |    \
		 *  |		 |		  |		\	
		 *  B---3--- C	      F--9---G 
		 *  
		 *  Prims Algo (heap, HashMap)
		 *  */
		
		Graph pgh = new Graph();
		pgh.addVertex("A");
		pgh.addVertex("B");
		pgh.addVertex("C");
		pgh.addVertex("D");
		pgh.addVertex("E");
		pgh.addVertex("F");
		pgh.addVertex("G");
		
		pgh.addEdges("A", "B", 2);
		pgh.addEdges("A", "D", 6);
		pgh.addEdges("B", "C", 3);
		pgh.addEdges("C", "D", 1);
		pgh.addEdges("D", "E", 8);
		pgh.addEdges("E", "F", 5);
		pgh.addEdges("E", "G", 7);
		pgh.addEdges("F", "G", 9);
		pgh.prims().display();
		System.out.println("-------------------");
		
		
		/*
		 *  A----10-- D----8---E\
		 *  |		 |		   | \
		 *  |		 |		   |  \
		 *  2		 1		   5   6
		 *  |		 |		   |    \
		 *  |		 |		   |	 \	
		 *  B---3--- C	       F--4---G 
		 *  
		 *  Dijkstra Algo (heap, HashMap)
		 *  */
		
		Graph dgh = new Graph();
		dgh.addVertex("A");
		dgh.addVertex("B");
		dgh.addVertex("C");
		dgh.addVertex("D");
		dgh.addVertex("E");
		dgh.addVertex("F");
		dgh.addVertex("G");
		
		dgh.addEdges("A", "B", 2);
		dgh.addEdges("A", "D", 10);
		dgh.addEdges("B", "C", 3);
		dgh.addEdges("C", "D", 1);
		dgh.addEdges("D", "E", 8);
		dgh.addEdges("E", "F", 5);
		dgh.addEdges("E", "G", 6);
		dgh.addEdges("F", "G", 4);
		System.out.println(dgh.dijkstra("A"));
		
		
		//kruskal Algo  
		System.out.println("----Kruskal---------");
		pgh.Kruskal();
		
		//BellmonFord
		Graph bel = new Graph();
		bel.addVertex("A");
		bel.addVertex("B");
		bel.addVertex("C");
		bel.addVertex("D");
		bel.addVertex("E");
		bel.addEdgesDirect("A", "B", 8);
		bel.addEdgesDirect("A", "C", 4);
		bel.addEdgesDirect("A", "D", 5);
		bel.addEdgesDirect("C", "D", -3);
		bel.addEdgesDirect("D", "E", 4);
		bel.addEdgesDirect("E", "B", 1);
		bel.addEdgesDirect("B", "E", 2);
		System.out.println(bel.bellmanFord("A"));
	
	}

}
