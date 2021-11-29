package com.codingBlock.Heap;

public class Car implements Comparable<Car>{
	int carid;
	
	int carno;
	String carColur;
	
	Car(int carid, int carno, String carColur){
		this.carid =carid;
		this.carno =carno;
		this.carColur = carColur;
	}
	
	@Override
	public String toString() {
		return "Car [carid=" + carid + ", carno=" + carno + ", carColur=" + carColur + "]";
	}

	@Override
	public int compareTo(Car other) {
		return this.carid -other.carid;
		//return this.carColur.compareTo(other.carColur);
	}

}
