package com.codingBlock.Generic;

public class Client {
		public static void main(String[] args){
			Pair<String> pair = new Pair<>();
			pair.one = "abc";
			pair.two ="bef";
			
			Pair<Integer> pair1 = new Pair<>();
			pair1.one  =10;
			pair1.two = 20;
			
			PairTwo<Integer, String> pair2 = new PairTwo<>();
			pair2.one = 10;
			pair2.two = "xyz";
			
			LinkedListGenric<Car> linkedlist = new LinkedListGenric<>();
			Car[] cars = new Car[5];
			
			cars[0] = new Car(6000,100,"Red");
			cars[1] = new Car(3200,200,"Pink");
			cars[2] = new Car(4000,300,"Blue");
			cars[3] = new Car(5000,400,"White");
			cars[4] = new Car(1000,500,"Green");
			
			linkedlist.addLast(cars[0]);
			linkedlist.addLast(cars[1]);
			linkedlist.addLast(cars[2]);
			linkedlist.addLast(cars[3]);
			linkedlist.addLast(cars[4]);
			
			linkedlist.display();
		}
}
