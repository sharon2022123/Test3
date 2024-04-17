/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.test3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author shesh
 */
public class Test3 {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        
        //accepts user input for the length of array
        System.out.println("Please enter number of elements: ");
        
        int length = input.nextInt();
        int[] arr = new int[length];
        
        //generates a random integer between 0 and 100 inclusive
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(100);
        }
        
        //prints the array before selection sort
        System.out.println("Unsorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        //starts counting the time in nanoseconds
        long startTime = System.nanoTime();
        
        /* integrates selection sort by finding the minimum
        and swapping with the first element
        then increasing the starting position 
        while counting the number of comparisons and swaps made
        */
        int numComparisons = 0;
        int numSwaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                numComparisons++;
                if (arr[j] < arr[minIndex]) {
                    numSwaps++;
                    minIndex = j;
                }
            }
            //temp variable to hold value at starting position
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        //ends the time in nanoseconds and prints the total time
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        
        //prints the sorted array
        System.out.println("\nSorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
       //prints the time it took to sort in nanoseconds
        System.out.println("\nProcessing time: " + timeElapsed + " ns\nNumber of comparisons: " + numComparisons + "\nNumber of swaps: " + numSwaps);
    }
}
