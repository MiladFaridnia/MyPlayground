package com.faridnia.myapplication.leetCode.reverse_vowels_of_string_345

/**
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"



Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */

class Solution {
    fun reverseVowels(s: String): String {
        val vowels = setOf('a','e','i','o','u','A','E','I','O','U')
        val chars = s.toCharArray()
        var left = 0
        var right = chars.size - 1

        while (left < right) {
            while (left < right && chars[left] !in vowels) left++
            while (left < right && chars[right] !in vowels) right--

            if (left < right) {
                val temp = chars[left]
                chars[left] = chars[right]
                chars[right] = temp
                left++
                right--
            }
        }

        return String(chars)
    }
}
