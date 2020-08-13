package com.pupu.arithmetic;

/**
 * java模拟链表
 *
 * @author lipu
 * @since 2020-08-13 09:25:13
 */

public class ListNode {
    int val;//当前节点值
    ListNode next;//下一个节点的索引

    //给节点赋值
    ListNode(int x){val = x;}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
