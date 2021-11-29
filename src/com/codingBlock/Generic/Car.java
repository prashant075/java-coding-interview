package com.codingBlock.Generic;

public class Car {//implements Comparable<Car>{
		int speed;
		int price;
		String color;
		
		public Car(int speed, int price, String color) {
			this.speed = speed;
			this.price = price;
			this.color = color;
		}
			
		@Override
		public String toString() {
			return "Car [speed=" + speed + ", price=" + price + ", color=" + color + "]";
		}

//		@Override
//		public int compareTo(Car other) {
//			//return this.speed -other.speed;
//			//return other.price - this.price;
//			//lexographical sorting
//			return this.color.compareTo(other.color);
//		}
		
		
}
