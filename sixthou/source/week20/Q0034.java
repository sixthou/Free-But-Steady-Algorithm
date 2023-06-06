package leetcode;

public class Q0034 {
    /**
     * 제공자 : leetcode
     * 제목 : 34. Find First and Last Position of Element in Sorted Array
     * URL : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 난이도 : Medium
     * 유형 : 이진탐색
     * 설명 :
     * 예외 :
     **/

    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[]{-1,-1};
        int targetIndex = findTargetIndex(nums, target);
        if(targetIndex == -1) return answer;

        return findRangeOfIndex(nums, targetIndex);
    }

    private int[] findRangeOfIndex(int[] nums, int index){
        int targetVal = nums[index];
        int start = index;
        int finish = index;
        for(int i = index ; i >= 0 ;i--){
            if(targetVal == nums[i]){
                start = i;
            }else{
                break;
            }
        }

        for(int i = index ; i <= nums.length - 1 ; i++){
            if(targetVal == nums[i]){
                finish = i;
            } else{
                break;
            }
        }
        return new int[]{start, finish};
    }

    private int findTargetIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }

        return -1;
    }
}
