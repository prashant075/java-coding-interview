package com.codingBlock.timeandSpace;

import java.util.Arrays;

public class SOEPrimes {
	// n*loglog(n) time 
	
	public static void SOE(int n) {

		boolean primes[] = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		for (int total = 2; total * total <= n; total++) {
			if (primes[total] == true) {
				for (int mult = 2; total * mult <= n; mult++) {
					primes[total * mult] = false;
				}
			}
		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i])
				System.out.println(i);
		}
	}

	public static void main(String[] args) {
		SOE(25);
	}

}
