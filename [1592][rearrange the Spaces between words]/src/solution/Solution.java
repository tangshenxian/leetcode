package solution;

/**
 * 1592. 重新排列单词间的空格
 *
 * @author: shenxian
 * @date: 2022/9/7 9:55
 */
public class Solution {

    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int spaceCnt = text.length();
        for (String word : words) {
            spaceCnt -= word.length();
        }
        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
            sb.append(words[0]);
            for (int i = 0; i < spaceCnt; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int spacePre = spaceCnt / (words.length - 1);
        int spaceEnd = spaceCnt % (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                for (int j = 0; j < spacePre; j++) {
                    sb.append(" ");
                }
            }
            sb.append(words[i]);
        }
        for (int i = 0; i < spaceEnd; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
