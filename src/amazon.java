import java.util.*;

/**
 * Created by shiyu on 16/6/28.
 */
public class amazon {
    public static void main(String[] args){
        amazon aa = new amazon();
        System.out.println(aa.decodeWays(263415781));
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(aa.groupAnagrams(str));
        String s = "the sky is blue";
        char[] ss = s.toCharArray();
        aa.reverseWords(ss);
        System.out.println(ss);

        PriorityQueue<String> q = new PriorityQueue<String>();
        q.offer("gbay");
        q.offer("amazon");
        q.offer("cdf");
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(Integer.valueOf('1'));
    }

    public List<String> decodeWays(int n){
        List<String> list = new ArrayList<String>();
        if(n < 1){
            return list;
        }
        String s = String.valueOf(n);
        char[] digits = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        StringBuilder sb = new StringBuilder();
        dfs(s,0,digits,sb,list);
        return list;
    }

    public void dfs(String s, int index, char[] digits, StringBuilder sb, List<String> list){
        if(index >= s.length()){
            list.add(new String(sb));
            sb = new StringBuilder();
            return;
        }
        int oneDigit = Integer.valueOf(s.substring(index,index+1));
        if(oneDigit >= 1 && oneDigit <= 9){
            sb.append(digits[oneDigit]);
            dfs(s, index+1, digits,sb,list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(index < s.length() - 1){
            int twoDigit = Integer.valueOf(s.substring(index,index+2));
            if(twoDigit >= 10 && twoDigit <= 26){
                sb.append(digits[twoDigit]);
                dfs(s,index+2,digits,sb,list);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return res;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str : strs){
            char[] ss = str.toCharArray();
            Arrays.sort(ss);
            String temp = new String(ss);
            if(!map.containsKey(temp)){
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(temp,list);
            }
            else{
                ArrayList<String> list = map.get(temp);
                list.add(str);
                map.put(temp,list);
            }
        }

        for(String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    public void reverseWords(char[] s){
        int i = 0;
        for(int j = 0; j < s.length; j++){
            if(s[j] == ' '){
                reverse(s,i,j-1);
                i = j+1;
            }
        }
        reverse(s,i,s.length-1);
        reverse(s,0,s.length-1);
    }

    public void reverse(char[] s, int i, int j){
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
