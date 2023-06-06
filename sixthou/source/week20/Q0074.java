package leetcode;

public class Q0074 {
    /**
     * 제공자 : leetcode
     * 제목 : search-a-2d-matrix
     * URL : https://leetcode.com/problems/search-a-2d-matrix/
     * 난이도 : Medium
     * 유형 : 이진탐색
     * 설명 :
     * 예외 :
     **/

    public boolean searchMatrix(int[][] matrix, int target) {
        //findTargetRow
        int targetRow = findTargetRow(matrix, target);
        if(targetRow > matrix.length-1) return false;
        return findTargetRow(matrix[targetRow], target);
    }

    private boolean findTargetRow(int[] matrix, int target){
        int low = 0;
        int high = matrix.length -1;
        int mid =0;
        while(low <= high){
            mid = (low + high)/2;
            if(matrix[mid] == target){
                return true;
            }
            if(matrix[mid] < target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return false;
    }



    private int findTargetRow(int[][]matrix, int target){
        int lastCol = matrix[0].length -1;
        int low = 0;
        int high = matrix.length -1;
        int mid =0;
        while(low <= high){
            mid = (low + high)/2;
            if(matrix[mid][lastCol] == target){
                return mid;
            }
            if(matrix[mid][lastCol] < target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return low;
    }
}
