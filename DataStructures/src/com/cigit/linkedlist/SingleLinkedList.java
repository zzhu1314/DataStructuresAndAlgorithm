package com.cigit.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/3 15:47
 * 单向链表：
 * 1.链表是以节点的方式存储，是链式存储
 * 2.每个节点包含一个data域，一个next域，指向下一个节点
 * 3.链表在逻辑上是连续存储的，在内存中不一定是连续存储，只是每个节点含有next域，指向下一个节点
 * 4.链表分为带头节点和不带头节点
 **/
public class SingleLinkedList {
    //带头结点，先初始化有个头节点
    private HeroNode head = new HeroNode(0, "", "");

    static class HeroNode {
        private int no;//英雄编号
        private String name;
        private String nickname;
        private HeroNode next;//next默认为null

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }

    /**
     * 不考虑顺序，直接将节点插入到尾部
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;//维持一个中间变量
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 考虑顺序，按no的顺序插入
     */
    public void addByNo(HeroNode heroNode) {
        HeroNode temp = head;//用一个临时节点插入，这个临时节点只能是要插入节点的上一个节点，否则无法插入
        boolean flag = false;//判断是否重复插入
        while (true) {
            if (temp.next == null) {
                break;//说明已经插入到尾部
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;//说明重复插入
            } else if (temp.next.no > heroNode.no) {//若temp的下一个节点比当前大，说明可以插入
                break;//说明可以插入
            }
            temp = temp.next;//向后移
        }
        if (flag) {
            System.out.println("请勿重复插入");
        } else {
            heroNode.next = temp.next;//将当前插入节点的next指向原来temp.next
            temp.next = heroNode;//temp.next指向当前节点，改变前后引用的指向

        }

    }

    /**
     * 修改
     * 1.用一个临时变量指向要修改节点的上一个节点
     * 2.遍历链表，当temp.next==null时说明不存在
     *3.true修改成功,false修改失败
     * @param heroNode
     */
    public boolean update(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//判断节点是否存在
        while (true) {
           if(temp.next==null){
               break;//不存在
           }else if(temp.next.no==heroNode.no){
               flag=true;
               break;
           }
           temp = temp.next;//向后移
        }
        if(flag==true){
            temp.next.name=heroNode.name;
            temp.next.nickname=heroNode.nickname;
        }
        return flag;
    }

    /**
     * 根据no删除节点
     * 1.跟删除一样，只能通过遍历找到该节点的上一个节点，通过该变temp.next的指向，是no对应的节点没有任何引用指向，gc触发时被回收
     * @param no
     * @return
     */
    public boolean delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next==null){
                break;//说明找不到该节点
            }else if(temp.next.no==no){
                flag=true;
                break;
            }
            temp = temp.next;//向后移
        }
        if(flag){
            temp.next=temp.next.next;//指向被删除节点的下一个节点，不管是否为空
        }
        return flag;
    }

    /**
     * 求链表中有效节点的个数
     */
    public int getNodes(){
        HeroNode temp = head.next;//维持一个临时变量
        int count = 0;
        while (temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 查找单链表的倒数第k个节点
     */
    public HeroNode getLastHeroNode(int index){
        int nodes = getNodes();//获取有多少各节点
        int sortIndex = nodes-index;//获取正向索引
        if(sortIndex<0||sortIndex>nodes){
            throw new IndexOutOfBoundsException("链表长度越界");
        }
        int count = -1;
        HeroNode temp = head;
       /* while(true){//第一种变历
            if(count==sortIndex){
                break;
            }
            count++;
            temp =temp.next;
        }*/
        for (int i =0;i<=sortIndex;i++){//第二种变历
            temp = temp.next;
        }
        return temp;
    }

    public HeroNode getHead(){
        return head;
    }
    /**
     * 倒转列表
     */
    public void reverse(){
        HeroNode head = this.getHead();//获取当前链表的头节点;
        HeroNode reverseNode = new HeroNode(0,"","");//创建一个遍历的头节点，用于存放遍历倒叙的节点
        HeroNode cur = head.next;//当前节点
         while(cur!=null){
             HeroNode next = cur.next;
             cur.next =  reverseNode.next;//让当前节点的下一个节点指向新节点的头节点的下一个节点，因为头节点为空不要
             reverseNode.next= cur;//让新节点的头节点指向当前节点
             cur = next;//后移一个节点
         }
        head.next = reverseNode.next;//让原链表的头节点的next节点指向新的节点的next实现链表反转
    }

    /**
     * 实现链表逆序打印
     * 思路1：可以先将链表反转，在实现打印
     * 思路2：将链表压入栈中，先进后出
     */
    public void reversePrint(){
        HeroNode head = this.getHead();//获取当前链表的头节点;
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while ((stack.size()>0)){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序的链表，合并后依然有序
     */
    public void  combine(SingleLinkedList singleLinkedList){
        HeroNode temp = getHead();
        //HeroNode cur = head.next;//当前节点
        HeroNode head = singleLinkedList.getHead();
        HeroNode cur = head.next;
        for(int i =0;cur!=null;i++){
            boolean flag = false;
            while(temp.next!=null){
                if(temp.next.no>cur.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                cur.next = temp.next;
                temp.next = cur;
            }else {
                temp.next = cur;
            }
            cur = cur.next;
        }
    }
    public void showList() {
        HeroNode temp = head.next;//维持一个临时变量
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;

        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "神算子");
        singleLinkedList.addByNo(heroNode1);
        singleLinkedList.addByNo(heroNode2);
        singleLinkedList.addByNo(heroNode3);
        singleLinkedList.addByNo(heroNode4);
        System.out.println("倒排前的节点信息===========================");
        singleLinkedList.showList();
       /* System.out.println("倒排后的节点信息===========================");
        singleLinkedList.reverse();
        singleLinkedList.showList();
        singleLinkedList.reversePrint();*/
            SingleLinkedList singleLinkedList1 = new SingleLinkedList();
            HeroNode heroNode5 = new HeroNode(5, "宋江2", "及时雨2");
            HeroNode heroNode6 = new HeroNode(6, "卢俊义2", "玉麒麟2");
            HeroNode heroNode7= new HeroNode(7, "林冲2", "豹子头2");
            HeroNode heroNode8 = new HeroNode(8, "吴用2", "神算子2");
        singleLinkedList1.addByNo(heroNode5);
        singleLinkedList1.addByNo(heroNode6);
        singleLinkedList1.addByNo(heroNode7);
        singleLinkedList1.addByNo(heroNode8);
        singleLinkedList.combine(singleLinkedList1);
        System.out.println("合并的节点信息===========================");
        singleLinkedList.showList();

    }
}



