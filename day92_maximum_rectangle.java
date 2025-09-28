import java.util.*;

public class day92_maximum_rectangle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int[] heights=new int[matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                heights[j]=matrix[i][j]=='1'?heights[j]+1:0;
            }
            max=Math.max(max,largestRectangleArea(heights));
        }
        return max;
    }
    static int largestRectangleArea(int[] h){
        Stack<Integer> st=new Stack<>();
        int max=0;
        for(int i=0;i<=h.length;i++){
            int cur=i==h.length?0:h[i];
            while(!st.isEmpty() && cur<h[st.peek()]){
                int height=h[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                max=Math.max(max,height*width);
            }
            st.push(i);
        }
        return max;
    }
    public static void main(String[] args){
        char[][] mat={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(mat));
    }
}
