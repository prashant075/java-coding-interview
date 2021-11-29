package com.codingBlock.Generic;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car> {

	@Override
	public int compare(Car tcar, Car ocar) {
		return tcar.speed - ocar.speed;
	}

}
