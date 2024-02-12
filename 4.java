class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is the smaller array
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int pX = (low + high) / 2;
            int pY = (x + y + 1) / 2 - pX;

            int maxX = (pX == 0) ? Integer.MIN_VALUE : nums1[pX - 1];
            int minX = (pX == x) ? Integer.MAX_VALUE : nums1[pX];

            int maxY = (pY == 0) ? Integer.MIN_VALUE : nums2[pY - 1];
            int minY = (pY == y) ? Integer.MAX_VALUE : nums2[pY];

            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double) Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = pX - 1;
            } else {
                low = pX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
