package com.codingBlock.Generic;

import java.util.Comparator;

public class Demo {
	public static void main(String[] args){
	Car[] cars = new Car[5];
	
	cars[0] = new Car(6000,100,"Red");
	cars[1] = new Car(3200,200,"Pink");
	cars[2] = new Car(4000,300,"Blue");
	cars[3] = new Car(5000,400,"White");
	cars[4] = new Car(1000,500,"Green");
	display(cars);
	System.out.println("----------------------------------");
	bubblerSort(cars, new CarSpeedComparator());
	System.out.println("----------------------------------");
	bubblerSort(cars, new CarPriceComparator());
	}
	
	public static <T> void display(T[] arr){
		for(T val : arr){
			System.out.println(val + " ");
		}
	}
	
	/*public static <T extends Comparable<T>> void bubblerSort(T[] array){
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j].compareTo( array[j+1]) > 0){
				T temp = array[j+1];
				array[j+1] = array[j];
				array[j]=temp;
			}
				}
		}
		
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}*/
	
public static <T > void bubblerSort(T[] array, Comparator<T> comparator){
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(comparator.compare(array[j], array[j+1])  > 0){
				T temp = array[j+1];
				array[j+1] = array[j];
				array[j]=temp;
			}
				}
		}
		
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}
}
