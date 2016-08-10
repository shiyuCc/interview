/**
 * Created by shiyu on 16/4/18.
 */
public class goDaddy {
    static int[] wiggleArrangeArray(int[] intArr) {
        int[] result = new int[intArr.length];
        quickSort(intArr, 0, intArr.length - 1);
        int left = 0, right = intArr.length - 1;
        int index = 0;
        while(left < right){
            result[index++] = intArr[left];
            result[index++] = intArr[right];
            left++;
            right--;
        }
        if(left == right){
            result[index] = intArr[left];
        }
        return result;
    }
    static void quickSort(int[] arr, int left, int right){
        int index = partition(arr,left,right);
        if(left < index - 1){
            quickSort(arr, left, index - 1);
        }
        if(index < right){
            quickSort(arr, index, right);
        }
    }

    static int partition(int[] arr, int left, int right){
        int i = left, j = right;
        int pivot = left + (right - left) / 2;
        while(i <= j){
            while(arr[i] > arr[pivot]){
                i++;
            }
            while(arr[j] < arr[pivot]){
                j--;
            }
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args){
        int[] arr = {1};
        int[] result = wiggleArrangeArray(arr);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

}
