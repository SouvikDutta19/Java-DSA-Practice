public class day212_jump_game_ii {

    public static int jump(int[] nums){

        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;

        for(int i=0;i<nums.length-1;i++){

            farthest = Math.max(farthest, i + nums[i]);

            if(i == currEnd){
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }
}