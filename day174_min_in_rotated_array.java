public class day174_min_in_rotated_array {
    public static int findMin(int[] arr){
        int left=0,right=arr.length-1;

        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]>arr[right])
                left=mid+1;
            else
                right=mid;
        }
        return arr[left];
    }

    public static void main(String[] args){
        int[] arr={7,9,12,1,3,5};
        System.out.println(findMin(arr));
    }
}