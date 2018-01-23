/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.util;

/**
 *
 * @author Wee Kiat
 */
public class LinkList {

    private int noOfElement = 0;
    private ListNode headnode = null;

    public LinkList() 
    {
        
    }

    public LinkList(Object data) 
    {
        add(0, data);
    }

    public boolean isEmpty() 
    {
        return noOfElement == 0;
    }

    public int getNoOfElement() 
    {
        return noOfElement;
    }

    private ListNode find(int index) 
    {
        ListNode current_node = headnode;
        for (int i = 0; i < index; i++) 
            current_node = current_node.getNext();
        return current_node;
    }

    public Object get(int index) throws IndexOutOfBoundsException 
    {
        if (index >= 0 && index < noOfElement) {
            ListNode current_node = find(index);
            Object data = current_node.getData();
            return data;
        } else {
            throw new IndexOutOfBoundsException(
                    "index out of bounds exception on get");
        }
    }

    public void add(int index, Object data) throws IndexOutOfBoundsException 
    {
        if (index >= 0 && index <= noOfElement) {
            if (index == 0) {
                ListNode newnode = new ListNode(data, headnode);
                headnode = newnode;
            } else {
                ListNode prevnode = find(index - 1);
                ListNode newnode = new ListNode(data, prevnode.getNext());
                prevnode.setNext(newnode);
            }
            noOfElement++;
        } else {
            throw new IndexOutOfBoundsException("index out of bounds exception on add");
        }
    }

    public void addLast(Object data) throws IndexOutOfBoundsException 
    {
        add(noOfElement, data);
    }

    public void removeAll() 
    {
        headnode = null;
        noOfElement = 0;
    }

    public void remove(int index) throws IndexOutOfBoundsException 
    {
        if (index >= 0 && index < noOfElement) {
            if (index == 0) {
                headnode = headnode.getNext();
            } else {
                ListNode prevnode = find(index - 1);
                ListNode currnode = prevnode.getNext();
                prevnode.setNext(currnode.getNext());
            }
            noOfElement--;
        } else {
            throw new IndexOutOfBoundsException(
                    "index out of bounds exception on remove");
        }
    }
}
