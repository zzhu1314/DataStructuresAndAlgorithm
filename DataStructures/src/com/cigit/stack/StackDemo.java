package com.cigit.stack;

import java.util.Scanner;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/6 10:20
 * 数据结构--栈
 * 1.栈是一种先进后出的数据结构
 * 栈顶指针会在出栈和入栈过程中一直移动，栈底指针，一直指向栈底的元素，不变
 * java中的stack就是用数组模拟的栈
 **/
public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;//控制是否退出
        while (loop) {
            System.out.println("show:遍历栈");
            System.out.println("pop:出栈");
            System.out.println("push:入栈");
            System.out.println("exit:退出程序");
            String key = scanner.next();
            switch (key) {
                case "show":
                    stack.showList();
                    break;
                case "pop":
                    try {
                        System.out.println(stack.pop());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("栈空~~~");
                    }
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "exit":
                    scanner.close();//关闭流
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class Stack {
    private int[] array = null;
    private int maxSize;//栈的最大容量
    private int top = -1;//栈顶指针

    /**
     * 初始化栈
     *
     * @param maxSize
     */
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("栈满~~~~");
            return;
        }
        top++;//移动栈顶的指针
        array[top] = value;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (top == -1) {
            throw new RuntimeException("栈空~~~");
        }
        int value = array[top];
        top--;//移动栈顶指针
        return value;
    }

    /**
     * 遍历
     */
    public void showList() {
        if (top == -1) {
            System.out.println("栈空~~~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("出栈结果array[%d]=%d \n", i, array[i]);
        }
    }
}
