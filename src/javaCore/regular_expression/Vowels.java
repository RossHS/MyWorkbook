package javaCore.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 26.12.2017
 */
public class Vowels {
    public static int countVowelsSmart(String str) {
        Pattern pattern = Pattern.compile("[aeiouy]");
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static int countVowelsDumb(String str) {
        char[] vowels = "aeiouy".toCharArray();
        char[] testStr = str.toCharArray();
        int count = 0;
        for (char t : testStr) {
            for (char v : vowels) {
                if (t == v) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowelsSmart("abcdef a12"));
        System.out.println(countVowelsDumb("abcdef a12"));
    }
}
