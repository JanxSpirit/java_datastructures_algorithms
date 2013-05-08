import java.util.*;

class Main {

    public static void main(String[] args) {
        Set<String> ps = permutations("abcd");
        //List<String> ps = getPerms("abc");
        System.out.println("final - ");
        for(String s: ps) {
            System.out.println(s);
        }

        permutation("abcd");
    }

    static Set<String> permutations(String str) {
        Set<String> result = new HashSet<String>();
        if (str.length() == 0) {
            result.add("");
            return result;
        }
        char head = str.charAt(0);
        String tail = str.substring(1);
        Set<String> tailPermuts = permutations(tail);
        for(String tp: tailPermuts) {
            for (int i = 0; i <= tp.length(); i++) {
                String ns = tp.substring(0, i) + head + tp.substring(i);
                result.add(ns);
            }
        }
        return result;
    }

    public  static void permutation(String str) { 
        permutation("", str); 
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
        
    }
}
