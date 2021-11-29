package com.codingBlock.Heap;

public class GenericClient {
	
	public static void main(String[] args){
		
		Car[] cars = new Car[5];
		cars[0] = new Car(1000,400,"Red");
		cars[1] = new Car(2000,400,"Yellow");
		cars[2] = new Car(3000,400,"Pink");
		cars[3] = new Car(500,400,"Sky");
		cars[4] = new Car(1500,400,"Blue");
		
		HeapGeneric<Car> heapg = new HeapGeneric<>();
		heapg.add(cars[0]);
		heapg.add(cars[1]);
		heapg.add(cars[2]);
		heapg.add(cars[3]);
		heapg.add(cars[4]);
		System.out.println(heapg.remove());
		
	}

}
