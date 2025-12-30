public class day174_merge_sorted_arrays {
    public static int[] merge(int[] a, int[] b){
        int i=0,j=0,k=0;
        int[] res=new int[a.length+b.length];

        while(i<a.length && j<b.length){
            res[k++] = (a[i]<b[j]) ? a[i++] : b[j++];
        }

        while(i<a.length) res[k++] = a[i++];
        while(j<b.length) res[k++] = b[j++];

        return res;
    }

    public static void main(String[] args){
        int[] a={1,3,5}, b={2,4,6};
        int[] res=merge(a,b);
        for(int x:res) System.out.print(x+" ");
    }
}