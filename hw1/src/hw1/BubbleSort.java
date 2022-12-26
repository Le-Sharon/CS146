package hw1;
import java.io.*;
import java.io.IOException;

/**
 * This class uses bubble sort to sort data from test cases
 * 
 * @author Sharon Le
 * Source : https://www.javatpoint.com/bubble-sort-in-java
 */
public class BubbleSort {
	
	/**
	 * Bubble sort method which is used for all of the swapping
	 * @param arr
	 */
	public static void bubbleSort(int arr[])
	{
		System.out.println("System initializing bubble sorting  . . . \n");
		
		for (int i = 0; i <= arr.length; i++)
		{
			for (int n = 1; n < arr.length - i; n++)
				if (arr[n-1] > arr[n]) 
				{
					// start swapping array indexes
					int temp = arr[n-1];
					arr[n-1] = arr[n];
					arr[n] =  temp;
				}
		}
	}
	
	public static void main (String args[]) throws IOException
	{
		System.out.println("Reading text from attached file . . .\n");
		File textFile = new File("data/arr1-2");
		BufferedReader br = new BufferedReader(new FileReader(textFile));
		System.out.println("Reading Success!");
		
		String current = br.readLine();
		int count = 0;
		while (current != null)
		{
			current = br.readLine();
			count++;
		}
		
		br.close();
		BufferedReader br2 = new BufferedReader(new FileReader(textFile));
		System.out.println("Number of integers for individual arrays (length) : " + count);

		//initiallizing new array using count as length
		int[] arr = new int[count];
		int n = 0;
		//reading and putting into array
		current = br2.readLine();
		while (current != null)
		{
			arr[n++]= Integer.parseInt(current);
			current = br2.readLine();
		}
		//original array
		System.out.println("Unsorted array contents : ");
		for (int x = 0; x < arr.length; x++)
			System.out.print(arr[x] + ", ");
		System.out.println("\n");
		//call for sorting
		bubbleSort(arr);
		System.out.println("Sorted array contents : ");
		for (int x = 0; x < arr.length; x++)
			System.out.print(arr[x] + ", ");
		br2.close();
		System.out.println("\nDone!");
	}
	
}
