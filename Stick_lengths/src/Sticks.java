/*
 * Sticks.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program searches and calculates if the unknown stick lengths can be made
 * from given known stick lengths.
 * 
 * @author Saket Upganlawar
 * @author Priyanshu Srivastava
 */

public class Sticks {

	static int[] stickLengths = { 1, 5, 8, 12, 12, 35, 35, 35, 61 };
	static int[] unknowStickLengths = { 1, 6, 9, 24, 110, 111, 115, 62, 24, 202, 203, 204, 205 };
	static int[] temp = new int[stickLengths.length]; // hold the the indices of the stickLengths array which is used to form the unknown stick
	static int count = -1; 						      // holds the length of temp array
	static int prev = 0;							  // holds the previous unknown stick whose combination is found
	static int sum = 0; 							  // holds sum of all known sticks
 
	/**
	 * The main program.
	 *
	 * @param args command line arguments (ignored)
	 */
	public static void main(String[] arguments) {
		bubbleSort(unknowStickLengths);
		find_sum(stickLengths);
		for (int index = 0; index < unknowStickLengths.length; index++)
			doTestLength(index);
	}

	/**
	 * Sorts the array in ascending order
	 *
	 * @param a[] int array
	 *
	 */
	private static void bubbleSort(int a[]) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (a[j] > a[j + 1]) {
					// Logic for swapping positions
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
	}

	/**
	 * Finds the summ of all elements in an array
	 *
	 * @param a[] int array
	 *
	 */
	private static void find_sum(int a[]) {
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

	}

	/**
	 * Tests if the if the unknown stick can be made from the known sticks and if yes
	 * then prints the combination of which sticks are used
	 *
	 *
	 * @param x int   index of the unknown stick to be checked
	 *
	 */

	private static void doTestLength(int x) {

		Boolean flag = false;    			//If a combination is found the flag turns true exiting from the loop
		int n = unknowStickLengths[x]; 		//length of the unknown stick 
		if (n < sum) {
			/* 
			 * This will calculate the difference between current stick and the previous stick lengths from the unknownSticksLengths array.
			 * And will check if the difference exist as a length in sticksLengths array
			 */
			if (x > 0 && !flag) {
				int check = 1;
				int sub = n - unknowStickLengths[prev];
				if (sub != 0) {
					for (int p = 0; p < stickLengths.length; p++) {
						if (sub < stickLengths[p])
							break;
						check = 1;
						for (int q = 0; q <= count; q++) {
							if (temp[q] == p) {
								check = 0;
								break;
							}
						}
						if (check == 1 && sub == stickLengths[p]) {
							flag = true;
							prev = x;
							count++;
							temp[count] = p;
							break;
						}
					}
				} else
					flag = true;

			}

			//will check if unknown stick length is already present in the stickLengths array
			if (!flag) {
				int i = 0;
				for (i = 0; i < stickLengths.length; i++) {
					if (n == stickLengths[i]) {
						flag = true;
						prev = x;
						count++;
						temp[count] = i;
						break;
					} else if (n <= stickLengths[i]) {
						break;
					}
				}
			}

			//This will check unknown stick length from different combination of lengths from stickLengths array
			if (!flag) {
				int j = 0, k = 0, l = 0, m = 0, o = 0, p = 0, q = 0, r = 0;
				for (j = 0; j < stickLengths.length && !flag; j++) {
					for (k = j + 1; k < stickLengths.length && !flag; k++) {
						if (n == stickLengths[j] + stickLengths[k]) {
							count = 1;
							flag = true;
							prev = x;
							temp[0] = j;
							temp[1] = k;
							break;
						}
						for (l = k + 1; l < stickLengths.length && !flag; l++) {
							if (n == stickLengths[j] + stickLengths[k] + stickLengths[l]) {
								count = 2;
								flag = true;
								prev = x;
								temp[0] = j;
								temp[1] = k;
								temp[2] = l;
								break;
							}
							for (m = l + 1; m < stickLengths.length && !flag; m++) {
								if (n == stickLengths[j] + stickLengths[k] + stickLengths[l] + stickLengths[m]) {
									count = 3;
									flag = true;
									prev = x;
									temp[0] = j;
									temp[1] = k;
									temp[2] = l;
									temp[3] = m;
									break;
								}
								for (o = m + 1; o < stickLengths.length && !flag; o++) {
									if (n == stickLengths[j] + stickLengths[k] + stickLengths[l] + stickLengths[m]
											+ stickLengths[o]) {
										count = 4;
										flag = true;
										prev = x;
										temp[0] = j;
										temp[1] = k;
										temp[2] = l;
										temp[3] = m;
										temp[4] = o;
										break;
									}
									for (p = o + 1; p < stickLengths.length && !flag; p++) {
										if (n == stickLengths[j] + stickLengths[k] + stickLengths[l] + stickLengths[m]
												+ stickLengths[o] + stickLengths[p]) {
											count = 5;
											flag = true;
											prev = x;
											temp[0] = j;
											temp[1] = k;
											temp[2] = l;
											temp[3] = m;
											temp[4] = o;
											temp[5] = p;
											break;
										}

										for (q = p + 1; q < stickLengths.length && !flag; q++) {

											if (n == stickLengths[j] + stickLengths[k] + stickLengths[l]
													+ stickLengths[m] + stickLengths[o] + stickLengths[p]
													+ stickLengths[q]) {
												count = 6;
												flag = true;
												prev = x;
												temp[0] = j;
												temp[1] = k;
												temp[2] = l;
												temp[3] = m;
												temp[4] = o;
												temp[5] = p;
												temp[6] = q;
												break;
											}
											for (r = q + 1; r < stickLengths.length && !flag; r++) {
												if (n == stickLengths[j] + stickLengths[k] + stickLengths[l]
														+ stickLengths[m] + stickLengths[o] + stickLengths[p]
														+ stickLengths[q] + stickLengths[r]) {
													count = 7;
													flag = true;
													prev = x;
													temp[0] = j;
													temp[1] = k;
													temp[2] = l;
													temp[3] = m;
													temp[4] = o;
													temp[5] = p;
													temp[6] = q;
													temp[7] = r;
													break;
												}
											}
										}

									}
								}
							}
						}

					}
				}

			}
		} else if (n == sum) {
			count = 8;
			flag = true;
			prev = x;
			temp[0] = 0;
			temp[1] = 1;
			temp[2] = 2;
			temp[3] = 3;
			temp[4] = 4;
			temp[5] = 5;
			temp[6] = 6;
			temp[7] = 7;
			temp[8] = 8;
			if (flag && count == 8)
				System.out.println(n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " and "
						+ stickLengths[temp[1]] + " and " + stickLengths[temp[2]] + " and " + stickLengths[temp[3]]
						+ " and " + stickLengths[temp[4]] + " and " + stickLengths[temp[5]] + " and "
						+ stickLengths[temp[6]] + " and " + stickLengths[temp[7]] + " and " + stickLengths[temp[8]]
						+ " inch");
		}

		if (!flag)
			System.out.println(n + " inch:       No;");

		if (flag && count < 1)
			System.out.println(n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " inch");

		if (flag && count == 1)
			System.out.println(n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " and "
					+ stickLengths[temp[1]] + " inch");

		if (flag && count == 2)
			System.out.println(n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " and "
					+ stickLengths[temp[1]] + " and " + stickLengths[temp[2]] + " inch");

		if (flag && count == 3)
			System.out.println(
					n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " and " + stickLengths[temp[1]]
							+ " and " + stickLengths[temp[2]] + " and " + stickLengths[temp[3]] + " inch");

		if (flag && count == 4)
			System.out.println(n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " and "
					+ stickLengths[temp[1]] + " and " + stickLengths[temp[2]] + " and " + stickLengths[temp[3]]
					+ " and " + stickLengths[temp[4]] + " inch");

		if (flag && count == 5)
			System.out.println(n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " and "
					+ stickLengths[temp[1]] + " and " + stickLengths[temp[2]] + " and " + stickLengths[temp[3]]
					+ " and " + stickLengths[temp[4]] + " and " + stickLengths[temp[5]] + " inch");

		if (flag && count == 6)
			System.out.println(n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " and "
					+ stickLengths[temp[1]] + " and " + stickLengths[temp[2]] + " and " + stickLengths[temp[3]]
					+ " and " + stickLengths[temp[4]] + " and " + stickLengths[temp[5]] + " and "
					+ stickLengths[temp[6]] + " inch");

		if (flag && count == 7)
			System.out.println(n + " inch:       yes; used sticks " + stickLengths[temp[0]] + " and "
					+ stickLengths[temp[1]] + " and " + stickLengths[temp[2]] + " and " + stickLengths[temp[3]]
					+ " and " + stickLengths[temp[4]] + " and " + stickLengths[temp[5]] + " and "
					+ stickLengths[temp[6]] + " and " + stickLengths[temp[7]] + " inch");

	}

}
