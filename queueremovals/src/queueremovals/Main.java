package queueremovals;

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here
import java.util.List;
import java.util.ArrayList;

class Main {

  // Add any helper functions you may need here
  
  int popItems(List<Integer> array , List<Integer> positions , int x)
  {
     List<Integer> tempArray = new ArrayList<>();
     List<Integer> tempPos  = new ArrayList<>();
     int i = 0;
     Integer maxPos = -1;
     Integer maxValue = -1;
     while ( i < x  && (array.size() > 0 ) )
     {
         Integer val = array.get(0);
         Integer pos = positions.get(0);
         array.remove(0);
         positions.remove(0);
         tempArray.add(val);
         tempPos.add(pos);
         if(val > maxValue)
         {
             maxValue = val;
            maxPos = pos;
         }
         i++;
     }
     int index = tempPos.indexOf(maxPos);
     tempArray.remove(index);
     tempPos.remove(index);
     for( int k = 0; k < tempArray.size();k++)
     {
          int v = tempArray.get(k) -1 ;
          if( v < 0 )
              v = 0;
         array.add(v);
         positions.add(tempPos.get(k));
     }
    
     return maxPos.intValue();
    
  }

  int[] findPositions(int[] arr, int x) {
    // Write your code here
    int [] ret = new int [ x ];
    List<Integer> myArray = new ArrayList<>();
    List<Integer> positions = new ArrayList<>();
    for(int i = 0; i < arr.length ; i++)
    {
       myArray.add(arr[i]);
       positions.add(i+1);
    }
    int k = 0;
    while(myArray.size() > 0  && k < x )
    {
       ret[k] = popItems(myArray, positions,x);
       k++;
    }
    
    return ret;
   
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int[] expected, int[] output) {
    int expected_size = expected.length; 
    int output_size = output.length; 
    boolean result = true; 
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);  
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected); 
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printIntegerArray(int[] arr) {
    int len = arr.length; 
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  
  public void run() {
    int n_1 = 6;
    int x_1 = 5;
    int[] arr_1 = {1, 2, 2, 3, 4, 5};
    int[] expected_1 = {5, 6, 4, 1, 2 };
    int[] output_1 = findPositions(arr_1, x_1);
    check(expected_1, output_1);
    
    int n_2 = 13;
    int x_2 = 4;
    int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
    int[] expected_2 = {2, 5, 10, 13};
    int[] output_2 = findPositions(arr_2, x_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
