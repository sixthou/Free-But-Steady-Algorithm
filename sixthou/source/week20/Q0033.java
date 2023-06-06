package leetcode;

public class Q0033 {
    /**
     * 제공자 : leetcode
     * 제목 : 33. Search in Rotated Sorted Array
     * URL : https://leetcode.com/problems/search-in-rotated-sorted-array/
     * 난이도 : Medium
     * 유형 : 이진탐색
     * 설명 :
     * 예외 :
     **/

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while(low <= high) {
            mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid -1;
                }else{
                    low = mid + 1;
                }
            }else {
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
