import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Ahmad Al-Omari
 * @mailto : alomari.ah98@gmail.com
 * @created : 10/21/2022, Friday
 * @project : dynamic-programming-memoization-all-construct
 **/
public class AllConstruct {

    public static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> memo) {
        if (memo.containsKey(target)){
            return memo.get(target);
        }
        List<List<String>> result = new ArrayList<>();
        if (target.equals("")) {
            List<String> lst = new ArrayList<>();
            lst.add("");
            result.add(lst);
            return result;
        }
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);
                concat(suffixWays, word);
                List<List<String>> subResult = new ArrayList<>();
                for (List<String> way: suffixWays){
                    List<String> subResultWay = new ArrayList<>(way);
                    subResult.add(subResultWay);
                }
                result.addAll(subResult);
            }
        }
        memo.put(target, deepCopy(result));
        return result;
    }

    public static List<List<String>> deepCopy(List<List<String>> list){
        List<List<String>> result = new ArrayList<>();
        for (List<String> strings : list) {
            for (String string : strings) {
                ArrayList<String> cloned = new ArrayList<>();
                cloned.add(string);
                result.add(cloned);
            }
        }
        return result;
    }

    public static void concat(List<List<String>> array, String word) {
        for (List<String> value : array) {
            value.add(0, word);
            value.remove("");
        }
    }

    public static void printResult(List<List<String>> array2d) {
        for (List<String> lst : array2d) {
            for (String subWord : lst) {
                System.out.print(subWord + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printResult(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()));
        printResult(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}, new HashMap<>()));
        printResult(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        printResult(allConstruct("aaaaaaaaaaaaaaaaaaz", new String[]{"a", "aa", "aaa", "aaaa"}, new HashMap<>()));
    }
}
