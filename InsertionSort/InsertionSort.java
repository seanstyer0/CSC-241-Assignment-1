/*
Name: Sean Styer
File: InsertionSort.java
Input: Number of strings to sort, path of the data file path
Output: array of strings before sorting and after sorting
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InsertionSort{
  public static void main(String[]args){
    //scanners for user input
    Scanner num = new Scanner(System.in);
    Scanner path = new Scanner(System.in);

    int numStrings =Integer.valueOf(args[0]);
    String location = args[1];

/*
    //prompt users for number of strings and file path
    System.out.println("Please provide the number of strings you wish to sort.");
    int numStrings = num.nextInt();

    System.out.println("Please enter the path to the data file.");
    String location = path.nextLine();
    num.close();
    path.close();
*/
    //create an array of strings from the user file and print the unsorted array
    String[] userList = createArray(location, numStrings);

  //  for(int i = 0; i < userList.length; i++){
    //  System.out.println(userList[i]);
    //}

    //System.out.println("");

    //sort the array alphabetically and print out the sorted array
    String[] sortedList = sort(userList);

    for(int i = 0; i < userList.length; i++){
      System.out.println(sortedList[i]);
    }
  }

//take in a text file with a single string on each line
//and create an array with each string assigned to a cell
  public static String[] createArray(String filePath, int stringNum){
    File file = new File(filePath);
    String[] userInput = new String[stringNum];

    //parse through the file and save each line as a string in the array
    try {
            Scanner in = new Scanner(file);
            int i = 0;
            while (in.hasNextLine()) {
                userInput[i] = in.nextLine();
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

  //take an array of strings and sort the contents alphabetically(ignoring case)
  public static String[] sort(String[] unsortedStrings){
    //copy the array into another array that will be sorted
    String[] sortedStrings = new String[unsortedStrings.length];
      for(int i = 0; i < sortedStrings.length; i++){
        sortedStrings[i] = unsortedStrings[i];
      }

      //use insertion sort to sort thr array alphabetically
      int i = 0;
      String key = "";

      for(int j = 1; j < sortedStrings.length; j++){
        key = sortedStrings[j];
        i  = j - 1;

        while(i > -1 && key.compareTo(sortedStrings[i]) < 0){
          sortedStrings[i+1] = sortedStrings[i];
          i = i-1;
          sortedStrings[i+1] = key;
        }
      }
    return sortedStrings;
  }
}
