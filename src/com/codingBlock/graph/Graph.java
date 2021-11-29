package com.codingBlock.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import com.codingBlock.Heap.HeapGeneric;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbur = new HashMap<>();
	}

	HashMap<String, Vertex> vrtcs;

	public Graph() {
		vrtcs = new HashMap<>();
	}

	public int numVertex() {
		return this.vrtcs.size();

	}

	public boolean containsVertex(String vname) {
		return this.vrtcs.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vt = new Vertex();
		vrtcs.put(vname, vt);
	}

	public void removeVertex(String vname) {
		Vertex vts = vrtcs.get(vname);
		ArrayList<String> keys = new ArrayList<>(vts.nbur.keySet());

		for (String key : keys) {
			Vertex nbvtsc = vrtcs.get(key);
			nbvtsc.nbur.remove(vname);
		}

		vrtcs.remove(vname);
	}

	public int numEdges() {
		int count = 0;
		ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
		for (String key : keys) {
			Vertex vt = vrtcs.get(key);
			count += vt.nbur.size();
		}

		return count / 2;

	}

	public boolean containsEdge(String vname1, String vname2) {
		Vertex vtr1 = vrtcs.get(vname1);
		Vertex vtr2 = vrtcs.get(vname2);
		if (vtr1 == null || vtr2 == null || !vtr1.nbur.containsKey(vname2)) {
			return false;
		}
		return true;

	}

	public void addEdges(String vname1, String vname2, int cost) {
		Vertex vtr1 = vrtcs.get(vname1);
		Vertex vtr2 = vrtcs.get(vname2);
		if (vtr1 == null || vtr2 == null || vtr1.nbur.containsKey(vname1)) {
			return;
		}
		vtr1.nbur.put(vname2, cost);
		vtr2.nbur.put(vname1, cost);
	}
	
	public void addEdgesDirect(String vname1, String vname2, int cost) {
		Vertex vtr1 = vrtcs.get(vname1);
		Vertex vtr2 = vrtcs.get(vname2);
		if (vtr1 == null || vtr2 == null || vtr1.nbur.containsKey(vname1)) {
			return;
		}
		vtr1.nbur.put(vname2, cost);
		
	}

	public void removeEdges(String vname1, String vname2) {
		Vertex vtr1 = vrtcs.get(vname1);
		Vertex vtr2 = vrtcs.get(vname2);
		if (vtr1 == null || vtr2 == null || !vtr1.nbur.containsKey(vname2)) {
			return;
		}
		vtr1.nbur.remove(vname2);
		vtr2.nbur.remove(vname1);
	}

	public void display() {
		ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());

		System.out.println("__________________________");
		for (String key : keys) {
			Vertex vtx = vrtcs.get(key);
			System.out.println(key + " => " + vtx.nbur);

		}
		System.out.println("__________________________");
	}

	public boolean hasPath(String vname1, String vname2, HashMap<String,Boolean> processed) {
		
		processed.put(vname1, true);
		if (containsEdge(vname1, vname2)) {
			return true;
		}
		Vertex vtx = vrtcs.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbur.keySet());
		for (String nbr : nbrs) {
			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed)) {
				return true;
			}
		}
		return false;
	}

	private class Pair{
		String vname;
		String psf;
	}
	
	// O(V +E)
	public boolean BFS(String src, String dst){
		
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair sp  = new Pair();
		
		//Create a New Pair
		sp.vname = src;
		sp.psf = src;
		
		//Put the new Pair in Queue
		queue.addLast(sp);
		
		while(!queue.isEmpty()){
			Pair rp = queue.removeFirst();
			
			if(processed.containsKey(rp.vname)){
				continue;
			}
			
			processed.put(rp.vname, true);
			
			if(containsEdge(rp.vname,dst)){
				System.out.println(rp.psf +dst);
				return  true;
			}
			
			Vertex rpvtx = vrtcs.get(rp.vname);
			
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbur.keySet());
			
			//nbr loop
			for(String nbr: nbrs)
			{
				//Process only unprocessed
				if(!processed.containsKey(nbr)){
					//Make a new Pair of nbr and put in queue
					Pair np = new Pair();
					np.vname =nbr;
					np.psf= rp.psf+nbr;
					
					queue.addFirst(np);
				}
			}
			
		}
		return false;
	}
	
	// O(V +E)
	public boolean DFS(String src, String dst){
		
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp  = new Pair();
		
		//Create a New Pair
		sp.vname = src;
		sp.psf = src;
		
		//Put the new Pair in Queue
		stack.addFirst(sp);
		
		while(!stack.isEmpty()){
			Pair rp = stack.removeFirst();
			
			if(processed.containsKey(rp.vname)){
				continue;
			}
			
			processed.put(rp.vname, true);
			
			if(containsEdge(rp.vname,dst)){
				System.out.println(rp.psf +dst);
				return  true;
			}
			
			Vertex rpvtx = vrtcs.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbur.keySet());
			
			//nbr loop
			for(String nbr: nbrs)
			{
				//Process only unprocessed
				if(!processed.containsKey(nbr)){
					//Make a new Pair of nbr and put in queue
					Pair np = new Pair();
					np.vname =nbr;
					np.psf= rp.psf+nbr;
					
					stack.addFirst(np);
				}
			}
			
		}
		return false;
	}
	// o(V +E)
	public void BFT() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		
		ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());

		for (String key : keys) {
			// Create a New Pair
			if (processed.containsKey(key)) {
				continue;
			}
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			

			// Put the new Pair in Queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				Vertex rpvtx = vrtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbur.keySet());

				// nbr loop
				for (String nbr : nbrs) {
					// Process only unprocessed
					if (!processed.containsKey(nbr)) {
						// Make a new Pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
		}
	}
	
	// o(V +E)
	public void DFT() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp = new Pair();
		ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());

		for (String key : keys) {
			// Create a New Pair
			sp.vname = key;
			sp.psf = key;
			if (processed.containsKey(key)) {
				continue;
			}
			
			// Put the new Pair in Queue
			stack.addFirst(sp);

			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				Vertex rpvtx = vrtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbur.keySet());

				// nbr loop
				for (String nbr : nbrs) {
					// Process only unprocessed
					if (!processed.containsKey(nbr)) {
						// Make a new Pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}
		}
	}
	
	// o(V +E)
	public boolean IsCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair sp = new Pair();
		ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());

		for (String key : keys) {
			// Create a New Pair
			sp.vname = key;
			sp.psf = key;
			if (processed.containsKey(key)) {
				continue;
			}

			// Put the new Pair in Queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					return true;
				}

				processed.put(rp.vname, true);

				Vertex rpvtx = vrtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbur.keySet());

				// nbr loop
				for (String nbr : nbrs) {
					// Process only unprocessed
					if (!processed.containsKey(nbr)) {
						// Make a new Pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}

			}
		}
		return false;
	}
	
	// o(V +E)
	public boolean IsConnected() {
		int flag =0;
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		
		ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());

		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			flag++;
			// Create a New Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			
			// Put the new Pair in Queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				Vertex rpvtx = vrtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbur.keySet());

				// nbr loop
				for (String nbr : nbrs) {
					// Process only unprocessed
					if (!processed.containsKey(nbr)) {
						// Make a new Pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
		}
		if(flag >=2){
			return false;
		}else{
		return true;
		}
	}
	
	// o(V +E)
	public boolean isTree(){
		return !this.IsCyclic() && this.IsConnected();
	}
	
	// o(V +E)
	public ArrayList<ArrayList<String>> getCC() {
		ArrayList<ArrayList<String>> finalans = new ArrayList<ArrayList<String>>();
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		
		ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());

		for (String key : keys) {
			// Create a New Pair
			if (processed.containsKey(key)) {
				continue;
			}
			ArrayList<String> subans = new ArrayList<>();
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			

			// Put the new Pair in Queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				subans.add(rp.vname);

				Vertex rpvtx = vrtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbur.keySet());

				// nbr loop
				for (String nbr : nbrs) {
					// Process only unprocessed
					if (!processed.containsKey(nbr)) {
						// Make a new Pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
			finalans.add(subans);
		}
		return finalans;
	}
	
	
	private class PrimsPair implements Comparable<PrimsPair>{
		String vname;
		String acqvname;
		int cost;
		
		
		@Override
		public int compareTo(PrimsPair o) {
			
			return o.cost -this.cost;
		}
	}
	
	//vlogv + vlogv + Elogv => o(ElogV)
	public Graph prims(){
		Graph mst = new Graph();
		HashMap<String, PrimsPair> map = new HashMap<>();
		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();
		
		for(String key : vrtcs.keySet()){
			PrimsPair np = new PrimsPair();
			np.vname =key;
			np.acqvname = null;
			np.cost = Integer.MAX_VALUE;
			
			heap.add(np);
			map.put(key, np);
		}
		
		//till the heap is not empty keep on removing the pairs
		
		while(!heap.isEmpty()){
			
			//remove  a Pair
			
			PrimsPair rp = heap.remove();
			map.remove(rp.vname);
			
			if(rp.acqvname == null ){
				mst.addVertex(rp.vname);
			}else{
				mst.addVertex(rp.vname);
				mst.addEdges(rp.vname, rp.acqvname, rp.cost);
			}
			
			//nbrs
			for(String nbr : vrtcs.get(rp.vname).nbur.keySet()){
				
				//work for nbrs which are in heap
				if(map.containsKey(nbr)){
					
					//get  the old and new cost
					int oc = map.get(nbr).cost;
					int nc = vrtcs.get(rp.vname).nbur.get(nbr);
					
					//update the cost of pair
					if(nc < oc){
						PrimsPair gp = map.get(nbr);
						gp.acqvname = rp.vname;
						gp.cost = nc;
						
						heap.updatePriority(gp);
					}
				}
			}
		}
		return mst;
	}
	
	private class DijkstraPair implements Comparable<DijkstraPair>{
		String vname;
		String psf;
		int cost;
		
		
		@Override
		public int compareTo(DijkstraPair o) {
			
			return o.cost -this.cost;
		}
	}
	
	//Single source shortest path algo
	//o(ElogV) Not work if edges weight are negative
	//work for directed and undirected
	public HashMap<String, Integer> dijkstra(String src){
		
		HashMap<String, Integer > ans = new HashMap<>();
		HashMap<String, DijkstraPair> map = new HashMap<>();
		
		HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();
		
		for(String key : vrtcs.keySet()){
			DijkstraPair np = new DijkstraPair();
			np.vname =key;
			np.psf ="";
			np.cost = Integer.MAX_VALUE;
			
			if(key.equals(src)){
				np.cost = 0;
				np.psf = key;
			}
			heap.add(np);
			map.put(key, np);
		}
		
		//till the heap is not empty keep on removing the pairs
		
		while(!heap.isEmpty()){
			
			//remove  a Pair
			
			DijkstraPair rp = heap.remove();
			map.remove(rp.vname);
			ans.put(rp.vname, rp.cost);
			
			
			//nbrs
			for(String nbr : vrtcs.get(rp.vname).nbur.keySet()){
				
				//work for nbrs which are in heap
				if(map.containsKey(nbr)){
					
					//get  the old and new cost
					int oc = map.get(nbr).cost;
					int nc = rp.cost + vrtcs.get(rp.vname).nbur.get(nbr);
					
					//update the cost of pair
					if(nc < oc){
						DijkstraPair gp = map.get(nbr);
						gp.psf = rp.psf + nbr;
						gp.cost = nc;
						
						heap.updatePriority(gp);
					}
				}
			}
		}
		return ans;
	}
	
	public class DisjoinSet{
		
		HashMap<String, Node> map = new HashMap<>();
		private class Node{
			String data;
			Node parent;
			int rank;   //height
		}
		
		//o(1)
		public void create(String value){
			
			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;
			
			map.put(value, nn);
		}
		//o(1)
		public void union(String value1, String value2){
			
			Node n1 = map.get(value1);
			Node n2 = map.get(value2);
			
			Node re1 = find(n1);
			Node re2 = find(n2);
			
			if(re1.data.equals(re2.data)){
				return;
			}else{
				if(re1.rank == re2.rank){
					re2.parent = re1;
					re1.rank = re1.rank +1;
				}else if(re1.rank > re2.rank){
					re2.parent = re1;
				}else{
					re1.parent = re2;
				}
			}
		}
		
		public String find(String value){
			return find(map.get(value)).data;
		}
		
		//o(1)
		private Node find(Node node){
			
			if(node == node.parent){
				return node;
			}
			Node rr  =find(node.parent);
			node.parent =rr; //path compression using this o(1) otherwise log2n
			return rr;
		}
	}
	
	private class EdgePair implements Comparable<EdgePair>{
		
		String v1;
		String v2;
		int cost;
		
		@Override
		public int compareTo(EdgePair o) {
			return this.cost - o.cost;
		}
		
		@Override
		public String toString() {
			return v1 + "-" + v2 + " : " + cost;
		}
	}
	
	
	public ArrayList<EdgePair> getAllEdges(){
		ArrayList<EdgePair> edges = new ArrayList<>();
		
		for(String vname : vrtcs.keySet()){
			Vertex vtx = vrtcs.get(vname);
			
			for(String nbr :  vtx.nbur.keySet()){
				
				EdgePair ep = new EdgePair();
				ep.v1 =vname;
				ep.v2 = nbr;
				ep.cost = vtx.nbur.get(nbr);
				edges.add(ep);
			}
			
		}
		return edges;
		
	}
	
	//ElogE + V +E => ElogV2 =>O(ElogV)
	public void Kruskal(){
		ArrayList<EdgePair> edges = getAllEdges();
		
		//sort the edegs in increasing order of weight
		Collections.sort(edges);
		
		DisjoinSet set = new DisjoinSet();
		
		//Create vertices no.of sets
		for(String vname : vrtcs.keySet()){
			set.create(vname);
		}
		
		//traverse over the edges
		for(EdgePair edge :edges){
			String re1 = set.find(edge.v1);
			String re2 = set.find(edge.v2);
			
			//re same : ignore
			if(re1.equals(re2)){
				continue;
			}else{
				// not same union
				System.out.println(edge);
				set.union(edge.v1, edge.v2);
			}
		} 
	}
	
	//if -ve weight cycle present BellmenFord will not work
	//Work on -ve weight edges but not on -ve cycle
	//work on Directed graph, not on undirected graph if have -ve edges
	//work on undirected graph when all edges have +ve weight
	//Relax V-1 times A--2--->B---3--->C----1---->D
	// o(E*V)
	public HashMap<String, Integer> bellmanFord(String src) throws Exception{
		ArrayList<EdgePair> edges = getAllEdges();
		HashMap<String, Integer> map = new HashMap<>();
		
		//fill hashmap with infinity and zero
		for(String vname : vrtcs.keySet()){
			map.put(vname, 100000);
			
			if(src.equals(vname)){
				map.put(vname, 0);
			}
		}
		int v = vrtcs.size();
		
		//Relax every edges v-1 times
		for(int i =1; i <=v;i++){
			
			for(EdgePair edge : edges){
				
				int oc = map.get(edge.v2);
				int nc = map.get(edge.v1) + edge.cost;
				
				if(oc > nc){
					if( i <= v-1){
					map.put(edge.v2, nc);
					}else{
						throw new Exception("-ve wt cycle Present");
					}
				}
			}
		}
		return map;
	}
	
	

}
