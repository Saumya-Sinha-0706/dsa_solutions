class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        
        while (low <= high) {

            
            int mid = (low + high) / 2;

            /
            if (nums[mid] == target)
                return mid;

            
            if (nums[low] <= nums[mid]) {

                // If target lies within sorted left part
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                // Else, search in right half
                else {
                    low = mid + 1;
                }
            }

            // Else, right part is sorted
            else {

                // If target lies within sorted right part
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }
                // Else, search in left half
                else {
                    high = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}