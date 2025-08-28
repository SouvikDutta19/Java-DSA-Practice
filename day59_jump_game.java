// Jump Game - Greedy Approach
public class day59_jump_game {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println("Can jump (nums1): " + canJump(nums1));
        System.out.println("Can jump (nums2): " + canJump(nums2));
    }
}
