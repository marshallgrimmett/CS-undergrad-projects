import java.util.Random;

/*
 * Author: Marshall Grimmett
 * Date: 4/16/2017
 * Description: This program demonstrates a bubble sort by creating an array
 *              and filling it with random integers. Then it is sorted using
 *              the bubble sort and then it is printed to the console.
 */
public class Main {

  // PDMs
  final static int MAX = 10; // Number of values in array
  static Random rand = new Random(); // Random number generator

  // main
  public static void main(String[] args) {
    int[] arr = new int[MAX];
    populate(arr);
    System.out.println("Unsorted list:");
    print(arr);
    bubbleSort(arr);
    System.out.println("\nSorted list:");
    print(arr);
  }

  // print
  // Prints the contents of the array
  public static void print(int[] arr) {
    for (int i = 0; i < MAX; i++) {
      System.out.println(arr[i]);
    }
  }

  // populate
  // Fills an array with random values from 0 to MAX
  public static void populate(int[] arr) {
    for (int i = 0; i < MAX; i++) {
      arr[i] = rand.nextInt(MAX + 1);
    }
  }

  // bubbleSort
  // Sorts an array with optimization. Every pass through the first loop,
  // means one less value to check.
  public static void bubbleSort(int[] arr) {
    int temp; // Used for swapping
    int sorted = MAX; // Position of first value sorted in array
    for (int j = 0; j < MAX; j++) {
      for (int i = 0; i < sorted - 1; i++) {
        // If the next value is smaller, swap
        if (arr[i] > arr[i + 1]) {
          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
        }
      }
      sorted--;
    }
  }

}
