public class day92_trapping_rain_water {
    public static int trap(int[] height) {
        int l=0,r=height.length-1,lmax=0,rmax=0,res=0;
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>=lmax) lmax=height[l]; else res+=lmax-height[l];
                l++;
            }else{
                if(height[r]>=rmax) rmax=height[r]; else res+=rmax-height[r];
                r--;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
