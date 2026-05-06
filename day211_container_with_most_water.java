public class day211_container_with_most_water {

    public static int maxArea(int[] height){

        int left = 0, right = height.length-1;
        int max = 0;

        while(left < right){

            int area = Math.min(height[left], height[right]) * (right-left);
            max = Math.max(max, area);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}