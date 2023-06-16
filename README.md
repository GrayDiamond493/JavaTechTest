As there are three possible methods, I printed all three with their solutions. The first two are the two solutions
we worked on during the call, but I also made a third one that I thought of after coming up with a solution for the
other two.

First, we have a main method, that calls all three:

```java
import java.util.*;

class MoveZero {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.print("Loop Implementation" +'\n');
        System.out.print("Array :" + Arrays.toString(arr) +'\n');
        System.out.print("Pushed Zeros :" + Arrays.toString(zeroMoverLoop(arr))+'\n'+'\n');
        
        int[] arr2 = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.print("Reverse Implementation"+'\n');
        System.out.print("Array :" + Arrays.toString(arr2)+'\n');
        System.out.print("Pushed Zeros :" + Arrays.toString(zeroMoverReverse(arr))+'\n'+'\n');
    
        int[] arr3 = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.print("Only Push Implementation (No sort)"+'\n');
        System.out.print("Array :" + Arrays.toString(arr3)+'\n');
        System.out.print("Pushed Zeros :" + Arrays.toString(zeroMover(arr3)));
    }
    
```

First, we have the original loop implementation, now fixed so the revert is actually done right without the palindrome.
The solution was very simple, I had the concepts sort of mixed, but with more calm it became obvious that I should have 
used only half the length, so it reverts as I want it to.

```java    
    //Original Loop Implementation
    public static int[] zeroMoverLoop(int[] arr){
        Arrays.sort(arr);
    
        for (int i = 0;i<arr.length/2;i++) {
            int aux = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = aux;
        }
        
        return arr;
    }
```

Then, as I was still upset about the library 'reverse' method, I did some research about it
and found out it would never work with native intdata types, and it would only work if it
was Integer, so I implemented a rustic translation from and int[] array to an Integer[] one.
```java    
    //Reverse Implementation
    public static Object[] zeroMoverReverse(int[] arr){
        Arrays.sort(arr);
        Integer[] array = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            array[i]=arr[i];
        }
        Collections.reverse(Arrays.asList(array));
        return array;
    }
}
```
Finally, after I finished both I went and re-read the exercise and when looking at it
I saw that the output wasn't the expected one, as I wasn't supposed to sort it, but only
send the zero's to the end of the array, so I made a new method, heavily based on the 
original zeroMoverLoop, but instead of reversing, it checks whether the value is a '0',
if it isn't, it swaps them so the beginning of the array is always no-zero and the zero's 
end up at the right.

```java
    public static int[] zeroMover(int[] arr){
        int aux = 0;
        int j = 0;
        
        for (int i = 0;i<(arr.length);i++) {
            if (arr[i]!=0){
                aux = arr[i];
                arr[i]=arr[j];
                arr[j]=aux;
                j++;
            }
            }
            
        return arr;
        
    }
```