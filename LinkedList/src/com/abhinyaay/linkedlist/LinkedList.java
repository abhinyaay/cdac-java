package com.abhinyaay.linkedlist;

public class LinkedList
{
    Node head;
    int count;

    public LinkedList()
    {
        head = null;
        count = 0;
    }

    public int getCount()
    {
        return count;
    }

    public void addLast(Object data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        count++;
    }

    public void addFirst(Object data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public Object getFirst()
    {
        if(head == null)
            return null;
        return head.data;
    }

    public Object getLast()
    {
        if(head == null)
            return null;

        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        return temp.data;
    }

    public Object getAt(int index)
    {
        if(index < 0 || index >= count)
            return null;

        Node temp = head;
        for(int i = 0; i < index; i++)
            temp = temp.next;
        return temp.data;
    }

    public void setAt(int index, Object data)
    {
        if(index < 0 || index >= count)
            return;

        Node temp = head;
        for(int i = 0; i < index; i++)
            temp = temp.next;
        temp.data = data;
    }

    public boolean removeFirst()
    {
        if(head == null)
            return false;

        head = head.next;
        count--;
        return true;
    }

    public boolean removeLast()
    {
        if(head == null)
            return false;

        if(head.next == null)
        {
            head = null;
            count--;
            return true;
        }

        Node temp = head;
        while(temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        count--;
        return true;
    }

    public boolean removeAt(int index)
    {
        if(index < 0 || index >= count)
            return false;

        if(index == 0)
            return removeFirst();

        Node temp = head;
        for(int i = 0; i < index - 1; i++)
            temp = temp.next;
        temp.next = temp.next.next;
        count--;
        return true;
    }

    public void displayAll()
    {
        if(head == null)
        {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
