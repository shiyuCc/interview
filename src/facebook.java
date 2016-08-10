import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by shiyu on 16/5/14.
 */
public class facebook {
    public static void main(String[] args){
        facebook fb = new facebook();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> result = fb.binaryTreeVerticalTraversal(root);
        for(ArrayList<Integer> list : result){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        int[][] nums = new int[4][4];
        int n = fb.countValidPath(nums,2,1,3);
        System.out.println(n);
        int[] task = {1, 1,2,1};
        String schedule = fb.taskSchedule(task,2);
        System.out.println(schedule);
        List<String> result1 = fb.decodeWay("1234");
        for(String s : result1){
            System.out.print(s + " ");
        }
        String s = "abc";
        String t = "ajr";
        System.out.println(fb.isOneEditDistance(s,t));

        List<Point> points = new ArrayList<Point>();
        Point origin = new Point(0, 0);
        points.add(new Point(1, 1, origin));
        points.add(new Point(1, 3, origin));
        points.add(new Point(-1, 1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(1, -1, origin));
        points.add(new Point(3, -1, origin));
        points.add(new Point(-1, -1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(2, 2, origin));

        Queue<Point> result2 = fb.closestNum(points,5);
        for(Point p : result2){
            System.out.println(p.x + " " + p.y);
        }
        int[] num1 = {4,5,6,0,0,0};
        int[] num2 = {1,2,3};
        int[] res = fb.mergeSortedArray(num1,3,num2,3);
        System.out.println(Arrays.toString(res));
        int[] num = {45,23,11,3,89,17,98,101,4,28,65,43};
        fb.sort(num);
        System.out.println(Arrays.toString(num));
        fb.convertBinaryTreeToDoubleLinkedList(root);

        Interval a = new Interval(2,3);
        Interval b = new Interval(0,4);
        Interval c = new Interval(6,7);
        Interval d = new Interval(5,9);
        Interval e = new Interval(1,8);
        Interval[] intervals = {a,b,c,d,e};
        System.out.println(fb.meetingRoom(intervals));
        System.out.println(fb.meetingRoom2(intervals));

        int[] num11 = {1,3,-1,-3,5,3,6,7};
        System.out.println(fb.minProduct(num11));
        String s1 = "(()((()())";
        System.out.println(fb.longestValidParentheses(s1));

        System.out.println(fb.longestCommonSubstring("livesomething","happylive"));

        int[] result11 = fb.minSlidingWindow(num11,2);
        for(int i:result11){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(fb.getExistedPosition("abcddfgdghabcerfe","abc"));

        TreeNode root1 = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p11 = new TreeNode(4);
        TreeNode p12 = new TreeNode(5);
        TreeNode p13 = new TreeNode(2);
        TreeNode p14 = new TreeNode(7);
        root1.left = p1;
        root1.right = p2;
        p1.left = p11;
        p1.right = p12;
        p2.left = p13;
        p2.right = p14;

        ListNode head = fb.convertTreeToDoubleLinkedList2(root1);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.right;
        }

        int[] arr = {2,4,7};
        System.out.println(fb.getArrayProduct(arr));
        int[] arr1 = {1,2,5,3,6,9,10,11,12,4,5,8,9,10,11,15,20};
        System.out.println(fb.getLongestIncreaseSubarray(arr1));
        List<String> list = new ArrayList<String>();
        list.add("a,b");
        list.add("c\"d");
        list.add("ef");
        System.out.println(fb.listToCsv(list));
        int[] arr2 = {10,555,100000,100,9};
        fb.sortSML(arr2);
        for(int i : arr2){
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr3 = {15,2,4,8,9,5,10};
        fb.findSubarrayWithSum(arr3,24);

        int[][] nums1 = {{3,1,6,9},{2,5,4,7},{1,4,8,2},{9,3,0,6}};
        int[][] result22 = fb.submatrixSum(nums1,30);
        for(int i = 0; i < 2; i ++){
            for(int j = 0; j < 2; j++){
                System.out.print(result22[i][j] + " ");
            }
        }
        System.out.println();

        System.out.println(fb.isMatch("aa","a"));

        String[] words = {"word","good","best","good"};
        System.out.println(fb.findSubstring("wordgoodgoodgoodbestword", words));

    }

    public ArrayList<ArrayList<Integer>> binaryTreeVerticalTraversal(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return result;
        }

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> cols = new LinkedList<Integer>();

        queue.add(root);
        cols.add(0);

        int min = 0, max = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = cols.poll();
            if(!map.containsKey(col)){
                map.put(col,new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
            if(node.left != null){
                queue.add(node.left);
                cols.add(col-1);
                if(col - 1 < min){
                    min = col-1;
                }
            }
            if(node.right != null){
                queue.add(node.right);
                cols.add(col + 1);
                if(col + 1 > max){
                    max = col + 1;
                }
            }
        }

        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }
        return result;
    }

    public int count = 0;
    public int countValidPath(int[][] nums, int x, int y, int k){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(x == 0 && y == 0 && k == 0){
            return 1;
        }

        //int count = 0;
        dfs(nums,x,y,k);
        return count;
    }

    public void dfs(int[][] nums,int x, int y, int k){
        if(x < 0 || y < 0 || x >= nums.length || y >= nums[0].length){
            return;
        }
        if(k == 0){
            if(x == 0 && y == 0){
                count++;
            }
            return;
        }
        dfs(nums,x + 1, y, k - 1);
        dfs(nums,x,y + 1, k -1);
        dfs(nums,x - 1, y, k - 1);
        dfs(nums,x,y-1,k-1);
    }

    public String taskSchedule(int[] task, int coolDown){
        StringBuffer sb = new StringBuffer();
        if(task == null || task.length == 0){
            return sb.toString();
        }
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < task.length; i++){
            if(!map.containsKey(task[i])){
                if(sb.length() == i){
                    map.put(task[i],i);
                }
                else{
                    map.put(task[i],sb.length() - 1);
                }
                result++;
                sb.append(task[i]);
                //sb.append(' ');
            }
            else{
                int diff = coolDown + 1 - (sb.length() - map.get(task[i]));
                while(diff > 0){
                    result++;
                    sb.append('_');
                    //sb.append(' ');
                    diff--;
                }
                result++;
                sb.append(task[i]);
                //sb.append(' ');
                map.put(task[i],sb.length()-1);
            }
        }
        System.out.println(result);
        return sb.toString();

    }

    public List<String> decodeWay(String s){
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return result;
        }
        StringBuffer sb = new StringBuffer();
        char[] arr = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        dfs(s,result,0,sb,arr);
        return result;
    }

    public void dfs(String s, List<String> result, int index, StringBuffer sb,char[] arr){
        if(index >= s.length()){
            result.add(new String(sb));
            return;
        }
        int oneDigit = Integer.valueOf(s.substring(index,index + 1));
        if(oneDigit >= 1 && oneDigit <= 9){
            sb.append(arr[oneDigit]);
            dfs(s,result,index+1,sb,arr);
            sb.deleteCharAt(sb.length()-1);
        }
        if(index < s.length() - 1){
            int twoDigit = Integer.valueOf(s.substring(index,index + 2));
            if(twoDigit >= 10 && twoDigit <= 26){
                sb.append(arr[twoDigit]);
                dfs(s,result,index + 2,sb,arr);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public boolean isOneEditDistance(String s, String t){
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else if(s.length() < t.length()){
                    return s.substring(i).equals(t.substring(i + 1));
                }
                else{
                    return t.substring(i).equals(s.substring(i + 1));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public Queue<Point> closestNum(List<Point> arr,int k){
        PriorityQueue<Point> queue = new PriorityQueue<Point>();
        for(Point p : arr){
            if(queue.size() < k){
                queue.offer(p);
            }
            else{
                if(queue.peek().compareTo(p) < 0){
                    queue.poll();
                    queue.offer(p);
                }
            }
        }
        return queue;
    }

    public int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n){
        int i = m-1, j = n - 1, p = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[p] = nums1[i];
                i--;
            }
            else{
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }
        while(j >= 0){
            nums1[p] = nums2[j];
            j--;
            p--;
        }
        return nums1;
    }

    public void sort(int[] num){
        int[] temp = new int[num.length];
        mergeSort(num, temp, 0, num.length - 1);
    }

    public void mergeSort(int[] num, int[] temp, int left, int right){

        if(left < right){
            int middle = (right - left) / 2 + left;
            mergeSort(num,temp,left,middle);
            mergeSort(num,temp,middle+1,right);
            merge(num,temp,left,middle + 1,right);
        }
    }

    public void merge(int[] num, int[] temp, int left, int middle, int right){
        int i = left, j = middle, k = left;
        for(int p = left; p <= right; p++){
            temp[p] = num[p];
        }
        while(i <= middle - 1 && j <= right){
            if(temp[i] < temp[j]){
                num[k++] = temp[i++];
            }
            else{
                num[k++] = temp[j++];
            }
        }
        while(i <= middle - 1){
            num[k++] = temp[i++];
        }

        while(j <= right){
            num[k++] = temp[j++];
        }

    }

    public int read(char[] buffer, int n){
        char[] temp = new char[4];
        int read = 0;
        int hasRead = 0;
        while(true){
            read = read4(temp);
            int toRead = Math.min(read, n - hasRead);
            for(int i = 0; i < toRead; i++){
                buffer[hasRead++] = temp[i];
            }
            if(read < 4){
                return hasRead;
            }
            if(hasRead == n){
                return n;
            }
        }
    }

    public int read4(char[] buff){
        return 0;
    }

    public void convertBinaryTreeToDoubleLinkedList(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode head = convertBinaryTree(root);
        printNode(head);
    }

    public TreeNode convertBinaryTree(TreeNode root){
        if(root == null){
            return root;
        }

        root = convertBinaryTreeHelper(root);
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public TreeNode convertBinaryTreeHelper(TreeNode root){
        if(root == null){
            return root;
        }
        if(root.left != null){
            TreeNode left = convertBinaryTreeHelper(root.left);
            while(left.right != null){
                left = left.right;
            }
            left.right = root;
            root.left = left;
        }

        if(root.right != null){
            TreeNode right = convertBinaryTreeHelper(root.right);
            while(right.left != null){
                right = right.left;
            }
            root.right = right;
            right.left = root;
        }
        return root;
    }

    public void printNode(TreeNode root){
        if(root == null){
            return;
        }
        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public boolean meetingRoom(Interval[] intervals){
        if(intervals == null || intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }

    public int meetingRoom2(Interval[] intervals){
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int room = 0, index = 0;
        for(int i = 0; i < start.length; i++){
            if(start[i] < end[index]){
                room++;
            }
            else{
                index++;
            }
        }
        return room;
    }

    public int minProduct(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int max = arr[0],min = arr[0],result = arr[0];

        for(int i = 1; i < arr.length; i++){
            int temp = max;
            max = Math.max((Math.max(max * arr[i], min * arr[i])), arr[i]);
            min = Math.min(Math.min(temp * arr[i], min * arr[i]), arr[i]);
            result = Math.min(result,min);
        }
        return result;
    }

    public String longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int result = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '('){
                stack.pop();
                if(i - stack.peek() > result){
                    result = i - stack.peek();
                    end = i;
                }
            }
            else{
                stack.push(i);
            }
        }
        return s.substring(end - result + 1, end + 1);
    }

    public int longestCommonSubstring(String s, String t){
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return 0;
        }
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = 0;
        }

        for(int i = 0; i <= n; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        int result = -1;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                result = Math.max(result,dp[i][j]);
            }
        }
        return result;
    }

    public int[] minSlidingWindow(int[] nums, int k){
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];

        Deque<Integer> queue = new ArrayDeque<Integer>();
        int p = 0;
        for(int i = 0; i < nums.length; i++){
            while(!queue.isEmpty() && queue.peek() < i - k + 1){
                queue.poll();
            }

            while(!queue.isEmpty() && nums[queue.peekLast()] > nums[i]){
                queue.pollLast();
            }
            queue.add(i);
            if(i >= k - 1){
                result[p++] = nums[queue.peek()];
            }
        }
        return result;
    }

    public int getExistedPosition(String a, String b){
        if(a.length() < b.length() || a.indexOf(b) == -1){
            return -1;
        }
        int pos = a.indexOf(b);
        int result = 0;
        while(pos != -1){
            result = pos;
            pos = a.indexOf(b,pos + 1);
        }
        return result;
    }

    public ListNode convertTreeToDoubleLinkedList2(TreeNode root){
        if(root == null){
            return null;
        }

        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode p = root;
        while(!stack.isEmpty() || p != null){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
        ListNode head = new ListNode(result.get(0));
        int num = 1;
        ListNode pre = head;
        while(num < result.size()){
            ListNode next = new ListNode(result.get(num));
            pre.right = next;
            next.left = pre;
            pre = next;
            num++;
        }
        pre.right = null;
        return head;
    }

    public List<Integer> getArrayProduct(int[] arr){
        List<Integer> result = new ArrayList<Integer>();
        int n = (1 << arr.length) - 1;
        for(int i = 1; i <= n; i++){
            int pro = 1;
            for(int j = 0; j < arr.length; j++){
                if(((i >> j) & 1) == 1){
                    pro *= arr[j];
                }
            }
            result.add(pro);
        }
        return result;
    }

    public int getLongestIncreaseSubarray(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return 1;
        }
        int left = 0, right = 1,max = Integer.MIN_VALUE;
        while(right < arr.length){
            if(arr[right] > arr[right - 1]){
                right++;
            }
            else{
                max = Math.max(max, right - left);
                left = right;
                right = right + 1;
            }
        }
        max = Math.max(max,right - left);
        return max;
    }

    public String listToCsv(List<String> list){
        StringBuilder sb = new StringBuilder();
        if(list == null || list.size() == 0){
            return sb.toString();
        }
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            //String s = temp.substring(1, temp.length() - 1);
            if(s.indexOf(",") == -1 && s.indexOf("\"") == -1){
                sb.append(s);
            }
            else if(s.indexOf(",") == -1){
                String[] strs = s.split("\"");
                for(String str : strs){
                    sb.append("\"" + str + "\"");
                }
            }
            else if(s.indexOf("\"") == -1){
                sb.append("\"" + s + "\"");
            }
            if(i != list.size() - 1){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public int[] sortSML(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }

        int index = 0, sIndex = 0, lIndex = arr.length - 1;
        while(index <= lIndex){
            int temp = arr[index];
            if(arr[index] < 100){
                arr[index] = arr[sIndex];
                arr[sIndex] = temp;
                sIndex++;
            }
            if(arr[index] > 1000){
                arr[index] = arr[lIndex];
                arr[lIndex] = temp;
                lIndex--;
                index--;
            }
            index++;
        }
        return arr;
    }

    public int findSubarrayWithSum(int[] arr, int target){

        int left = 0, right = 0, curr = 0;
        while(right < arr.length){
            while(curr < target && right < arr.length){
                curr += arr[right];
                right++;
            }
            while(curr > target && left < right){
                curr -= arr[left];
                left++;
            }

            if(curr == target){
                int end = right - 1;
                System.out.println("find subarray between index " + left + " " + end);
                return 1;
            }
        }
        System.out.println("can't find a subarray with target sum");
        return 0;
    }

    public int[][] submatrixSum(int[][] nums, int target){
        int[][] result = new int[2][2];
        if(nums == null || nums.length == 0){
            return result;
        }
        int numRows = nums.length;
        int numCols = nums.length;
        int[][] sum = new int[numRows + 1][numCols + 1];
        for(int i = 1; i < numRows + 1; i++){
            for(int j = 1; j < numCols + 1; j++){
                sum[i][j] = nums[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        for(int i1 = 0; i1 < numRows; i1++){
            for(int i2 = i1 + 1; i2 <= numRows; i2++){
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                for(int j = 1; j <= numCols; j++){
                    int diff = sum[i2][j] - sum[i1][j] - target;
                    int curr = sum[i2][j] - sum[i1][j];
                    if(map.containsKey(diff)){
                        result[0][0] = i1;
                        result[0][1] = map.get(diff);
                        result[1][0] = i2 - 1;
                        result[1][1] = j - 1;
                        return result;
                    }
                    map.put(curr,j);
                }
            }
        }
        System.out.println("can't find a sub matrix which has sum equals to target");
        return result;
    }

    public boolean isMatch(String s, String p) {
        if(p.length() != 0 && p.charAt(0) == '*'){
            return false;
        }
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int j = 1; j < p.length();j += 2){
            if(p.charAt(j) == '*'){
                dp[0][j + 1] = dp[0][j-1];
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j-1) != '*'){
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }
                else{
                    dp[i][j] = dp[i][j-2] && j > 1|| dp[i][j-1] || dp[i-1][j] && j > 1 && (s.charAt(i-1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                }
            }
        }
        return dp[m][n];
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || words == null || s.length() == 0 || words.length == 0){
            return result;
        }
        int len = words[0].length();
        if(s.length() < len){
            return result;
        }

        int lenOfWords = len * words.length;
        for(int i = 0; i < s.length() - lenOfWords; i += len){
            String temp = s.substring(i, i + len);
            if(!contains(words,temp)){
                continue;
            }
            else{
                String concate = s.substring(i, i + lenOfWords);
                if(isConcatenation(words,concate)){
                    result.add(i);
                }
            }
        }
        return result;
    }

    public boolean contains(String[] words, String s){
        for(String str : words){
            if(s.equals(str)){
                return true;
            }
        }
        return false;
    }

    public boolean isConcatenation(String[] words, String s){
        int len = words[0].length();
        for(String str : words){
            if(s.indexOf(str) == -1){
                return false;
            }
        }
        return true;
    }

}
