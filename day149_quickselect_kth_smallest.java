// Day149 QuickSelect for Kth smallest (Avg O(n))
import java.util.*;
public class Day149QuickselectKthSmallest {

    static int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = l - 1;
        for(int j = l; j < r; j++){
            if(arr[j] <= pivot){
                i++;
                int t = arr[i]; arr[i]=arr[j]; arr[j]=t;
            }
        }
        int t = arr[i+1]; arr[i+1]=arr[r]; arr[r]=t;
        return i+1;
    }

    static int quickSelect(int[] arr, int l, int r, int k){
        if(l <= r){
            int pi = partition(arr, l, r);
            if(pi == k) return arr[pi];
            else if(k < pi) return quickSelect(arr, l, pi-1, k);
            else return quickSelect(arr, pi+1, r, k);
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = {7, 10, 4, 3, 20, 15};
        int k = 2; // 0-based: 3rd smallest
        System.out.println("3rd smallest = " + quickSelect(a, 0, a.length-1, k));
    }
}
