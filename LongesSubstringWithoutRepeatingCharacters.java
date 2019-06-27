import java.util.HashSet;
import java.util.Set;

/**
 * @Author huangxiongbiao
 * @Description
 * @Date 2019/6/27 下午3:11
 */
public class LongesSubstringWithoutRepeatingCharacters {


    /**
     *
     * 方法一：暴力法
     *
     * 题目更新后由于时间限制，会出现 TLE。
     *
     * 思路
     *
     * 逐个检查所有的子字符串，看它是否不含有重复的字符。
     *
     * 算法
     *
     * 假设我们有一个函数 boolean allUnique(String substring) ，
     * 如果子字符串中的字符都是唯一的，它会返回 true，否则会返回 false。
     * 我们可以遍历给定字符串 s 的所有可能的子字符串并调用函数 allUnique。
     * 如果事实证明返回值为 true，那么我们将会更新无重复字符子串的最大长度的答案。
     *
     * 现在让我们填补缺少的部分：
     *
     * 为了枚举给定字符串的所有子字符串，我们需要枚举它们开始和结束的索引。假设开始和结束的索引分别为
     * i 和 j。那么我们有0≤i<j≤n（这里的结束索引j 是按惯例排除的）。因此，使用
     * i 从 0 到n?1 以及j 从i+1 到n 这两个嵌套的循环，我们可以枚举出 s 的所有子字符串。
     * 要检查一个字符串是否有重复字符，我们可以使用集合。我们遍历字符串中的所有字符，并将它们逐个放入 set 中。
     * 在放置一个字符之前，我们检查该集合是否已经包含它。如果包含，我们会返回 false。循环结束后，我们返回 true。
     *
     * 复杂度分析
     *
     * 时间复杂度：
     * O(n3) 。
     *
     * 要验证索引范围在
     * [i,j) 内的字符是否都是唯一的，我们需要检查该范围中的所有字符。 因此，它将花费O(j?i) 的时间。
     *
     * 对于给定的 i，对于所有j∈[i+1,n] 所耗费的时间总和为：

     *
     * 因此，执行所有步骤耗去的时间总和为：
     *
     * 空间复杂度：
     *
     * O(min(n,m))，我们需要O(k) 的空间来检查子字符串中是否有重复字符，
     * 其中k 表示 Set 的大小。而 Set 的大小取决于字符串n 的大小以及字符集/字母m 的大小。
     *
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }


    /**
     *
     * 方法二：滑动窗口
     *
     * 算法
     *
     * 暴力法非常简单，但它太慢了。那么我们该如何优化它呢？
     *
     * 在暴力法中，我们会反复检查一个子字符串是否含有有重复的字符，但这是没有必要的。如果从索引
     * i 到j?1 之间的子字符串Sij已经被检查为没有重复字符。我们只需要检查
     * s[j] 对应的字符是否已经存在于子字符串Sij中。
     *
     * 要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为O(n2) 的算法，但我们可以做得更好。
     *
     * 通过使用 HashSet 作为滑动窗口，我们可以用O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
     *
     * 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即
     * [i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将
     * [i,j) 向右滑动1 个元素，则它将变为[i+1,j+1)（左闭，右开）。
     *
     * 回到我们的问题，我们使用 HashSet 将字符存储在当前窗口[i,j)（最初j=i）中。
     * 然后我们向右侧滑动索引j，如果它不在 HashSet 中，我们会继续滑动j。
     * 直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引i 开头。
     * 如果我们对所有的i 这样做，就可以得到答案。
     *
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }




}
