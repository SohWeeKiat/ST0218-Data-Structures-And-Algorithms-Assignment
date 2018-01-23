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
public class ListNode {

    private ListNode next = null;
    private Object data = null;

    public ListNode(Object obj) 
    {
        this(obj, null);
    }
    
    public ListNode(Object obj, ListNode nextNode) 
    {
        data = obj;
        next = nextNode;
    }

    public void setData(Object newData) 
    {
        data = newData;
    }

    public Object getData() 
    {
        return data;
    }

    public void setNext(ListNode next) 
    {
        this.next = next;
    }

    public ListNode getNext() 
    {
        return next;
    }

}
