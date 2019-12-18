package com.yxd.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuxudong
 * @date 2019/10/27 14:36
 */
public class Main3 {

    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<>();
        int res = 0;
        char[] cs = s.toCharArray();
        for (char c : cs){
            if (q.size() != 0 && q.contains(c) ){
                q.clear();
                q.add(c);
            } else {
                q.add(c);
            }
            res = Math.max(res, q.size());
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "dvdf";
        System.out.println(new Main3().lengthOfLongestSubstring(a));
    }
}
