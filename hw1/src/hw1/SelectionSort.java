package hw1;

import java.io.*;
import java.io.IOException;

/**
 *  This class uses selection sort to sort test cases of integers in order
 * @author Sharon Le
 * Source: https://www.javatpoint.com/selection-sort
 */
public class SelectionSort {
	
	/**
	 * 
	 * This method uses selection sort method to sort elements in array
	 * @param arr array needed to be sorted
	 */
	public static void selectionSort(int arr[])
	{
		
		System.out.println("System initializing selection sorting  . . . \n");
		
		for (int x = 0; x < arr.length - 1; x++)
		{
			int smallest = x;
			for (int y = x + 1; y < arr.length; y++)
			{
				//for each element in array
				if (arr[smallest] > arr[y])
					smallest = y;
			}
			// swapping current index with the smallest element
			int temp = arr[smallest];
			arr[smallest] = arr[x];
			arr[x] = temp;
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
		selectionSort(arr);
		System.out.println("Sorted array contents : ");
		for (int x = 0; x < arr.length; x++)
			System.out.print(arr[x] + ", ");
		br2.close();
		System.out.println("\nDone!");
	}
	
}
