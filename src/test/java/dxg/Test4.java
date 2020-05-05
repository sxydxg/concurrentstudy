package dxg;

import pojo.Animal;

import java.util.Arrays;

/**
 * @auther 丁溪贵
 * @date 2019/10/19
 */
public class Test4 {

    public static void main(String[] args) {


        String [] arr = {"a","b","c","d","e","f"};


        int left = 0 ;
        int right = arr.length-1 ;

        while(left<right){

            String tmep=arr[left];
            arr[left] = arr[right];
            arr[right] = tmep ;
            left++ ;
            right-- ;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println(test2());
    }

    public static boolean test2(){


        // 判断一个字符为会文字符串
        int c = 123929321; // 如果给你数字 ，你可以将这个数字转化为字符串来操作
        char[] arr  = Integer.toString(c).toCharArray();
        int left = 0 ;
        int right = arr.length-1 ;
        while(left<right){
            if(arr[left]!=arr[right]){
                    return false ;

            }
            left++ ;
            right-- ;
        }
        return  true ;
    }
}
