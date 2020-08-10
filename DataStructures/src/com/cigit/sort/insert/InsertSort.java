package com.cigit.sort.insert;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/10 10:11
 * 插入排序
 * 插入排序主要在逻辑上定义两个集合 一个有序集合，一个无序集合，拿无序集合中的第一个元素与有序集合比较，若满足条件则插入
 * 把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
 * 在数组中就假定第一个元素为有序集合，后面的为无序集合
 * 跟码扑克牌类似
 * 先移动后交换
 **/
public class InsertSort {
    public static void main(String[] args) {
             //int[] array ={23,21,34,1,8,12,7,95,63};
             int[] array = new int[80000];
        for (int i = 0; i <80000 ; i++) {
            array[i] =(int) (Math.random()*80000000);
        }
        long l = System.currentTimeMillis();
        sort(array);
        System.out.println("消耗"+(System.currentTimeMillis()-l)+"ms");
    }

    public static void sort(int[] array){
        for (int i = 1; i <array.length ; i++) {
            int  insertIndex = i-1;
            int  insertValue = array[i];
            while(insertIndex>=0&&insertValue<array[insertIndex]){
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1!=i){//当插入的索引跟i比较没变化时就不用交换，表示没有进入while循环
                array[insertIndex+1] = insertValue;
            }
            //System.out.println("第"+i+"次插入");
            //System.out.println(Arrays.toString(array));
        }
        /*//第一次排序
        int insertValue = array[1];
        int insertIndex = 0;//插入在当前元素的前一个
        while(insertIndex>=0&&insertValue<array[insertIndex]){
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;
        }
        array[insertIndex+1] = insertValue;
        System.out.println("第一次插入");
        System.out.println(Arrays.toString(array));

        insertValue = array[2];
        insertIndex = 1;//插入在当前元素的前一个
        while(insertIndex>=0&&insertValue<array[insertIndex]){
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;
        }
        array[insertIndex+1] = insertValue;
        System.out.println("第二次插入");
        System.out.println(Arrays.toString(array));

        insertValue = array[3];
        insertIndex = 2;//插入在当前元素的前一个
        while(insertIndex>=0&&insertValue<array[insertIndex]){
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;
        }
        array[insertIndex+1] = insertValue;
        System.out.println("第三次插入");
        System.out.println(Arrays.toString(array));*/
    }
}
