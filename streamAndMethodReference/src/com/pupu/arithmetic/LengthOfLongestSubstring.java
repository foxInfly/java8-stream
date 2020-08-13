package com.pupu.arithmetic;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。  相同第一个
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * @author lipu
 * @since 2020-08-13 10:04:05
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String aa = "abcabcbb";
        int i = lengthOfLongestSubstring(aa);
        System.out.println(i);
    }


    public static int lengthOfLongestSubstring(String s) {

        // 哈希集合，记录每个字符是否出现过,只存储不重复的对象
        Set<Character> occ = new HashSet<>();
        int n = s.length();

        // rk右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        //ans 记录最长子串 的长度
        int rk = -1, ans = 0;


        //i就是左指针
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除前一个字符，因为它不能参与计算了
                occ.remove(s.charAt(i - 1));
            }
            //存到hashset,向后走，直到发现重复，然后记录下，就是右索引
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
