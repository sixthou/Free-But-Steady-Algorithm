package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q0136 {
    /**
     * 제공자 : leetcode
     * 제목 : 136. Single Number
     * URL : https://leetcode.com/problems/single-number/
     * 난이도 : easy
     * 유형 : 이진탐색
     * 설명 :
     * 예외 :
     **/
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
                continue;
            }
            set.add(num);
        }

        return new ArrayList<>(set).get(0);
    }
}
