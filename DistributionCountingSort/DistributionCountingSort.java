/*
Name: Sean Styer
File: DistributionCountingSort.java
Input: Number of strings to sort, path of the data file path, min, and max
Output: array of ints after sorting
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DistributionCountingSort{
  public static void main(String[] args){
    //take in values from the command line
    int numInts = Integer.valueOf(args[0]);
    String path = args[1];
    int min = Integer.valueOf(args[2]);
    int max = Integer.valueOf(args[3]);

    //create an array of unsorted ints from the data file
    int[] unsorted = createArray(path, numInts);

    //use distribution counting sort to sort the array
    int[] sorted = sort(unsorted,min,max);

    //print the array
    for(int i = 0; i < unsorted.length; i++){
      System.out.println(sorted[i]);
    }
  }

  //take in a text file with a single string on each line
  //and create an array with each string assigned to a cell
    public static int[] createArray(String filePath, int numInts){
      File file = new File(filePath);
      int[] userInput = new int[numInts];

      //parse through the file and save each line as a string in the array
      try {
        Scanner in = new Scanner(file);
        int i = 0;
        while (in.hasNextInt()) {
            userInput[i] = in.nextInt();
            i++;
        }
        in.close();
      }
      //in the event of an error, print the error
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      return userInput;
    }

    //use the distribution search sirt algorithm to sort an array of integers
    public static int[] sort(int[] unsorted, int min, int max){
      int n = unsorted.length;
      int[] sorted = new int[n];
      //create an array to store the counts of each possible integer
      int[] count = new int[max + 1];

      //initialize each count to 0
      for (int i=min-1; i<count.length; ++i){
           count[i] = 0;
       }

       //collect the count of each possible integer in the array
       for(int i = 0; i<unsorted.length; i++){
         count[unsorted[i]]++;
       }

       //add the counts from the beginning of the array to the end
       for(int i=min+1; i < count.length; i++){
         count[i] += count[i-1];
       }

       //populate and return the new array
       for (int i = n-1; i>=0; i--)
       {
           sorted[count[unsorted[i]]-1] = unsorted[i];
           --count[unsorted[i]];
       }
      return sorted;
    }
}
