package com.cigit.sort.bubble;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/7 15:52
 * 冒泡排序 时间复杂度为T(n)=O(n^2)
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i <80000 ; i++) {
            array[i] =(int) (Math.random()*80000000);
        }
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        sort(array);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //System.out.println(Arrays.toString(array));
    }

    /**
     * 第一次循环
     * 1.第一个与第二个比较，若第一个比第二大则交换位置
     * 2.第二个与第三个比较，依次类推，则把最大的元素放在最后
     * 第二循环
     * 重复上诉步骤，只不过最后一个元素不用在比较
     *
     * 如果在抹一次排序中，没有发生一次交换，可以提前退出循环，这就是优化
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {//最后一次排序不需要，因为只剩一个元素了，所以只遍历array.length-1趟
            boolean flag =true;//优化
            for (int j = 0; j < array.length - i - 1; j++) {//(-i)表示第几轮遍历，不在比较后面已经遍历大的元素，-1表示自己与自己不在比较
                if (array[j] > array[j + 1]) {//前后两元素
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    //flag=false;
                }
            }
           /* System.out.printf("第%d趟遍历 \n",i+1);
            System.out.println(Arrays.toString(array));
            if(flag){
                break;
            }*/
        }

        //拆分：
        //1.第一趟遍历
       /* int temp=0;
        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                temp = array[i];
                array[i]=array[i+1];
                array[i+1] =temp;
            }
        }
        System.out.println("第一趟遍历");
        System.out.println(Arrays.toString(array));
        *//**
         * 选出倒数第二大的元素，那么倒数第一大的元素就不用管了，所以要遍历的数组长度就相当于length-1
         *//*

        for(int i=0;i<array.length-1-1;i++){
            if(array[i]>array[i+1]){
                temp = array[i];
                array[i]=array[i+1];
                array[i+1] =temp;
            }
        }
        System.out.println("第二趟遍历");
        System.out.println(Arrays.toString(array));
        *//**
         * 选出倒数第三大的元素，那么倒数第一大和第二大的元素就不用管了，所以要遍历的数组长度就相当于length-2
         *//*
        for(int i=0;i<array.length-1-2;i++){
            if(array[i]>array[i+1]){
                temp = array[i];
                array[i]=array[i+1];
                array[i+1] =temp;
            }
        }
        System.out.println("第三趟遍历");
        System.out.println(Arrays.toString(array));
        *//**
         * 选出倒数第四大的元素，那么倒数第一大和第二大,第三大的元素就不用管了，所以要遍历的数组长度就相当于length-3
         *//*
        for(int i=0;i<array.length-1-3;i++){
            if(array[i]>array[i+1]){
                temp = array[i];
                array[i]=array[i+1];
                array[i+1] =temp;
            }
        }
        System.out.println("第四趟遍历");
        System.out.println(Arrays.toString(array));*/

        //一共五个元素，已经确定了4个元素的位置，所以不赢第五趟遍历
    }
}
