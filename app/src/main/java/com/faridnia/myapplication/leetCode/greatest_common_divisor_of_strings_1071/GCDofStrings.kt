package com.faridnia.myapplication.leetCode.greatest_common_divisor_of_strings_1071

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */

class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {

        if (str1 + str2 != str2 + str1) {
            return ""
        }

        val gcdLength = gcd(str1.length, str2.length)

        val gcdString = str1.take(gcdLength)
        var temp1 = ""
        repeat((str1.length / gcdLength)) {
            temp1 += gcdString
        }

        var temp2 = ""
        repeat((str2.length / gcdLength)) {
            temp2 += gcdString
        }

        return if (temp1 == str1 && temp2 == str2) {
            gcdString
        } else
            ""
    }

    fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }
}
