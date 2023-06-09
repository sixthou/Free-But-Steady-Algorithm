package leetcode;

public class Q0153 {
    /**
     * 제공자 : leetCode
     * 제목 : 153. Find Minimum in Rotated Sorted Array
     * URL : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * 난이도 : Medium
     * 유형 : 이진탐색
     * 설명 :
     * 예외 :
     **/

    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        return nums[findGap(nums)];
    }

    private int findGap(int[] nums){
        int low =0;
        int high = nums.length -1;
        int mid = 0;
        while(low <= high){
            if(high - low == 1){
                if(nums[low] < nums[high]){
                    return 0;
                }
                return high;
            }
            mid = (low + high)/2;
            if(nums[low] < nums[mid]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return -1;
    }
}
