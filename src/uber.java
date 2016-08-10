import java.util.*;

/**
 * Created by shiyu on 16/4/2.
 */
public class uber {
    public static void main(String[] args){
        uber uu = new uber();
        LinkedList<String> dict = new LinkedList<String>();
        dict.add("i");
        dict.add("ant");
        dict.add("want");
        dict.add("toffer");
        dict.add("offer");
        LinkedList<String> result = uu.wordBreak("iwantoffer",dict);
        System.out.println(result);
        int[] arr = new int[7];
        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 8;
        arr[3] = 9;
        arr[4] = 1;
        arr[5] = 2;
        //uu.insertNum(7,arr);

        Player p1 = new Player("Zhuo",83);
        Player p2 = new Player("Li",92);
        Player p3 = new Player("Fu",86);
        Player p4 = new Player("Shiyu",100);
        Player p5 = new Player("Za",78);
        Player[] players = {p1,p2,p3,p4,p5};

        System.out.println(uu.quickSelect(players,4));
        /*int index = uu.quickSelect(players,1);
        uu.quickSort(players,0,index);
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getName() + " " + players[i].getScore());
        }*/

        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        LinkedList<String> h1 = new LinkedList<String>();
        h1.add("1");
        h1.add("2");
        h1.add("3");
        LinkedList<String> h2 = new LinkedList<String>();
        h2.add("2");
        h2.add("4");
        LinkedList<String> h3 = new LinkedList<String>();
        h3.add("3");
        h3.add("4");
        h3.add("5");
        LinkedList<String> h4 = new LinkedList<String>();
        h4.add("1");
        h4.add("5");
        map.put("a",h1);
        map.put("b",h2);
        map.put("c",h3);
        map.put("d",h4);
        System.out.println(uu.getProjectOfPeople(map));
        int[][] arr1 = {{0,0,0,0,0},{0,1,0,1,0},{0,0,0,1,0}};
        uu.findPath(arr1);

    }

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i < pattern.length(); i++){
            char temp = pattern.charAt(i);
            if(!map.containsKey(temp)){
                if(map.containsValue(strs[i])){
                    return false;
                }
                map.put(temp,strs[i]);
            }
            else{
                if(!strs[i].equals(map.get(temp))){
                    return false;
                }
            }
        }
        return true;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode head = l;
        HashSet<Integer> set = new HashSet<Integer>();
        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                if(!set.contains(l1.val)){
                    l.next = l1;

                    set.add(l1.val);
                    l = l.next;
                }

                l1 = l1.next;

            }
            else{
                if(!set.contains(l2.val)){
                    l.next = l2;

                    set.add(l2.val);
                    l = l.next;
                }

                l2 = l2.next;


            }

        }
        if(l1 != null){
            l.next = l1;
        }
        else if(l2 != null){
            l.next =l2;
        }
        return head.next;
    }

    public boolean validPosition(String s){
        String[] strs = s.split(",");
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for(int i = 0; i < strs.length; i++){
            String temp = strs[i];
            String[] ss = temp.split(" ");
            if(i == 0){
                map.put(Integer.valueOf(ss[0]),"0,0");
            }
            if(!map.containsKey(Integer.valueOf(ss[2]))){
                String currP = map.get(Integer.valueOf(ss[0]));
                String nextP = getCoordinates(currP,ss[1]);
                map.put(Integer.valueOf(ss[2]),nextP);
            }
            else{
                String currP = map.get(Integer.valueOf(ss[0]));
                String nextP = map.get(Integer.valueOf(ss[2]));
                String dir = getDir(currP,nextP);
                if(dir.equals(ss[1])){
                    return true;
                }
            }
        }
        return false;
    }

    public String getDir(String s, String t){
        String[] ss = s.split(",");
        String[] tt = t.split(",");

        int x1 = Integer.valueOf(ss[0]);
        int y1 = Integer.valueOf(ss[1]);
        int x2 = Integer.valueOf(tt[0]);
        int y2 = Integer.valueOf(tt[1]);
        String result = "";
        if(y1 > y2){
            result += "N";
        }
        else if(y1 < y2){
            result += "S";
        }
        if(x1 > x2){
            result += "E";
        }
        else if(x1 < x2){
            result += "W";
        }
        return result;
    }

    public String getCoordinates(String origin, String direction){
        String[] s = origin.split(",");
        int x = Integer.valueOf(s[0]);
        int y = Integer.valueOf(s[1]);
        int rx = x, ry = y;
        for(int i = 0; i < direction.length(); i++){
            char temp = direction.charAt(i);
            if(temp == 'N'){
                ry--;
            }
            else if(temp == 'S'){
                ry++;
            }
            else if(temp == 'E'){
                rx--;
            }
            else if(temp == 'W'){
                rx++;
            }
            else{
                break;
            }
        }
        return String.valueOf(rx) + "," +  String.valueOf(ry);
    }

    public LinkedList<String> wordBreak(String s, List<String> Dict){
        for(int i = s.length()-1; i >= 0; i--){
            if(Dict.contains(s.substring(i))){
                break;
            }
            if(i == 0){
                return new LinkedList<String>();
            }
        }

        LinkedList<String>[] dp = (LinkedList<String>[])new LinkedList<?>[s.length() + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = new LinkedList<String>();
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(Dict.contains(s.substring(j,i)) && (j == 0 || dp[j].size() > 0)){
                    if(j == 0){
                        dp[i].add(s.substring(j,i));
                    }
                    else{
                        for(String ss : dp[j]){
                            dp[i].add(ss);

                        }
                        dp[i].add(s.substring(j,i));
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public void printNodes(String s){
        String str = s.substring(1,s.length()-1);
        Stack<Character> st = new Stack<Character>();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if(temp >= '0' && temp <= '9'){
                sb.append(temp);
            }
            else if(temp == '['){
                st.push(temp);
                sb.append(temp);
            }
            else if(temp == ']'){
                st.pop();
                sb.append(temp);
            }
            else{
                if(st.isEmpty()){
                    System.out.println(sb);
                    sb = new StringBuffer();
                }
                else{
                    sb.append(temp);
                }
            }
        }
        System.out.println(sb);
    }

    public void insertNum(int target, int[] arr){
        int len = arr.length - 1;
        int left = 0, right = len - 1;
        int start = 0;
        //boolean flag = false;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(arr[mid] == target){
                start = mid;
                //flag = true;
                break;
            }
            if(right - left == 1){
                start = right;
                break;
            }
            if(arr[mid] < arr[right]){
                if(arr[mid] < target && target <= arr[right]){
                    left = mid;
                }
                else{
                    right = mid;
                }
            }
            else{
                if(arr[left] <= target && target < arr[mid]){
                    right = mid;
                }
                else{
                    left = mid;
                }
            }
        }
        /*if(!flag){
            start = right;
        }*/
        for(int i = len - 1; i >= start; i--){
            arr[i+1] = arr[i];
        }
        arr[start] = target;
        for(int i = 0; i <= len; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public int partition(Player[] arr, int left, int right){
        int i = left, j = right;
        int pivot = left + (right - left) / 2;
        while(i <= j){
            while(arr[i].getScore() > arr[pivot].getScore()){
                i++;
            }
            while(arr[j].getScore() < arr[pivot].getScore()){
                j--;
            }
            if(i <= j){
                Player temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    public void quickSort(Player[] arr,int left, int right){
        int index = partition(arr,left,right);
        if(left < index - 1){
            quickSort(arr, left, index - 1);
        }
        if(index < right){
            quickSort(arr,index,right);
        }
    }

    public int quickSelect(Player[] arr, int k){
        int index = partition(arr,0,arr.length - 1);
        if(k <= index){
            partition(arr,0,index);
        }
        else{
            partition(arr,index + 1,arr.length - 1);
        }
        return arr[k-1].getScore();
    }

    public HashMap<String, LinkedList<String>> getProjectOfPeople(HashMap<String, LinkedList<String>> map){
        HashMap<String, LinkedList<String>> result = new HashMap<String, LinkedList<String>>();

        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            String key = iter.next();
            LinkedList<String> group = map.get(key);

            for(String people : group){
                if(!result.containsKey(people)){
                    LinkedList<String> project = new LinkedList<String>();
                    project.add(key);
                    result.put(people,project);
                }
                else{
                    LinkedList<String> project = result.get(people);
                    project.add(key);
                    result.put(people,project);
                }
            }
        }
        return result;
    }

    public boolean findPath(int[][] num){
        int row = num.length;
        if(row == 0){
            return false;
        }
        int col = num[0].length;
        int[][] result = new int[row][col];
        if(!findPathHelper(num,0,0,result)){
            return false;
        }
        printPath(result);
        return true;
    }

    public boolean findPathHelper(int[][] num, int x, int y, int[][] result){
        int row = num.length;
        int col = num[0].length;
        if(x == row - 1 && y == col - 1){
            result[x][y] = 1;
            return true;
        }
        if(isValidPos(num,x,y)){
            result[x][y] = 1;
            if(findPathHelper(num,x + 1,y,result)){
                return true;
            }
            if(findPathHelper(num,x,y+1,result)){
                return true;
            }
            result[x][y] = 0;
            return false;
        }
        return false;
    }

    public boolean isValidPos(int[][] num, int x, int y){
        int row = num.length;
        int col = num[0].length;
        if(x >= 0 && x < row && y >= 0 && y < col && num[x][y] == 0){
            return true;
        }
        return false;
    }

    public void printPath(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
