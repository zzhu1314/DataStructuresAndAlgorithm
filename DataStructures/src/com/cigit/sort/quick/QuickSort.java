package com.cigit.sort.quick;

import java.util.Arrays;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/10 15:41
 * 快速排序
 * 先选出一个中间值（pivot），将大于pivot的放在右边，将小于pivot的放在左边
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {-9,78,0,23,25};
       /* for (int i = 0; i <10 ; i++) {
            array[i] =(int) (Math.random()*80000000);
        }*/
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    /**
     *
     * @param array
     * @param left  左索引
     * @param right 右索引
     */
    public static void sort(int[] array,int left,int right){
        int l = left;
        int r = right;
        int pivot = array[(left+right)/2];//中间值
        //while循环的目的:让比pivot大的放在右边，比pivot小的放在左边
        int temp = 0;
        while(l<r){//当左索引>=右索引时退出循环
            while(array[l]<pivot){//在左边找出比pivot大的值与右边进行交换,找到大的值才退出,若一直找不到则l=(left+right)/2
                l++;
            }
            while(array[r]>pivot){//在右边找出比pivot的小的值与左边进行交换，找到小的值才退出,若一直找不到则r=(left+right)/2
                r--;
            }
            //如果l>=r说明左边全是比pivot小的值，右边全是比pivot大的值
            if(l>=r){
                break;
            }
            //交换
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
        }
        //l==r,必须l++，r--否则会出现栈溢出
         /*if(l==r){
            l++;
            r--;
        }*/
        //向左递归
        if(left<r){
            sort(array,left,r);
        }
        if(right>l){
            sort(array,l,right);
        }
    }
}
