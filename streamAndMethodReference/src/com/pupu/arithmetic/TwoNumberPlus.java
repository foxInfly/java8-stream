package com.pupu.arithmetic;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author lipu
 * @since 2020-08-13 09:20:49
 */
public class TwoNumberPlus {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next  = new ListNode(4);

        ListNode listNode = addTwoNumbers(node1, node2);
        System.out.println(listNode.val+"->"+listNode.next.val+"->"+listNode.next.next.val);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        System.out.println(l1);
        System.out.println(l2);
        int index =0;  //存进位
        ListNode rootNode = new ListNode(0);//根节点
        ListNode temNode = rootNode;//临时节点，用于存计算后的值

        while (l1 != null || l2 !=null || index != 0){//这里加上index != 0 是为了解决当  l1 = {5},l2={5}的特殊情况。此时l1、l2都为null ,但是index = 1，需要进位。
            //链表1的值
            int l1val = l1!=null?l1.val:0;  //长度不一致时的情况。
            //链表2的值
            int l2val = l2!=null?l2.val:0;

            //链表1的值和链表2的值相加
            int add = l1val + l2val + index;

            if (add < 10)
            {
                temNode.next = new ListNode(add);
                index =0;
            }else {
                temNode.next = new ListNode(add % 10);
                index = 1;
            }

            //把下一个节点赋值给当前临时节点，上移一位
            temNode = temNode.next;
            //取链表的下一个值
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }


        return rootNode.next;

    }

}
