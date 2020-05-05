package dxg;

/**
 * @auther 丁溪贵
 * @date 2019/10/18
 */
public class TestQuickSort {

    public static int[] qsort(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }

            // 如果2个值相等，则继续寻找
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                // 交换2个值
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 上诉步骤确定了pivot的位置

        // 支点的左边递归
        if (i-1>start) arr=qsort(arr,start,i-1);
        //支点的右边递归
        if (j+1<end) arr=qsort(arr,j+1,end);

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{8,4,6,7,1,20,18};
        int len = arr.length-1;
        arr=qsort(arr,0,len);
        for (int i:arr) {
            System.out.print(i+"\t");
        }
    }
}
