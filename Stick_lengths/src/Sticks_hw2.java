/*
 * Sticks.java
 *
 * Version:
 *     $Id$:1.0
 *
 * Revisions:
 *     $Log$:3
 */

/**
 * This program searches and calculates if the unknown stick lengths can be made
 * from given known stick lengths with least possible combination.
 * 
 * @author Saket Upganlawar
 * @author Priyanshu Srivastava
 */

public class Sticks_hw2 {
	static int[] stickLengths ={ 1, 2, 3, 5,8 };
	static int[] unknowStickLengths =  { 1, 5, 6, 7, 8, 9 };
	static int[] all_posib=new int[(int)Math.pow(2,stickLengths.length)];			//To save all possible combinations of stickLengths array
	static String[] all_posib_sticks=new String[(int)Math.pow(2,stickLengths.length)];   //To save sticks used for all possible combinations of sticklengths array
	static int count=-1;					//to keep track of elements entering the all_posib and all_posib_sticks arrays
	public static void main(String[] args) {
		for(int i=0;i<stickLengths.length;i++){
			addtoarray(stickLengths[i]);
		}
		bubbleSort(all_posib,all_posib_sticks);
		for(int i=0;i<unknowStickLengths.length;i++){
			search(all_posib,all_posib_sticks,unknowStickLengths[i]);			
		}
	}
	/**
	 * Sorts the arrays in ascending order first with number and then with String length
	 *
	 * @param a[] int array abc[] String array
	 *
	 */
	private static void bubbleSort(int a[], String abc[]) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (a[j] > a[j + 1]) {
					// Logic for swapping positions
					a[j]=a[j]+a[j+1];
					a[j+1]=a[j]-a[j+1];
					a[j]-=a[j+1];
					String temp=abc[j];
					abc[j]=abc[j+1];
					abc[j+1]=temp;
				}
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (a[j] == a[j + 1] && abc[j].length()>abc[j+1].length()) {
					// Logic for swapping positions
					a[j]=a[j]+a[j+1];
					a[j+1]=a[j]-a[j+1];
					a[j]-=a[j+1];
					String temp=abc[j];
					abc[j]=abc[j+1];
					abc[j+1]=temp;
				}
	}
	/**
	 * Search for the unkown stick in all_posib array and if found
	 * print the combination else print no.
	 *
	 * @param a[] int array abc[] String array b is the stick to be searched
	 *
	 */
	private static void search(int a[],String abc[],int b) {
		Boolean check=false;
		for(int i=0;i<a.length;i++) {
			if(a[i]==b) {
				System.out.println(b + " inch:       yes; used sticks "+abc[i]);
				check=true;
				break;
			}
		}
		if(!check) {
			System.out.println(b + " inch:       No;");
		}
	}
	/**
	 * Calculates all the possible outcomes of sticklength array and store in all_posib array
	 *
	 * @param n int element of known sticklength array 
	 *
	 */	
	private static void addtoarray(int n)
	{
		int j=++count;
		all_posib[j]=n;
		all_posib_sticks[j]=""+n;
		int length=count;
		if(count!=0)
		{
		for(int i=0;i<=length-1;i++)
		{
			j=++count;
			all_posib[j]=all_posib[i]+n;
			all_posib_sticks[j]=all_posib_sticks[i]+"+"+n;
		}
		}
	}
}
