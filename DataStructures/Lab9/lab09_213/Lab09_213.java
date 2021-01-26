/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package lab09_213;

/**
 *
 * @author zumrut
 */
public class Lab09_213 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = {6,30,10,54,2,62,80,42};

        System.out.println("Before Insertion Sort:");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i != (array.length-1))
                System.out.print(", ");
        }

        array = insertionSort(array);

        System.out.println();
        System.out.println("After Insertion Sort:");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i != (array.length-1))
                System.out.print(", ");
        }
        System.out.println();
    }

    public static int[] insertionSort(int[] input){
      int temp;
      for (int i = 1; i < input.length; i++) {
        for (int j = i; j > 0; j--) {
          if (input[j] < input[j-1]) {
            temp = input[j];
            input[j] = input[j-1];
            input[j-1] = temp;
          }
        }
      }
        return input;
    }

}
