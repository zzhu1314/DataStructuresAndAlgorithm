package com.cigit.search;

/**
 * 线性查找
 * 数组从头到尾 挨个去比较
 */
public class LinearSearch {


    public static void main(String[] args) {
        int[] array = {1,200,-1,90,39,89};
        System.out.println(search(array, -1));
    }

    /**
     * 找到则返回数组下标索引，找不到则返回-1
     * @param array
     * @param targetVal
     * @return
     */
    public static int search(int[] array,int targetVal ){
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]==targetVal){
                return i;
            }
        }
        return -1;
    }
}
