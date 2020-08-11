package com.cigit.sort.merge;

import java.util.Arrays;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/11 14:
 * 归并排序 分治的思想
 * 先拆分 在合并 合并的次数是(array.length-1)
 * 拆分成两个有序数组后，将两个有序数据逐个比较，并放入临时数组，左右两边的有序数组索引也要+1
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[array.length];
        mergeSort(array,0,array.length-1,temp);
        System.out.println("归并后的顺序:"+ Arrays.toString(array));
    }

    /**
     * 分+合并的策略
     * 采用递归的思想拆分
     * @param array 排序的原始数组
     * @param left  最左边的索引
     * @param right 最右边的索引
     * @param temp 临时数组
     */
    public  static void  mergeSort(int[] array,int left,int right,int[] temp){
      if(left<right) {
          int mid = (left + right) / 2;
          //向左递归,拆分左边数组
          mergeSort(array, left, mid, temp);
          //向右递归,拆分右边的数组
          mergeSort(array,mid+1,right,temp);
          //合并
          merge(array,left,mid,right,temp);
      }

    }

    /**
     * 合并的策略
     * @param array 要排序的原始数组
     * @param left  左边有序数组的
     * @param mid   左右两个边有序数组的中间索引
     * @param right 右边有序数组的最右索引
     * @param temp  存放比较后的临时数组
     */
    public static void merge(int[] array, int left, int mid, int right, int temp[]) {

        int i = left;//左边的索引
        int j = mid + 1;//右边有序数组的起始索引
        int index = 0;//临时数组的下标
        //1.两边有序数组都没退出，将左右两边的有序数组比较后拷入临时数组
        while (i <= mid && j <= right) {
            //先处理左边有序数组
            if (array[i] < array[j]) {//如果左边的元素小于右边的元素,把左边元素放入临时数组
                temp[index] = array[i];
                index++;//新数组索引后移
                i++;//左边索引后移
            } else {//右边元素大于左边元素，把右边元素放入临时数组
                temp[index] = array[j];
                index++;//新数组索引后移
                j++;//右边边索引后移
            }
        }
        //2.如果有一边提前退出了拷贝，对左右两边单独处理
        while (i <= mid) {//若果左边元素还有剩余
            temp[index] = array[i];
            i++;
            index++;
        }
        while (j <= right) {//若果右边元素还有剩余
            temp[index] = array[j];
            j++;
            index++;
        }
        //3.将临时数组拷贝至新数组
        //第一次合并 tempLeft=0，right=1；第二次合并 tempLeft=2，right=3；第三次合并tempLeft=0，right=3
        index=0;
        int tempLeft = left;
        while(tempLeft<=right){
            array[tempLeft] = temp[index];
            tempLeft++;
            index++;
        }

    }
}
