package longestsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Pair {
    int index;
    int count;

    Pair(int index, int count) {
        this.index = index;
        this.count = count;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int count = 0, longestCount = 0;
        var charMapCounts = new LinkedHashMap<String, Pair>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count++;
            var index = i;
            charMapCounts.computeIfPresent(String.valueOf(c), (k, v) -> new Pair(v.index, v.count + 1));
            charMapCounts.computeIfAbsent(String.valueOf(c), k -> new Pair(index, 1));
            var countWithIndexed = charMapCounts.get(String.valueOf(c));
            if (countWithIndexed.count == 2) {
                longestCount = count - 1 > longestCount ? count -1 : longestCount;
                count = i - countWithIndexed.index;
                var iterator = countWithIndexed.index;
                List<String> keys = charMapCounts
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().index < iterator)

                        .map(entry -> entry.getKey())
                        .collect(Collectors.toList());
                for (String key : keys) {
                    charMapCounts.remove(key);
                }
                charMapCounts.computeIfPresent(String.valueOf(c), (k, v) -> new Pair(index, 1));
            }
        }

        return count > longestCount ? count : longestCount;

    }

    public static void main(String[] args) {
        var solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("cdd") == 2);
        System.out.println(solution.lengthOfLongestSubstring("bbtablud") == 6);
        System.out.println(solution.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(solution.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt") == 5);
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solution.lengthOfLongestSubstring("dvdf") == 3);
        System.out.println(solution.lengthOfLongestSubstring("ckilbkd") == 5);

    }
}
