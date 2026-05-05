import java.util.*;

public class day210_count_of_smaller_numbers_after_self {

    static class Pair {
        int val, index;
        Pair(int v, int i){ val=v; index=i; }
    }

    public static List<Integer> countSmaller(int[] nums){

        int n = nums.length;
        Pair[] arr = new Pair[n];
        int[] result = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = new Pair(nums[i], i);

        mergeSort(arr, 0, n-1, result);

        List<Integer> res = new ArrayList<>();
        for(int x : result) res.add(x);

        return res;
    }

    static void mergeSort(Pair[] arr, int left, int right, int[] result){

        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid+1, right, result);

        merge(arr, left, mid, right, result);
    }

    static void merge(Pair[] arr, int left, int mid, int right, int[] result){

        List<Pair> temp = new ArrayList<>();
        int i = left, j = mid+1, count = 0;

        while(i <= mid && j <= right){

            if(arr[i].val <= arr[j].val){
                result[arr[i].index] += count;
                temp.add(arr[i++]);
            }
            else{
                count++;
                temp.add(arr[j++]);
            }
        }

        while(i <= mid){
            result[arr[i].index] += count;
            temp.add(arr[i++]);
        }

        while(j <= right){
            temp.add(arr[j++]);
        }

        for(int k=left;k<=right;k++)
            arr[k] = temp.get(k-left);
    }
}