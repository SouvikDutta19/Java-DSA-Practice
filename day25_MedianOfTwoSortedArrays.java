public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length, y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0)
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                else
                    return Math.max(maxX, maxY);
            } else if (maxX > minY)
                high = partitionX - 1;
            else
                low = partitionX + 1;
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};
        System.out.println("Median is: " + findMedianSortedArrays(nums1, nums2));
    }
}
