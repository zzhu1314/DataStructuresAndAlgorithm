package com.cigit.search;

import java.util.ArrayList;

/**
 * 二分查找法
 * 要求：数组必须是有序的
 */
public class BinarySearch {


    public static void main(String[] args) {
           int[] array = {-1,200,675,987,988,989,1000,1000,1001};
        System.out.println(search2(array, 0, array.length - 1, 1000));
    }

    /**
     * 二分查找法：
     * 1.首先找到midValue，if(targetVal>midValue) 右递归
     * 2.首先找到midValue，if(targetVal<midValue) 左递归
     * 退出递归的条件：
     * 1.当midValue==targetVal，即找到时退出递归
     * 2.当leftIndex>rightIndex时，即递归完都无法找到时，退出递归
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @param targetVal
     * @return
     */
    public static int search(int[] array,int leftIndex,int rightIndex,int targetVal){
        int midIndex = (leftIndex+rightIndex)/2;
        if(leftIndex>rightIndex){
            return -1;//递归完无法找到
        }
        if(targetVal>array[midIndex]){
           return search(array,midIndex+1,rightIndex,targetVal);//进行右递归
        }else if(targetVal<array[midIndex]){
           return search(array,leftIndex,midIndex-1,targetVal);//进行左递归
        }else{
            return midIndex;//midValue==targetVal  返回数组下标索引
        }
    }

    /**
     * 若数组中多个结果与targetVal匹配，则找到结果后，在根据值得下标索引，循环遍历，直到越界退出
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @param targetVal
     * @return
     */
    public static ArrayList<Integer> search2(int[] array,int leftIndex,int rightIndex,int targetVal){
        int midIndex = (leftIndex+rightIndex)/2;
        if(leftIndex>rightIndex){
            return new ArrayList<>();//递归完无法找到,返回空集合
        }
        if(targetVal>array[midIndex]){
            return search2(array,midIndex+1,rightIndex,targetVal);//进行右递归
        }else if(targetVal<array[midIndex]){
            return search2(array,leftIndex,midIndex-1,targetVal);//进行左递归
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            int temp = midIndex;
            while(true){
                //先根据找到得第一个目标值,往左边找
                if(temp<0||array[temp]!=targetVal){//当越界或者值不匹配时退出（因为是有序得）
                    break;
                }
                list.add(temp);
                temp--;
            }
            int temp2 = midIndex+1;
            while(true){
                //再往右边找
                if(temp2>array.length-1||array[temp2]!=targetVal){//当越界或者值不匹配时退出（因为是有序得）
                    break;
                }
                list.add(temp2);
                temp2++;
            }
            return list;
        }
    }
}
