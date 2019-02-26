package com.algorithm.link_list;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */


public class LinkedList {
    private Node first;
    private Node last;
    private int size = 0;

//    java.util.LinkedListist

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(this.isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void delete(int index){
//        if(index >= 0 && index < size ){
//            Node newNode;
//            Node tmp;
//            if(first.data == delNode.data){
//
//            }
//
//        }else{
//            return;
//        }


    }

    public void print(){
        Node current = first;
        while (current!=null){
            System.out.println("[" + current.data + "]");
            current = current.next;
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i=1;i<4;i++){
            list.insert(i);
        }
        System.out.println(list);
    }





}

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}