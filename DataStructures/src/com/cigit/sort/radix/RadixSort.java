package com.cigit.sort.radix;


import java.util.Arrays;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/11 10:50
 * 基数排序(桶排序)0~9号桶，一共十个桶
 * 1.首先根据最大数的位数决定经过几轮排序
 * 2.第一轮根据个位的数字，将数放入桶中，在根据桶的顺序拿出桶的数据放入原数组中
 * 3.第二轮根据百位放入桶中，，在根据桶的顺序拿出桶的数据放入原数组中，依次类推
 * 遍历结束，取出桶的数据就是有序的
 * 这是一种拿空间（内存空间）换时间的排序算法
 *
 * 若遍历负数，需要把正合负数拆成两个数组分别遍历
 **/
public class RadixSort {
    public static void main(String[] args) {
        int array[] = {53, 3, 542, 748, 14, 214};
        sort(array);
    }

    public static void sort(int[] array) {
        //根据前面推导可得
        //定义一个二维数组表示桶和桶中的数据
        //10表示桶的大小，array.length表示每个桶中最多有多少个元素即桶中的数据，若array.length很大，将很占内存
        //bucket[1][0]=31 表示将31放入一号桶
        int[][] bucket = new int[10][array.length];
        //定义每个桶中实际存放了多少个元素
        //bucketOfElements[1] =1 表示1号桶中有一个元素
        int[] bucketOfElements = new int[10];
        /**
         * 确定最大元素为几位数
         */
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();
        //最大元素为几位数就要遍历几轮：i表示轮数，根据n来获取个十百位上的值
        for (int i = 1, n = 1; i <= maxLength; i++, n *= 10) {
            for (int j = 0; j < array.length; j++) {
                int digitOfElement = array[j] / n % 10;//取出元素每位上的值
                bucket[digitOfElement][bucketOfElements[digitOfElement]] = array[j];//放入桶中
                bucketOfElements[digitOfElement]++;//桶元素个数加1
            }
            //依次遍历每个桶中的元素，将其放入原数组中
            int index = 0;//数组下标
            for(int k =0;k<bucketOfElements.length;k++){
                for (int l = 0; l <bucketOfElements[k] ; l++) {//bucketOfElements[k]桶中有几个元素
                    array[index] = bucket[k][l];//放入原数组
                    index++;//数组下标加1 等同于 array[index++] = bucket[k][l]
                }
                //将每个桶的的元素个数清空  等同于bucketOfElements = new int[10];
                bucketOfElements[k] = 0;
            }
            //最后将所有桶中元素个数清空
            //bucketOfElements = new int[10];
            System.out.println("第"+i+"轮遍历"+ Arrays.toString(array));

        }

       /* //定义一个二维数组表示桶和桶中的数据
        //10表示桶的大小，array.length表示每个桶中最多有多少个元素即桶中的数据，若array.length很大，将很占内存
        //bucket[1][0]=31 表示将31放入一号桶
        int[][] bucket = new int[10][array.length];
        //定义每个桶中实际存放了多少个元素
        //bucketOfElements[1] =1 表示1号桶中有一个元素
        int[] bucketOfElements = new int[10];
        //第一轮桶排序
        for (int i = 0; i < array.length; i++) {
            //取出每个元素的个位
            int digitOfElement = array[i] / 1 % 10;
            //将元素放入桶中
            bucket[digitOfElement][bucketOfElements[digitOfElement]] = array[i];
            //在将桶中元素的个数加1
            bucketOfElements[digitOfElement]++;
        }
        //遍历每个桶中的元素，将其放入原数组
        int index = 0;//定义数组下标
        for (int i = 0; i <bucketOfElements.length ; i++) {//桶的个数，几个桶遍历几次
            for(int j = 0;j<bucketOfElements[i];j++){//每个桶中元素的个数,几个元素遍历几次
                array[index] = bucket[i][j];//将桶中元素放入原数组
                index++;//将数组下标加1
            }
        }
        //每一轮遍历后清空桶中存放的个数
        bucketOfElements = new int[10];
        System.out.println("第一轮遍历"+ Arrays.toString(array));

        //第二轮排序,根据元素的十位放入桶中
        for (int i = 0; i < array.length; i++) {
            //取出每个元素的个位
            int digitOfElement = array[i] / 10 % 10;
            //将元素放入桶中
            bucket[digitOfElement][bucketOfElements[digitOfElement]] = array[i];
            //在将桶中元素的个数加1
            bucketOfElements[digitOfElement]++;
        }
        //遍历每个桶中的元素，将其放入原数组
        index = 0;//定义数组下标
        for (int i = 0; i <bucketOfElements.length ; i++) {//桶的个数，几个桶遍历几次
            for(int j = 0;j<bucketOfElements[i];j++){//每个桶中元素的个数,几个元素遍历几次
                array[index] = bucket[i][j];//将桶中元素放入原数组
                index++;//将数组下标加1
            }
        }
        //每一轮遍历后清空桶中存放的个数
        bucketOfElements = new int[10];
        System.out.println("第二轮遍历"+ Arrays.toString(array));
        //第三轮遍历,根据元素的百位放入桶中
        for (int i = 0; i < array.length; i++) {
            //取出每个元素的个位
            int digitOfElement = array[i] / 100 % 10;
            //将元素放入桶中
            bucket[digitOfElement][bucketOfElements[digitOfElement]] = array[i];
            //在将桶中元素的个数加1
            bucketOfElements[digitOfElement]++;
        }
        //遍历每个桶中的元素，将其放入原数组
        index = 0;//定义数组下标
        for (int i = 0; i <bucketOfElements.length ; i++) {//桶的个数，几个桶遍历几次
            for(int j = 0;j<bucketOfElements[i];j++){//每个桶中元素的个数,几个元素遍历几次
                array[index] = bucket[i][j];//将桶中元素放入原数组
                index++;//将数组下标加1
            }
        }
        //每一轮遍历后清空桶中存放的个数
        bucketOfElements = new int[10];
        System.out.println("第三轮遍历"+ Arrays.toString(array));*/

    }
}
