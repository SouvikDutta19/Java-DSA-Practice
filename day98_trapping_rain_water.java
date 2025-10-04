public class day98_trapping_rain_water {
    public static int trap(int[] height) {
        int left=0,right=height.length-1,lmax=0,rmax=0,water=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=lmax) lmax=height[left];
                else water+=lmax-height[left];
                left++;
            }else{
                if(height[right]>=rmax) rmax=height[right];
                else water+=rmax-height[right];
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args){
        int[] h={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Water Trapped: "+trap(h));
    }
}
