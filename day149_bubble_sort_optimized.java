// Day149 Optimized Bubble Sort (breaks early if sorted)
import java.util.*;
public class Day149BubbleSortOptimized {

    static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            boolean swapped = false;
            for(int j=0; j<n - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int t = arr[j]; arr[j]=arr[j+1]; arr[j+1]=t;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    public static void main(String[] args){
        int[] arr = {5,1,4,2,8};
        bubbleSort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}
