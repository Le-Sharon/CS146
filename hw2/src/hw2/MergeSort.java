package hw2;
/**
 * This class uses the method mergesort to sort the array from low to high elements
 * @author Sharon Le
 * Source : https://www.youtube.com/watch?v=mB5HXBb_HY8&t=415s
 */

import java.io.*;
import java.io.IOException;
public class MergeSort {
	
	/**
	 * This method uses recursion to use the method merge sort to sort the array
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void mergeSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return; // stopper
        if (low >= high)
            return; // stopper
        // find the middle/divider of both sides
        int mid = low + (high - low) / 2;
        // sort right using recursion
        mergeSort(arr, mid + 1, high);
        // sort left using recursion
        mergeSort(arr, low, mid);
        //combine two sides
        merge(arr, low, mid, high);

    }

    /**
     * Method to merge two sub arrays into a full array & sorting it
     * 
     * @param arr, array to sort
     * @param low, beginning pointer/index of left side
     * @param middle, middle index
     * @param high, tail pointer/index of right side
     */
    public static void merge(int[] arr, int low, int middle, int high) {
    	//pointer variables
        int x = low, y = middle + 1, k = 0;
        int[] temp = new int[high - low + 1];
        // loops through both sub array & find smallest from both sides to add in
        while (x <= middle && y <= high) {
            if (arr[x] <= arr[y]) {
                temp[k] = arr[x];
                x++;
            } 
            else {
                temp[k] = arr[y];
                y++;
            }
            k++;
        }
        // add remaining elements left in low side
        while (x <= middle) {
            temp[k] = arr[x];
            x++;
            k++;
        }
        // add remaining elements left in high side
        while (y <= high) {
            temp[k] = arr[y];
            y++;
            k++;
        }
        // replace back to arr
        for (x = low; x <= high; x++) {
            arr[x] = temp[x - low];
        }
    }
    
    public static void main (String args[]) throws IOException
	{
		System.out.println("Reading text from attached file . . .\n");
		File textFile = new File("data/MyList-3.txt");
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
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Sorted array contents : ");
		for (int x = 0; x < arr.length; x++)
			System.out.print(arr[x] + ", ");
		br2.close();
		System.out.println("\nDone!");
	}
}
