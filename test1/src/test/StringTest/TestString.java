package test.StringTest;

import org.junit.Test;

/**
 * @Author Administrator
 * @Date 2021/8/28 5:10
 * @Version 1.0
 */
public class TestString {
    public String trim(String oldString) {
        int indexStart = 0;
        int indexEnd = 0;
        if ("".equals(oldString)) return "";//空字符串
        for (int i = oldString.length() - 1; i >= indexStart; i--) {
            if (oldString.charAt(i) != ' ') {
                indexEnd = i;
                break;
            }
        }
        for (int i = 0; i < oldString.length(); i++) {
            if (oldString.charAt(i) != ' ') {
                indexStart = i;
                break;
            }
        }
        if (oldString.charAt(0) == ' ' || oldString.charAt(oldString.length() - 1) == ' ') {//前面或后面有空格
            if (oldString.charAt(0) != ' ' && oldString.charAt(oldString.length() - 1) == ' ') //前面没空格后面有空格
                return oldString.substring(0, indexEnd + 1);
            else if (oldString.charAt(0) == ' ' && oldString.charAt(oldString.length() - 1) != ' ')//前面有空格后面没有空格
                return oldString.substring(indexStart);
            else if (oldString.charAt(0) == ' ' && oldString.charAt(oldString.length() - 1) == ' ')//前面有空格后面有空格
                if (indexEnd != 0)
                    return oldString.substring(indexStart, indexEnd + 1);//有字符
        } else return oldString;//无空格
        return "";//只有空格
    }

    @Test
    public void testTrim() {
        TestString ts = new TestString();
        String s = "";
        //   System.out.println(s.substring(0,1));
        System.out.println(ts.trim(s).equals(s.trim()));
        System.out.println(ts.trim(s));
        System.out.println("================");
        System.out.println(s.trim());
    }

    public String reverse(String oldString, int startIndex, int endIndex) {
        StringBuilder s = new StringBuilder();
        s.append(oldString.substring(startIndex, endIndex + 1));
        s.reverse();
        StringBuilder s1 = new StringBuilder();
        s1.append(oldString.substring(0, startIndex)).append(s).append(oldString.substring(endIndex + 1));
        return new String(s1);
    }

    @Test
    public void testReverse() {
        String s1 = "12345";
        System.out.println(reverse(s1, 0, 4));


    }

    int count(String mainStr, String subStr) {
        int count = 0;
        int start = 0;
        while (start < mainStr.length()) {
            int index = mainStr.indexOf(subStr, start);
            if (index >= 0) {
                count++;
                start = index + 1;
            } else start++;
        }
        return count;
    }

    @Test
    public void testCount() {
        String s = "0123450103";
        System.out.println(count(s, "0"));
    }

    public String getMaxSameString(String string, String searchString) {
        String maxString = string.length() > searchString.length() ? string : searchString;
        String minString = string.length() > searchString.length() ? searchString : string;
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < minString.length(); i++) {
            for (int j = minString.length(); j > i; j--)
                if (maxString.contains(minString.substring(i, j)))
                    if (max < j - i) {
                        max = j - i;
                        start = i;
                        end = j;
                    }
        }
        return minString.substring(start, end);
    }

    @Test
    public void testGetMaxSameString() {
        String s1 = "12356asd";
        String s2 = "0";
     //   System.out.println(s2.substring(s2.length()-1));
        System.out.println(getMaxSameString(s1, s2));
    }

    public static void main(String[] args) {

//前面或后面有空格
//只有空格
//前面没空格后面有空格
//前面有空格后面有空格
//无空格
//空字符串
    }
}
