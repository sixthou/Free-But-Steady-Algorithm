package leetcode;

public class Q0035 {
    /**
     * 제공자 : leetcode
     * 제목 : 35. Search Insert Position
     * URL : https://leetcode.com/problems/search-insert-position/
     * 난이도 : easy
     * 유형 : 이진탐색
     * 설명 :
     * 예외 :
     **/

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                low = mid + 1 ;
            }else{
                high = mid -1 ;
            }
        }

        return low;
    }
}
