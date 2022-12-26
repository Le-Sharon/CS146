package hw1;


import java.io.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class uses bubble sort to sort data from test cases
 * 
 * @author Sharon Le
 *
 */
public class BubbleSortClass
{
public static void bubbleSort(int arr[])
{
System.out.println("* We will sort the following numbers using bubbleSort:"); 
System.out.println("76,54,47,88,64,26,59,97,71,9,97,8,79,20,77,83,65,62,76,65,92,80,36,33,59,40,96,90,94,10,38,16,52,26,35,100,53,98,19,50,62,59,74,36,10,96,89,38,76,63\n");
// Example; arr[76] > arr[54], so swap the two elements. Repeat Process.
for(int i = 0; i < arr.length; i++)
{
for(int n = 1; n < arr.length - i; n++)
{
if(arr[n - 1] > arr[n])
{
// Swapping element logic here.
int tempVariable = arr[n - 1];
arr[n - 1] = arr[n];
arr[n] = tempVariable;
}
}
}
}

public static void main(String args[]) throws IOException
{

System.out.println("* Reading the text file...");
File textFile = new File("data/arr1-2");
BufferedReader br = new BufferedReader(new FileReader(textFile));
Scanner scanner = new Scanner(textFile);
System.out.println("** Success!\n");

String line = br.readLine();
int count = 0;
while (line != null)
    {
        line = br.readLine();
        count++;
    }
        br.close();

System.out.println("* The number of integers in the file are: " + count
+ "\n"); 
int[] arr = new int[count];
int n = 0;
while(scanner.hasNextInt())
{
   arr[n++] = scanner.nextInt();
}
bubbleSort(arr);
System.out.println("* The numbers were sorted in an array:"); 
for(int i = 0; i < arr.length; i++)
{
System.out.print(arr[i] + ",");
}
System.out.println("\n\nTime Complexity: O(n^2)!\n");
}
} 
