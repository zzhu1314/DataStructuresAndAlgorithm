package com.cigit.sort.shell;

import java.util.Arrays;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/10 11:23
 * 希尔排序:先进行分组,对每组进行排序
 * 当分组==0，即array.length/2==0时跳出循环
 * 思想：希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 *
 * 希尔排序的出现为了解决插入排序时：每次无序集合的元素都比前面有序的小，导致每次都要挨个遍历，导致消耗大量的时间
 **/
public class ShellSort {
    public static void main(String[] args) {
        //int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //sortByChange(array);
        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80000000);
        }
        long l = System.currentTimeMillis();
        //sortByChange(array);
        sortByShifting(array);
        System.out.println("消耗" + (System.currentTimeMillis() - l) + "ms");

    }

    /**
     * 希尔排序之交换法
     * 这种每次都要交换，影响速度
     *
     * @param array
     */
    public static void sortByChange(int[] array) {
        //希尔排序第一轮交换（10/2=5）
        int temp = 0;
        //int count = 0;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                //遍历出的每一个元素，都和同组中的前面排好序的元素比较
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            //System.out.println("第" + (++count) + "轮排序" + Arrays.toString(array));
        }
       /* for (int i = 5; i < array.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (array[j] > array[j + 5]) {
                    temp = array[j];
                    array[j] = array[j + 5];
                    array[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮交换:" + Arrays.toString(array));
        //希尔排序第二轮比较（5/2=2）
        for (int i = 2; i <array.length; i++) {
            for (int j = i-2; j >=0; j-=2) {
                if (array[j] > array[j + 2]) {
                    temp = array[j];
                    array[j] = array[j + 2];
                    array[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮交换:" + Arrays.toString(array));
        //希尔排序第二轮比较（2/2=2）
        for (int i = 1; i <array.length; i++) {
            for (int j = i-1; j >=0; j-=1) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮交换:" + Arrays.toString(array));*/
    }

    /**
     * 移位法，对每次根据增量分组的数据进行插入排序
     * @param array
     */
    public static void sortByShifting(int[] array) {

        //int count =0;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                //对分组的数据进行插入排序
                int j = i;
                int temp = array[j];//第一个值固定
                if (array[j] < array[j-gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    //跳出while循环，即找到对应的位置
                    array[j] = temp;
                }
            }
            //System.out.println("第"+(++count)+"轮排序:" + Arrays.toString(array));
        }
      /*  //移位法第一轮排序
        for (int i = 5; i < array.length; i++) {
            //对每一组进行插入排序
            int j = i;
            int temp = array[j];

            while (j - 5 >= 0 && temp < array[j - 5]) {
                array[j] = array[j - 5];
                j -= 5;
            }
            //如果退出while，表示找到位置了
            array[j] = temp;

        }
        System.out.println("第一轮排序:" + Arrays.toString(array));
        //移位法第二轮排序
        for (int i = 2; i < array.length; i++) {
            //对第二组进行插入排序
            int j = i;
            int temp = array[j];
            while (j - 2 >= 0 && temp < array[j - 2]) {
                array[j] = array[j - 2];
                j -= 2;
                //如果退出while，表示找到位置了
                array[j] = temp;
            }

        }
        System.out.println("第二轮排序:" + Arrays.toString(array));
        //移位法第三轮排序
        for (int i = 1; i < array.length; i++) {
            //对第三组进行插入排序
            int j = i;
            int temp = array[j];
            while (j - 1 >= 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j -= 1;
                //如果退出while，表示找到位置了
                array[j] = temp;
            }

        }
        System.out.println("第三轮排序:" + Arrays.toString(array));*/
    }
}
