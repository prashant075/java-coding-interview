package com.codingBlock.Backtracking;

public class Coin {
	/*
	 * 4C2 => arrangement not matter here
	 */
	static int count = 0;

	public static void CoinCombinations(int[] demon, int amount, String ans, int lastuseddemonIdx) {

		if (amount == 0) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		for (int i = lastuseddemonIdx; i < demon.length; i++) {
			if (amount >= demon[i]) {
				CoinCombinations(demon, amount - demon[i], ans + demon[i], i);
			}

		}
	}

	public static void CoinPermutations(int[] demon, int amount, String ans) {

		if (amount == 0) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		if (amount < 0) {

			return;
		}

		for (int i = 0; i < demon.length; i++) {
			CoinPermutations(demon, amount - demon[i], ans + demon[i]);

		}
	}

	public static void CoinCombinationsRespectCoin(int[] demon, int amount, String ans, int vidx) {

		if (amount == 0) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		if (amount < 0 || demon.length == vidx) {
			return;
		}

		// Take
		CoinCombinationsRespectCoin(demon, amount - demon[vidx], ans + demon[vidx], vidx);
		// NotTake
		CoinCombinationsRespectCoin(demon, amount, ans, vidx + 1);

	}
	
	
	public static void main(String[] args) {
		CoinCombinations(new int[] { 2, 3, 5, 6 }, 10, "", 0);
		System.out.println("-------------------------------");
		count = 0;
		CoinPermutations(new int[] { 2, 3, 5, 6 }, 10, "");
		System.out.println("-------------------------------");
		count = 0;
		CoinCombinationsRespectCoin(new int[] { 2, 3, 5, 6 }, 10, "", 0);
	}

}
