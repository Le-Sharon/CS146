package hw2;
/**
 * This class sorts the array using quicksort method
 * @author Sharon Le
 * Source: https://www.youtube.com/watch?v=7h1s2SojIRw
 */

import java.io.*;
import java.io.IOException;
public class QuickSort {
	/**
	 * This method uses the quicksort way to sort the array, using high and low pointer 
	 * to separate into sub arrays
	 * 
	 * @param arr, array inputted
	 * @param low, pointer for the left
	 * @param high, pointer for the right
	 */
	public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;
        if (low >= high)
            return;
        
        // locate pivot
        int mid = low + (high - low) / 2;
        int p = arr[mid];
        
        // left side [low] < p & right side [high] > p
        int x = low, y = high;
        while (x <= y) {
            while (arr[x] < p) {
                x++;
            }
            while (arr[y] > p) {
                y--;
            }
            if (x <= y) {
                int temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
                x++;
                y--;
            }
        }
        // recursively sort through array
        if (low < y)
            quickSort(arr, low, y);
        if (high > x)
            quickSort(arr, x, high);
    }
	
	public static void main (String args[]) throws IOException
	{
		System.out.println("Reading text from attached file . . .\n");
		File textFile = new File("data/MyList-2.txt");
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
		quickSort(arr, 0, arr.length-1);
		System.out.println("Sorted array contents : ");
		for (int x = 0; x < arr.length; x++)
			System.out.print(arr[x] + ", ");
		br2.close();
		System.out.println("\nDone!");
	}
}
