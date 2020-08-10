package com.cigit.sort.select;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/7 17:10
 * 选择排序法
 * 假设第一个元素是最小元素，每一轮比较选出最小的元素，并与第一个元素交换
 * 选择排序时间复杂度是 O(n^2)
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i <80000 ; i++) {
            array[i] =(int) (Math.random()*80000000);
        }
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        sort(array);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public static void sort(int[] array){
        //总结
        for(int i=0;i<array.length-1;i++) {
            int index = i;
            int temp = array[index];//假设第1个元素是最小的元素
            for (int j = i+1; j < array.length; j++) {
                if (temp > array[j]) {//假设不成立
                    index= j;//重置最小元素的index
                    temp = array[j];//重置最小元素的值
                }
            }
            //通过一轮比较完后在交换两个数的位置，此时就是通过辅助变量temp实现交换
            array[index] = array[i];
            array[i] = temp;
         /*   System.out.printf("第%d趟遍历 \n",i+1);
            System.out.println(Arrays.toString(array));*/
        }
        //拆分
        /**
         * 第一次选出最小的元素
         */
        /*int i =0;
        int temp = array[i];//假设第1个元素是最大的元素
        for(int j = 1;j<array.length;j++){
            if(temp>array[j]){
                i = j;
                temp = array[j];
            }
        }
        //交换选出来的元素的位置
        array[i] = array[0];
        array[0] = temp;
        System.out.println("第一次遍历");
        System.out.println(Arrays.toString(array));
        *//**
         * 第二次选出最小的元素，那么第一个元素就不参与比较
         *//*
          i =1;
          temp = array[i];//假设第2个元素是最大的元素
        for(int j = 2;j<array.length;j++){
            if(temp>array[j]){
                i = j;
                temp = array[j];
            }
        }
        //交换选出来的元素的位置
        array[i] = array[1];
        array[1] = temp;
        System.out.println("第二次遍历");
        System.out.println(Arrays.toString(array));
        *//**
         * 第三次选出最小的元素，那么第一个元素和第二个元素就不参与比较
         *//*
        i =2;
        temp = array[i];//假设第3个元素是最大的元素
        for(int j = 3;j<array.length;j++){
            if(temp>array[j]){
                i = j;
                temp = array[j];
            }
        }
        //交换选出来的元素的位置
        array[i] = array[2];
        array[2] = temp;
        System.out.println("第三次遍历");
        System.out.println(Arrays.toString(array));
        *//**
         * 第四次次选出最小的元素，那么第一个元素和第二个元素，第三个元素就不参与比较
         *//*
        i =3;
        temp = array[i];//假设第3个元素是最大的元素
        for(int j = 4;j<array.length;j++){
            if(temp>array[j]){
                i = j;
                temp = array[j];
            }
        }
        //交换选出来的元素的位置
        array[i] = array[3];
        array[3] = temp;
        System.out.println("第四次遍历");
        System.out.println(Arrays.toString(array));
        //五个元素四次遍历*/
    }

}
