package com.cigit.linkedlist;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/5 11:15
 * 双向链表
 * 好处：1.相比单向链表。双向链表既可以从头部遍历，也可以从尾部遍历
 * 2.在修改和删除不需要借助辅助节点，即不用通单向链表一样，需要找到改节点的上一个节点
 **/
public class DoubleLinkedList {

    private HeroNode firstNode;//链表的第一个节点
    private HeroNode lastNode;//链表的尾结点

    public HeroNode getFirstNode() {
        return firstNode;
    }

    public HeroNode getLastNode() {
        return lastNode;
    }

    /**
     * 直接插入到尾部
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
            addAtLast(heroNode);
    }

    /**
     * 添加到尾结点
     *
     * @param heroNode
     */
    private void addAtLast(HeroNode heroNode) {
        HeroNode l = lastNode;
        lastNode = heroNode;//将最后一个节点指向新元素
        if (l == null) {
           firstNode = heroNode;//首节点和尾节点都指向当前元素
        } else {
            heroNode.pre = l;
            l.next = heroNode;

        }
    }

    /**
     * 根据节点Id有序新增
     */
    public void addBySort(HeroNode heroNode) {

            addSort(heroNode);
    }

    /**
     * 先根据no获取到大于节点位置
     * @param no
     */
    HeroNode getNodeBiggerThanNo(int no){
        HeroNode temp = firstNode;
        while(temp!=null){
            if(temp.no>no){
                return temp;//表明要放在这个节点的前面
            }
            temp=temp.next;
        }
        return null;
    }
    public void addSort(HeroNode heroNode) {
        //1.先获取到比此节点no大的节点
        HeroNode node = getNodeBiggerThanNo(heroNode.no);//放在此节点前面
        if(node==null){//已经遍历到尾节点但依然没找到，就直接放在尾结点
            addAtLast(heroNode);
        }else {
            node.pre.next = heroNode;//获取出来的前一个节点的next指向heroNode
            heroNode.pre = node.pre;//将heroNode的pre指向获取到（node）的pre
            heroNode.next = node;//将heroNode的next指向node
            node.pre = heroNode;//将node的pre指向heroNode
        }
    }

    /**
     * 根据no修改HeroNode
     */
    public void update(HeroNode heroNode){
        HeroNode temp = firstNode;
        if(temp==null){
            System.out.println("空链表，无法修改");
        }
        boolean flag = false;
        while(true){
            if(temp.no==heroNode.no){
                flag=true;
                break;
            }
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name=heroNode.name;
            temp.nickName=heroNode.nickName;
        }else {
            System.out.println("未找到该节点，无法修改");
        }
    }

    /**
     * 删除节点
     */
    public void delete(int no){
        //1.首先找到这个节点
        HeroNode node = node(no);
        if(node==null){
            System.out.println("未找到该节点,删除失败");
            return;
        }
        if(node.pre==null){//表明这是头节点
            firstNode = node.next;
        }else {
            node.pre.next = node.next;//改变前一个节点next的指向
            if(node.next!=null){//防止删除的节点是尾节点，否则会出现空指针异常
                node.next.pre = node.pre;//改变下一个节点的pre指向
            }
        }
        if(node.next==null){//表明这是尾节点
            lastNode = node.pre;
        }
    }
    public HeroNode node(int no){
        //1.从头遍历
        HeroNode cur = firstNode;
        while(cur!=null){
            if(cur.no==no){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public void showList() {
        HeroNode temp = firstNode;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    static class HeroNode {
        private int no;
        private String name;
        private String nickName;
        private HeroNode pre;//前一个节点
        private HeroNode next;//下一个节点

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "神算子");
        doubleLinkedList.addBySort(heroNode1);
        doubleLinkedList.addBySort(heroNode2);
        doubleLinkedList.addBySort(heroNode4);
        doubleLinkedList.addBySort(heroNode3);
        doubleLinkedList.showList();
        System.out.println("修改后。。。。。。。。。。。");
        doubleLinkedList.update(new HeroNode(3,"公孙胜","老夫子"));
        doubleLinkedList.showList();
        System.out.println("删除。。。。。。。。。。。");
        doubleLinkedList.delete(1);
        doubleLinkedList.showList();
        System.out.println("头节点："+doubleLinkedList.getFirstNode());
        System.out.println("尾节点节点："+doubleLinkedList.getLastNode());

    }
}
