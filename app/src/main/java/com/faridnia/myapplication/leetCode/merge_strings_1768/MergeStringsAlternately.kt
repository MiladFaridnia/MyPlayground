package com.faridnia.myapplication.leetCode.merge_strings_1768

import kotlin.math.min

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val word1Length = word1.length
        val word2Length = word2.length

        val minimumLength = min(word1Length, word2Length)
        var result = ""

        for (i in 0 until minimumLength) {
            result += word1[i].toString() + word2[i].toString()
        }

        result += if (word1Length > word2Length) {
            word1.substring(min(minimumLength, word1Length), word1Length)
        } else {
            word2.substring(min(minimumLength, word2Length), word2Length)
        }

        return result
    }

}