package com.cigit.search;

import java.util.Arrays;

/**
 * 插值排序算法
 * 要求
 * 1.是一个有序得数组
 * 2.数组之间数得差值分布均匀
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i <100 ; i++) {
            array[i] = i+1;
        }
        //System.out.println(Arrays.toString(array));
        System.out.println(search(array, 0, array.length - 1, 58));
    }

    /**
     *
     * 插值查找算法是在二分查找算法得一个升级，在寻找mid得时候是一个自适应得寻找
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @param targetValue
     * @return
     */
    public static int search(int[] array,int leftIndex,int rightIndex,int targetValue){
        System.out.println("插值查找法~~");

        /**
         *  targetValue<array[leftIndex]||targetValue>array[rightIndex]
         *  若不加 可能会导致数组越界
         *  leftIndex>rightIndex 表明递归结束也找不到该值，可画图解析
         */
        if(leftIndex>rightIndex || targetValue<array[leftIndex]||targetValue>array[rightIndex]){
            return -1;
        }

        int mid = leftIndex + (rightIndex - leftIndex) * (targetValue - array[leftIndex]) / (array[rightIndex] - array[leftIndex]);
        int midValue = array[mid];
        if(targetValue>midValue){
            return search(array, mid+1, rightIndex, targetValue);//右递归
        }else if(targetValue<midValue){
            return search(array,leftIndex, mid-1, targetValue);//左递归
        }else {
            return mid;
        }

    }
}
