package solution;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 *
 * @author: shenxian
 * @date: 2022/8/22 15:15
 */
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
