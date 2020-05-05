package dxg;

import java.util.Arrays;

/**
 * @auther 丁溪贵
 * @date 2019/10/18
 */
public class Test_Maopao {

    public static void main(String[] args) {

        int [] arr = {2,45,21,5343,143,4,53,3} ;

        // 时间复杂度 o(n^2)
        for(int i=0;i<arr.length-1;i++){   // 趟数 也可以i<arr.length,但是会多一趟
            for(int j=0;j<arr.length-i-1;j++){

                if(arr[j]>arr[j+1]){
                    //System.out.println(arr[j]+" --" +arr[j+1]);
                    //交换顺序
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp ;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
